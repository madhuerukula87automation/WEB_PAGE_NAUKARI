package com.naukari_app.qa.pages.userside;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.naukari_app.qa.base.TestBase;
import com.naukari_app.qa.util.Helper_s;

public class Login_Page extends Base_Page {

	public Login_Page(WebDriver driver) throws InterruptedException {
		super(TestBase.getDriver());
	}

	Helper_s helper = new Helper_s();

	// ELEMENTS ON LOGIN PAGE:

	@FindBy(xpath = "//a[text()='Login']")

	WebElement login_button_1;

	@FindBy(xpath = "//input[@placeholder='Enter your active Email ID / Username']")
	WebElement user_name;

	@FindBy(xpath = "//input[@placeholder='Enter your password']")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement login_button_2;

	/*
	 * Employee_Side Login
	 */

	@FindBy(xpath = "")
	WebElement user;

	@FindBy(xpath = "")
	WebElement non_pwd;

	@FindBy(xpath = "")
	WebElement login_button;

	public void login(String un, String pwd) throws InterruptedException {

		helper.highLightElement(driver, login_button_1);
		login_button_1.click();
		;
		Reporter.log("<B><font color = 'orange'>Username .</font></B> Entered User ID");

		helper.highLightElement(driver, user_name);
		user_name.sendKeys(un);
		Reporter.log("<B><font color = 'orange'>Username .</font></B> Entered User ID");

		helper.highLightElement(driver, password);
		password.sendKeys(pwd);
		Reporter.log("<B><font color = 'orange'>Password .</font></B> Entered Password");

		helper.highLightElement(driver, login_button_2);
		login_button_2.click();
		Reporter.log("<B><font color = 'orange'>Sign In Button .</font></B> Clicked on Submit Button");

		Thread.sleep(3000);

		/*
		 * Employee side
		 */
//				helper.highLightElement(driver, user);
//				user.sendKeys(un);
//				Reporter.log("<B><font color = 'orange'>Username .</font></B> Entered User ID");		
//				
//				helper.highLightElement(driver, non_pwd);
//				non_pwd.sendKeys(pwd);
//				Reporter.log("<B><font color = 'orange'>Password .</font></B> Entered Password");
		//
//				helper.highLightElement(driver, login_button);
//				login_button.click();		
//				Reporter.log("<B><font color = 'orange'>Sign In Button .</font></B> Clicked on Submit Button");
//			
//				Thread.sleep(3000);

	}
}
