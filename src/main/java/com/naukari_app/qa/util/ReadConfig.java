package com.naukari_app.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	static Properties pro;

	public ReadConfig() {
		File src = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\naukari_app\\qa\\config\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);

			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String getApplicationURL(String DevOrUAT) throws InterruptedException {
		String url = null;

		if (DevOrUAT.equalsIgnoreCase("Dev")) {
			url = pro.getProperty("TestUrl");
		} else if (DevOrUAT.equalsIgnoreCase("UAT")) {
			url = pro.getProperty("UATUrl");
		}
		return url;
	}

	public String getUserName()

	{
		String UserName = pro.getProperty("UserName");
		return UserName;
	}

	public String getPassword()

	{
		String Password = pro.getProperty("Password");
		return Password;
	}

	public static String getChromepath()

	{
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}

	public String getEdgePath()

	{
		String edgepath = pro.getProperty("edgepath");
		return edgepath;
	}

	public String getFirefoxpath()

	{
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}

	public String getOperapath()

	{
		String operapath = pro.getProperty("operapath");
		return operapath;
	}

	public static String getProperty(String string) {
		// TODO Auto-generated method stub
		String value = pro.getProperty(string);
		return value;
	}

	/*
	 * Non Admin side
	 */

	public String Non_getUserName()

	{
		String Non_UserName = pro.getProperty("manager_TL_Employee_User");
		return Non_UserName;
	}

	public String Non_getPassword()

	{
		String Non_Password = pro.getProperty("manager_TL_Employee_password");
		return Non_Password;
	}

	public String Non_ApplicationURL(String m_url) throws InterruptedException {
		String Non_url = null;

		if (m_url.equalsIgnoreCase("manager_url")) {
			Non_url = pro.getProperty("manager_TL_Employee_URL");
		}
//else if(DevOrUAT.equalsIgnoreCase("UAT")) {
//	url = pro.getProperty("UATUrl");
//	}
		return Non_url;
	}

}