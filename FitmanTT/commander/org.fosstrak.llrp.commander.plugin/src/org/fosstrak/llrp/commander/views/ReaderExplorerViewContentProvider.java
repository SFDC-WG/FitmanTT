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

package org.fosstrak.llrp.commander.views;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.fosstrak.llrp.client.Constants;
import org.fosstrak.llrp.commander.ResourceCenter;
import org.fosstrak.llrp.commander.llrpaccess.LLRPAccess;
import org.fosstrak.llrp.commander.llrpaccess.exception.LLRPAccessException;


/**
 * This class perform as <strong>Content Provider</strong> for RFID Reader's View.
 * It implements Eclipse's IStructuredContentProvider and ITreeContentProvider. The
 * Reader lists would load from <strong>ResourceCenter</strong>.
 *
 * @author Haoning Zhang
 * @version 1.0
 */
public class ReaderExplorerViewContentProvider implements
		IStructuredContentProvider, ITreeContentProvider {
	
	/**
	 * Log4j instance.
	 */
	private static Logger log = Logger.getLogger(ReaderExplorerViewContentProvider.class);
	
	/**
	 * The root node, which is invisible in tree view.
	 */
	private ReaderTreeObject invisibleRoot;
	
	/**
	 * Container to hold the adapter tree nodes.
	 */
	private Map<String, ReaderTreeObject> adapters;

	/**
	 * Retrieve all the child nodes.
	 */
	public Object[] getElements(Object parent) {
		log.debug("Loading Readers...");
		loadReaders();
		return getChildren(invisibleRoot);
	}

	/**
	 * Get the parent node.
	 */
	public Object getParent(Object child) {
		if (child instanceof MessageBoxTreeObject) {
			return ((MessageBoxTreeObject) child).getParent();
		}
		return null;
	}

	/**
	 * Retrieve all the child nodes.
	 */
	public Object[] getChildren(Object parent) {
		if (parent instanceof ReaderTreeObject) {
			return ((ReaderTreeObject) parent).getChildren();
		}
		return new Object[0];
	}

	/**
	 * Judge whether the tree node has children.
	 */
	public boolean hasChildren(Object parent) {
		if (parent instanceof ReaderTreeObject)
			return ((ReaderTreeObject) parent).hasChildren();
		return false;
	}
	
	/**
	 * Create the tree node refer to the Adapter. 
	 * @param aRoot Root node in the tree
	 * @param aName Logical Name for the adapter
	 * @return
	 */
	private ReaderTreeObject addAdapter(ReaderTreeObject aRoot, String aName) {
		ReaderTreeObject adapter = new ReaderTreeObject(aName);
		aRoot.addChild(adapter);
		
		adapters.put(aName, adapter);
		return adapter;
	}
	
	/**
	 * Get the tree node refer to the Adapter. If there is no instance, then create it.
	 * @param aRoot Root node in the tree
	 * @param aName Logical Name for the adapter
	 * @return
	 */
	private ReaderTreeObject getAdapterNode(ReaderTreeObject aRoot, String aName) {
		ReaderTreeObject adapter = adapters.get(aName);
		if (null == adapter) {
			adapter = addAdapter(aRoot, aName);
		}
		return adapter;
	}
	
    /**
     * Generate one Reader node instance.
     *
     * @param aAdapterParent ReaderTreeObject the parent Adapter node for this Reader
     * @param aName String Reader's name, which will display in the tree.
     * @param isConnected Whether the reader is connected.
     */
	private void addReader(ReaderTreeObject aRoot, String aAdaptorName, String aReaderName, boolean isConnected) {
		
		log.debug("addAdaptor " + aReaderName + " on " + aAdaptorName);
		
		ReaderTreeObject readerNode = new ReaderTreeObject(aReaderName);
		readerNode.setReader(true);
		readerNode.setConnected(isConnected);
		
		if (ResourceCenter.getInstance().existReaderConfig(aAdaptorName, aReaderName)) {
			readerNode.setGetReaderConfig(true);
		} else {
			readerNode.setGetReaderConfig(false);
		}
		
		if (ResourceCenter.getInstance().existReaderROSpec(aAdaptorName, aReaderName)) {
			readerNode.setGetReaderROSpec(true);
		} else {
			readerNode.setGetReaderROSpec(false);
		}
			
		ReaderTreeObject adapterNode = getAdapterNode(aRoot, aAdaptorName);
		adapterNode.addChild(readerNode);
		
		//MessageBoxTreeObject inboxNode = new MessageBoxTreeObject(MessageBoxTreeObject.INBOX_NAME);
		//MessageBoxTreeObject outboxNode = new MessageBoxTreeObject(MessageBoxTreeObject.OUTBOX_NAME);
		
		//readerNode.addChild(inboxNode);
		//readerNode.addChild(outboxNode);
	}

	/**
	 * Load reader information from Reader Management. 
	 */
	private void loadReaders() {
		
		// Initial the Adapter nodes
		adapters = new HashMap<String, ReaderTreeObject>();
		
		// Create the reserved nodes in the tree view
		ReaderTreeObject rootAdapters = new ReaderTreeObject(
				Constants.ROOT_NAME);
		
		LLRPAccess llrpAccess = ResourceCenter.getInstance().getLLRPAccess();
		log.debug("Retrieving Adaptor Lists from Adapter Management");
		try {
			for (String adapterName : ResourceCenter.getInstance().getLLRPAccess().getAdaptorNames() ) {
				log.debug("Get Adaptor-" + adapterName + " ...");
				List<String> readerList = llrpAccess.getReaderNames(adapterName);
				if (readerList.size() == 0) {
					// add empty adaptor
					getAdapterNode(rootAdapters, adapterName);
				} else {
					for (String readerName : readerList) {
						addReader(rootAdapters, adapterName, readerName, llrpAccess.isReaderConnected(adapterName, readerName));
					}
				}
			}
		} catch (LLRPAccessException llrpe) {
			log.debug("could not initialize the adapter/reader tree", llrpe);
		}

		invisibleRoot = new ReaderTreeObject("");
		invisibleRoot.addChild(rootAdapters);
	}
	
	/**
	 * The handler to process content change.
	 */
	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
	}

	/**
	 * Dispose resources in the tree.
	 */
	public void dispose() {
	}
}
