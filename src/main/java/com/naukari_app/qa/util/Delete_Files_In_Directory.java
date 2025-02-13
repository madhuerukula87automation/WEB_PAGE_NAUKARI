package com.naukari_app.qa.util;

import java.io.File;

/* 
 * @author MADHU
 *
 */

public class Delete_Files_In_Directory {

	public void deleteFilesInScreenshots(String TargetFile) {

		File dir = new File(TargetFile);

		if (dir.isDirectory() == false) {
			System.out.println("Not a directtory. Do nothing");
			return;
		}
		File[] listFiles = dir.listFiles();
		for (File file : listFiles) {
			System.out.println("Deleting" + file.getName());
			file.delete();
		}
	}

}