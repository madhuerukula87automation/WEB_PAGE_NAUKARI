package com.naukari_app.qa.pages.userside;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.naukari_app.qa.base.TestBase;
import com.naukari_app.qa.util.Helper_s;

public class T1_Profile_Module extends Base_Page {

	public T1_Profile_Module(WebDriver driver) {
		super(TestBase.getDriver());
	}

	Helper_s helper = new Helper_s();

	@FindBy(xpath = "//div[@class='nI-gNb-drawer__icon']")

	WebElement profile_logo;

	@FindBy(xpath = "//span[@class='nI-gNb-info__heading-name ']")
	WebElement user_name_check;

	@FindBy(xpath = "")
	WebElement password;

	@FindBy(xpath = "")
	WebElement login_button_2;

	public void profile_page() throws InterruptedException {

		helper.waitFor(profile_logo);
		helper.highLightElement(driver, profile_logo);
		profile_logo.click();
		Reporter.log("<B><font color = 'blue'> Step 1 .</font> Clicked on profile logo  option ");
		Assert.assertTrue(true, "Clicked on profile logo  option F");

		Thread.sleep(5000);

		helper.waitFor(user_name_check);
		helper.highLightElement(driver, user_name_check);
		System.out.println("User Name is :--- " + user_name_check.getText());
		Reporter.log("<B><font color = 'orange'>Step 2 .</font></B> printed user name ");
		Assert.assertTrue(true, " user name Displyed On profile logo");

	}
}
