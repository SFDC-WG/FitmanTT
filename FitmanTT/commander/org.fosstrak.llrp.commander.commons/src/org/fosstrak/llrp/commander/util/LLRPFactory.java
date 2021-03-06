/*
 *  
 *  Fosstrak LLRP Commander (www.fosstrak.org)
 * 
 *  Copyright (C) 2008 ETH Zurich
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/> 
 *
 */

package org.fosstrak.llrp.commander.util;

import java.util.List;

import org.apache.log4j.Logger;
import org.llrp.ltk.types.LLRPEnumeration;
import org.llrp.ltk.types.LLRPMessage;
import org.llrp.ltk.types.LLRPParameter;
import org.llrp.ltk.types.LLRPType;
import org.llrp.ltkGenerator.generated.ChoiceDefinition;
import org.llrp.ltkGenerator.generated.ChoiceParameterReference;
import org.llrp.ltkGenerator.generated.FieldDefinition;

/**
 * This class lets you generate default LLRP messages automatically.
 *
 * @author Ulrich Etter, ETHZ
 *
 */
public class LLRPFactory {
	
	private static Logger log = Logger.getLogger(LLRPFactory.class);
	
	private static final String MESSAGES_PACKAGE = "org.llrp.ltk.generated.messages";
	private static final String PARAMETERS_PACKAGE = "org.llrp.ltk.generated.parameters";
	private static final String TYPES_PACKAGE = "org.llrp.ltk.types";
	private static final String ENUMERATIONS_PACKAGE = "org.llrp.ltk.generated.enumerations";
	
	/**
	 * Creates a new LLRP message of the given type. All mandatory parameters are set (recursively)
	 * and all fields are initialized by default values. Lists that may not be empty are filled with 
	 * just one parameter. In case of a choice, just the first choice is made.
	 * 
	 * @param messageType the type of the message that should be created (e.g. ADD_ROSPEC)
	 * @return the newly created message
	 */
	public static LLRPMessage createLLRPMessage(String messageType){
		LLRPMessage message = null;
		LLRPTreeMaintainer treeMaintainer = null;
		try {
			Class<?> messageClass = Class.forName(MESSAGES_PACKAGE + "." + messageType);
			message = (LLRPMessage) messageClass.getConstructor(new Class[0]).newInstance(new Object[0]);
			treeMaintainer = new LLRPTreeMaintainer(message);
			
			initializeFields(message, treeMaintainer);
			initializeMandatoryParameters(message, treeMaintainer);

		} catch (Exception e) {
			log.error("could not create llrp message", e);
		}
		return message;
	}
	
	private static LLRPParameter createLLRPParameter(String parameterName, LLRPTreeMaintainer treeMaintainer){
		LLRPParameter parameter = null;
		try {
			Class<?> parameterTypeClass = Class.forName(PARAMETERS_PACKAGE + "." + parameterName);
			parameter = (LLRPParameter) parameterTypeClass.getConstructor(new Class[0]).newInstance(new Object[0]);

			initializeFields(parameter, treeMaintainer);
			initializeMandatoryParameters(parameter, treeMaintainer);
			
		} catch (Exception e) {
			log.error("could not create llrp parameter", e);
		}
		return parameter;
	}

	private static void initializeFields(Object messageOrParameter, LLRPTreeMaintainer treeMaintainer){
		Object messageOrParameterDefinition = treeMaintainer.getDefinition(messageOrParameter);
		for (FieldDefinition fieldDefinition : LLRP.getFieldDefinitions(messageOrParameterDefinition)){
			if (LLRP.isEnumeration(fieldDefinition)){
				LLRPEnumeration enumeration = createLLRPEnumeration(fieldDefinition.getEnumeration());
				treeMaintainer.setField(messageOrParameter, fieldDefinition.getName(), (LLRPType) enumeration);
			}
			else {
				String fieldType = LLRP.getFieldType(fieldDefinition);
				LLRPType fieldValue = null;
				LLRPRangeConstraint rangeConstraint = LLRPConstraints.getRangeConstraint(messageOrParameter, fieldDefinition.getName(), treeMaintainer);
				LLRPArrayConstraint arrayConstraint = LLRPConstraints.getArrayConstraint(messageOrParameter, fieldDefinition.getName(), treeMaintainer);
				if (rangeConstraint != null){
					try {
						fieldValue = createLLRPType(fieldType, Integer.toString(rangeConstraint.getDefaultValue()));
					} catch (Exception e) {
						log.error("could not create llrp type", e);
					}
				}
				else if (arrayConstraint != null){
					try {
						String s = "";
						for (int i = 0; i < arrayConstraint.getDefaultValue().length; i++){
							s = s + arrayConstraint.getDefaultValue()[i];
							if (i < arrayConstraint.getDefaultValue().length - 1){
								s = s + " ";
							}
						}
						fieldValue = createLLRPType(fieldType, s);
					} catch (Exception e) {
						log.error("could not create llrp type", e);
					}
				}
				else{
					fieldValue = createLLRPType(fieldType);
				}
				treeMaintainer.setField(messageOrParameter, fieldDefinition.getName(), fieldValue);
			}
		}
	}
	
	private static void initializeMandatoryParameters(Object messageOrParameter, LLRPTreeMaintainer treeMaintainer) {
		Object messageOrParameterDefinition = treeMaintainer.getDefinition(messageOrParameter);
		for (String childName : LLRP.getParameterAndChoiceNames(messageOrParameterDefinition)){
			
			if (LLRP.canOccurMultipleTimes(messageOrParameterDefinition, childName)){
				if (LLRP.mustOccurAtLeastOnce(messageOrParameterDefinition, childName)){
					String parameterName;
					if (LLRP.isChoice(messageOrParameterDefinition, childName)){
						ChoiceDefinition choiceDefinition = LLRP.getChoiceDefinition(childName);
						List<ChoiceParameterReference> choiceParameterReferences = choiceDefinition.getParameter();
						parameterName = choiceParameterReferences.get(0).getType(); // just use first choice
					}
					else{
						parameterName = childName;
					}
					LLRPParameter parameter = createLLRPParameter(parameterName, treeMaintainer);
					@SuppressWarnings("unchecked")
					List<LLRPParameter> list = (List<LLRPParameter>) treeMaintainer.getChild(messageOrParameter, childName);
					treeMaintainer.addChild(list, parameter);
				}
			}
			else {
				if (LLRP.mustOccurAtLeastOnce(messageOrParameterDefinition, childName)){
					String parameterName;
					if (LLRP.isChoice(messageOrParameterDefinition, childName)){
						ChoiceDefinition choiceDefinition = LLRP.getChoiceDefinition(childName);
						List<ChoiceParameterReference> choiceParameterReferences = choiceDefinition.getParameter();
						parameterName = choiceParameterReferences.get(0).getType(); // just use first choice
					}
					else{
						parameterName = childName;
					}
					LLRPParameter parameter = createLLRPParameter(parameterName, treeMaintainer);
					treeMaintainer.setChild(messageOrParameter, childName, parameter);
				}
			}
		}
	}
	
	private static LLRPType createLLRPType(String typeName){
		LLRPType lLRPType = null;
		try {
			Class<?> fieldTypeClass = Class.forName(TYPES_PACKAGE + "." + typeName);
			lLRPType = (LLRPType) fieldTypeClass.getConstructor(new Class[0]).newInstance(new Object[0]);
		} catch (Exception e) {
			log.error("could not create llrp type", e);
		}
		return lLRPType;
	}
	
	/**
	 * Creates a new LLRPType of the given name with the given value.
	 * 
	 * @param typeName the name of the type to create (e.g. UnsignedInteger)
	 * @param value (e.g. "1")
	 * @return the newly created LLRPType
	 * @throws Exception if the given value can not be parsed
	 */
	public static LLRPType createLLRPType(String typeName, String value) throws Exception{
		LLRPType result = null;
		if (!value.equals("")) {
			Class<?> fieldTypeClass;
			fieldTypeClass =  Class.forName(TYPES_PACKAGE + "." + typeName);
			result = (LLRPType) fieldTypeClass.getConstructor(new Class[]{String.class}).newInstance(new Object[]{value});
		}
		return result;
	}
	
	private static LLRPEnumeration createLLRPEnumeration(String enumerationName){
		LLRPEnumeration enumeration = null;
		try {
			Class<?> enumerationClass = Class.forName(ENUMERATIONS_PACKAGE + "." + enumerationName);
			enumeration = (LLRPEnumeration) enumerationClass.getConstructor(new Class[0]).newInstance(new Object[0]);
		} catch (Exception e) {
			log.error("could not create llrp enumeration", e);
		}
		return enumeration;
	}
}
