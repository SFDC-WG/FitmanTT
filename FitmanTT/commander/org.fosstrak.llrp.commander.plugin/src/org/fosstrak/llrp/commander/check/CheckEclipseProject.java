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

package org.fosstrak.llrp.commander.check;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.net.URL;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.fosstrak.llrp.commander.LLRPPlugin;
import org.fosstrak.llrp.commander.ResourceCenter;

/**
* Performs a sanity check on the eclipse folder required by the LLRP Commander. 
* In case that the folder is corrupt, the method <code>fixIt</code> tries to 
* auto-repair the corrupt parts of the folder. 
* @author zhanghao
* @author sawielan
*
*/
public class CheckEclipseProject extends CheckItem {

	/** log4j logger. */
	private static Logger log = Logger.getLogger(CheckEclipseProject.class);
	
	public boolean validate() {
		
		this.clearAllReport();
		
		String projectName = ResourceCenter.getInstance().getEclipseProjectName();
		IProject project = ResourceCenter.getInstance().getEclipseProject();
		
		if (null == project) {
			addReportItem("Eclipse Project '" + projectName + "' doesn't exist.", CATEGORY_ERROR);
//			addReportItem("If you are using this tool for the first time, please click the 'Fix it!' button to " +
//					"initialize the project folder.", this.CATEGORY_INFO);
			return false;
		}
		
		try {
			// open if necessary
			if (project.exists() && !project.isOpen()) {
				project.open(null);
			}

			IFolder msgFolder = project
					.getFolder(ResourceCenter.REPO_SUBFOLDER);
			IFolder draftFolder = project
					.getFolder(ResourceCenter.DRAFT_SUBFOLDER);

			if (!msgFolder.exists()) {
				addReportItem("Subfolder '" + ResourceCenter.REPO_SUBFOLDER
						+ "' doesn't exist.", CATEGORY_ERROR);
			}

			if (!draftFolder.exists()) {
				addReportItem("Subfolder '" + ResourceCenter.DRAFT_SUBFOLDER
						+ "' doesn't exist.", CATEGORY_ERROR);
			}
			
			if (!msgFolder.exists() || !draftFolder.exists()) {
				return false;
			}

		} catch (Exception e) {
			return false;
		}
	
		return true;
	}
	
	public void fix() {
		
		this.clearAllReport();
		
		String projectName = ResourceCenter.getInstance().getEclipseProjectName();
		
		IProgressMonitor progressMonitor = new NullProgressMonitor();

		try {
			IWorkspaceRoot myWorkspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
			IProject project = myWorkspaceRoot.getProject(projectName);
			if (!project.exists()) {
				project.create(null);
				project.open(null);
				
				log.debug("created project " + projectName);
				addReportItem("Project '" + projectName	+ "' created.", CATEGORY_FIX);
			}
			
			if (project.exists() && !project.isOpen()) {
				try {
					project.open(null);
				} catch (Exception e) {
					// recreate the project ...
					// first remove it from eclipse cache stuff...
					project.delete(true, null);
					project.create(null);
					project.open(null);
				}
				log.debug("opened project " + projectName);
			}
			
			//Try to add subfolder for repository messages
			IFolder msgFolder = project.getFolder(ResourceCenter.REPO_SUBFOLDER);
			if (!msgFolder.exists()) {
				msgFolder.create(true, false, progressMonitor);
				
				addReportItem("Subfolder '" + ResourceCenter.REPO_SUBFOLDER	+ "' created.", CATEGORY_FIX);
			}
			
			
			IFolder draftFolder = project.getFolder(ResourceCenter.DRAFT_SUBFOLDER);
			if (!draftFolder.exists()) {
				draftFolder.create(true, true, progressMonitor);
				
				addReportItem("Subfolder '" + ResourceCenter.DRAFT_SUBFOLDER + "' created.", CATEGORY_FIX);
				
				URL bundleRoot = LLRPPlugin.getDefault().getBundle().getEntry("/sampleXML");
				
				try {
					URL fileURL = FileLocator.toFileURL(bundleRoot);
					File folderSource = new File(fileURL.getPath());
					
					FilenameFilter filter = new FilenameFilter() {
				        public boolean accept(File dir, String name) {
				            return name.endsWith(".llrp");
				        }
				    };
				    
				    String[] sampleFileNames = folderSource.list(filter);
				    
				    for (int i = 0; i < sampleFileNames.length; i ++) {
				    	String urlFile = fileURL.getPath() + "/" + sampleFileNames[i];
				    	File sampleFile = new File(urlFile);
				    	
				    	IFile file = project.getFile(ResourceCenter.DRAFT_SUBFOLDER + "/" + sampleFileNames[i]);
				    	
				    	file.create(new FileInputStream(sampleFile), true, progressMonitor);
				    }
				    
				} catch (Exception e) {
					log.error("could not process the draft folder", e);
				} 
				
				log.debug("fixed project");
			}

		} catch (CoreException coe) {
			log.error("received core exception", coe);
		}
	}
	
}
