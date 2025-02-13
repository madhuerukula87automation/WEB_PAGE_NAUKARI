package com.naukari_app.qa.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.Augmenter;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import com.naukari_app.qa.base.TestBase;

/**
 * 
 * @author MADHU
 *
 */

public class Screenshot extends TestListenerAdapter {

	public static void captureScreenshot(String screenshotName) {

		try {
			TakesScreenshot ts = (TakesScreenshot) TestBase.getDriver();
			File source = ts.getScreenshotAs(OutputType.FILE);
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
			screenshotName = System.getProperty("user.dir") + "\\screenshots\\" + screenshotName + timeStamp + ".png";
			System.out.print("TargetFile" + screenshotName);
			Object value = new File(screenshotName);
			FileUtils.copyFile(source, (File) value);
			@SuppressWarnings("unused")
			String filePath = screenshotName.toString();

			Reporter.log("<br><img src='" + screenshotName + "  'height ='250' width='250' /><br>");
			System.out.println("Secreenshot test");
			Reporter.log("<a href=\\" + screenshotName + "><img src=" + screenshotName
					+ "  height ='250'  width='250'/> </a>");
			System.out.println("Screenshot taken");

		} catch (Exception e) {
			System.out.println("Exception while taking screenshot" + e.getMessage());
		}

	}

	// test method
	public static void screenCapture1() throws IOException, WebDriverException, InterruptedException {

		File srcFile = ((TakesScreenshot) TestBase.getDriver()).getScreenshotAs(OutputType.FILE);
		@SuppressWarnings("unused")
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		File screenshotName = new File("user.dir" + "\\screenshots\\" + TestBase.getDriver().getTitle() + ".png");
		FileUtils.copyFile(srcFile, screenshotName);
		Reporter.log("<br><img src='" + screenshotName + "'height = '250' width='250' /><br>");

	}

	public String captureScreen() {
		String path;
		try {
			WebDriver augmentedDriver = new Augmenter().augment(TestBase.getDriver());
			File source = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
			path = "./target/screenshots/" + source.getName();
			FileUtils.copyFile(source, new File(path));
		} catch (IOException e) {

			path = "failed to capture screenshot:     " + e.getMessage();
		}
		return path;

	}

	public static String takeScreenshot(String Tsof_Failed_screenshot) {
		String dest = null;
		try {
			TakesScreenshot tc = (TakesScreenshot) TestBase.getDriver();
			File src = tc.getScreenshotAs(OutputType.FILE);
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			dest = System.getProperty("user.dir") + "\\screenshots\\Extentreport\\" + Tsof_Failed_screenshot + timeStamp
					+ ".png";
			File destination = new File(dest);
			FileUtils.copyFile(src, destination);
			System.out.println("Screen shot taken for extent report");
		} catch (Exception ex) {
			System.out.println("Screenshot error is" + ex.getMessage());
		}

		return dest;

	}
}
