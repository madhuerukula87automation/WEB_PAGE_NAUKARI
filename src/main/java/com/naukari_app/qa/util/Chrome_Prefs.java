package com.naukari_app.qa.util;

import java.util.HashMap;

public class Chrome_Prefs {

	public static void captureScreenshot(HashMap<String, Object> chromePrefs2) {

		HashMap<String, Object> chromePrefs = new HashMap<>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", System.getProperty("user.dir") + "\\screenshot\\");

	}

}
