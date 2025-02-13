package com.naukari_app.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Data_Utility {
	public String Data_info(String keys) throws IOException {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\MADHU E\\eclipse-workspace\\My_Demo_Frame_work\\src\\main\\java\\com\\naukari\\qa\\config\\Naukari_File_paths");

		Properties pobj = new Properties();
		pobj.load(fis);
		return pobj.getProperty(keys);
	}
}
