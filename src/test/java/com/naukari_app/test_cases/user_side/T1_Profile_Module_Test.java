package com.naukari_app.test_cases.user_side;

import org.testng.annotations.Test;

import com.naukari_app.qa.base.TestBase;
import com.naukari_app.qa.pages.userside.T1_Profile_Module;

public class T1_Profile_Module_Test extends TestBase {
	@Test(priority = 1)
	public void Profile_Module_check() throws InterruptedException {

		T1_Profile_Module p = new T1_Profile_Module(getDriver());
		p.profile_page();
		System.out.println("Profile Test Running 2");

	}
}