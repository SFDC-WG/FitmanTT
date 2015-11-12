package com.atos.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

/**
* <p>Title: </p>
*
* <p>Description: </p>
*
* <p>Copyright: (c) ATOS - 2014 </p>
*
* <p>Company:  ATOS</p>
*
* @author 
 * @version 1.0
*/
public class PropertyFileReader {
	
	public static String USER_HOME;
	
	public static String CONF_FOLDER;
	public static String FITMAN_FOLDER;
	public static String FITMAN_HOME;
	public static String FITMAN_CONF;


	private Properties property = null;
	
	private String fileName = null;

	public PropertyFileReader(String fileName) {
		if(fileName==null)
			throw new IllegalArgumentException("fileName cannot be null");
		
		this.fileName = fileName;
		
		ResourceBundle labels = ResourceBundle.getBundle("com.atos.rsc.EventManager");
		CONF_FOLDER = File.separator + "conf";
		FITMAN_FOLDER = File.separator + "FITMAN";
		USER_HOME = labels.getString("pathFile");
		FITMAN_HOME = USER_HOME + FITMAN_FOLDER;
		FITMAN_CONF = FITMAN_HOME + CONF_FOLDER;
		
		init();
	}

	private void init() {
		FileInputStream is = null;
		
		try {
			try {
				if(!fileName.startsWith(File.separator))
					fileName = File.separator + fileName;

				// Try to load the local configuration
				is = new FileInputStream(fileName);
			} catch (FileNotFoundException e) {
				fileName = FITMAN_CONF + fileName;

				// Try to load the system configuration
				is = new FileInputStream(fileName);
			}

			property = new Properties();
			property.load(is);
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
			}
		}
	}

	/**
	 * 
	 * @param key
	 *            - the key to be looked up in the property file
	 * @return The value corresponding to the given key.
	 */
	public String getProperty(String key) {
		return property.getProperty(key);
	}
	
	public Object setProperty(String key, String value) {
		return property.setProperty(key, value);
	}
	
	/**
	 * @param key
	 *     - the key to be looked up in the property file
	 * @return The value corresponding to the given key.
	 */
	public Object get(Object key) {
		return property.get(key);
	}
	
	/**
	 * @return The list of keys.
	 */
	public Enumeration<Object> keys() {
		return property.keys();
	}
	
	/**
	 * @return The list of values.
	 */
	public Collection<Object> values() {
		return property.values();
	}
	
	/**
	 * @return The set of keys.
	 */
	public Set<Object> keySet() {
		return property.keySet();
	}
	
	public void update() {
		//Store file
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(fileName);
			property.store(fos, null);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
