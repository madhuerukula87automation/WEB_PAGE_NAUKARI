package com.naukari_app.qa.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naukari_app.qa.base.TestBase;

/**
 * 
 * @author MADHU
 *
 */

public class Helper_s extends TestBase {
	@SuppressWarnings("unused")
	private static final long TimeOut = 0;
	/**
	 * Takes a ScreenShot
	 * 
	 * @param result
	 */

//	public static WebDriver driver;
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	/**
	 * This Method switches to a Alert if present any
	 * 
	 * @return
	 */
	public void isAlertPresent() {
		try {
			getDriver().switchTo().alert();
		} catch (NoAlertPresentException ex) {
		}
	}

	public void AlertAccept() {
		try {
			getDriver().switchTo().alert().accept();
		} catch (NoAlertPresentException ex) {
		}
	}

	public void waitFor(WebElement ele) {
		// waitForPageToLoad();
		// log("Waiting 60 seconds for element :" + ele + " to be visible");
		try {
			new WebDriverWait((WebDriver) driver, Duration.ofSeconds(2000)).until(ExpectedConditions.visibilityOf(ele));
		} catch (Exception e) {
		}
	}

	public void waitForElementToBeClickable(WebElement ele) {
		// waitForPageToLoad();
		// log("Waiting 60 seconds for element :" + ele + " to be visible");
		try {
			new WebDriverWait((WebDriver) driver, Duration.ofSeconds(2000))
					.until(ExpectedConditions.elementToBeClickable(ele));
		} catch (Exception e) {

		}

	}

	public void waitFor(WebElement ele, int time) {
		waitForPageToLoad();
		try {
			new WebDriverWait((WebDriver) driver, Duration.ofSeconds(2000)).until(ExpectedConditions.visibilityOf(ele));
		} catch (Exception e) {
		}
	}

	public void waitForPageToLoad() {
		waitForpage();
		try {
			waitFor(ExpectedConditions
					.invisibilityOfAllElements(getDriver().findElements(By.cssSelector(".preloader"))));
		} catch (Exception e) {
		}
		waitForpage();
	}

	public void waitFor(ExpectedCondition<Boolean> invisibilityOfAllElements) throws InterruptedException {

		Thread.sleep(2000);
	}

	public void waitForpage() {
		try {

			Thread.sleep(5000);
		} catch (Exception e) {

		}
	}

	public void jsCLick(WebElement ele) throws InterruptedException {
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		executor.executeScript("arguments[0].click();", ele);
	}

	public void jsScrollintoview(WebElement Element) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView();", Element);
	}

	public void jsXYCoordinates() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollTo(0,937.6)");
	}

	public void highLightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style', 'background: Cinnamon; border: 2px solid red;');",
				element);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

			System.out.println(e.getMessage());
		}

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);

	}

	public boolean explicitlyWait(WebElement element) {

		try {

			new WebDriverWait(getDriver(), Duration.ofSeconds(2000)).until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (NoSuchElementException e)

		{
			return false;
		}
	}

	/**
	 * This Method can be used to send input as text to input fields
	 * 
	 * @param element
	 * @param arg
	 * @return
	 */
	public boolean enterText(WebElement element, String arg) {

		try {

			element.sendKeys(arg);
			return true;
		} catch (NoSuchElementException e)

		{
			return false;
		}
	}

	public boolean containsAKeyword(String myString, String[] linkText) {
		for (String keyword : linkText) {
			if (myString.contains(keyword)) {
				return true;
			}
		}
		return false; // Never found match.

	}

	public void Scrollintoview(WebElement element) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		/*
		 * This will scroll the page till the element is found
		 */
		js.executeScript("arguments[0].scrollIntoView();", element);

	}

	public boolean selectDropDownValue(WebElement element, String type, String value) {

		try {

			org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(element);

			switch (type) {
			case "index":
				select.selectByIndex(Integer.parseInt(value));
				break;
			case "value":
				select.selectByValue(value);
				break;
			case "visibletext":
				select.selectByVisibleText(value);
				break;

			default:
				System.out.println("please pass the correct selection criteria...");
				break;
			}
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void SwitchtoFrame(WebElement elememt) {
		try {
			getDriver().switchTo().frame(elememt);
		} catch (NoSuchFrameException e) {
			System.out.println(e.getMessage());
		}
	}

	public void SwitchOutOf_iFrame() {
		try {
			getDriver().switchTo().defaultContent();
		} catch (NoSuchFrameException e) {
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("deprecation")
	public void selectFilterValue(List<WebElement> list, String value) {
		try {
			for (WebElement element : list) {
				if (element.getAttribute("innerText").contains(value)) {
					element.click();
				}
			}
		} catch (NoSuchElementException e) {
		}
	}

	public boolean uploadFile(String fileLocation) throws InterruptedException, AWTException {
		try {
			Thread.sleep(1000);
			StringSelection stringSelection = new StringSelection(fileLocation);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			Robot robot = new Robot();
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			Thread.sleep(1000);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(1000);
			robot.keyRelease(KeyEvent.VK_ENTER);

			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void click(WebElement ele) {
//			highLightElement( driver, ele);
		ele.click();
		waitForPageToLoad();
	}

	public void RightClick(WebElement element) throws InterruptedException {
		Actions act = new Actions(getDriver());
		act.contextClick(element).build().perform();
		Thread.sleep(2000);
	}

	public void CntrlAll() throws InterruptedException, AWTException {
		Robot robot1 = new Robot();

		robot1.keyPress(KeyEvent.VK_CONTROL);
		robot1.keyPress(KeyEvent.VK_A);
		Thread.sleep(2000);
		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot1.keyRelease(KeyEvent.VK_A);
		Thread.sleep(2000);
		robot1.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
	}

	public void robot_Zero_option_selectClick() throws InterruptedException, AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	public void robot_frist_option_selectClick() throws InterruptedException, AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void robot1_SelectSecondValuefromRightClick() throws InterruptedException, AWTException {
		Robot robot = new Robot();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);

	}

	public void robot_Second_option_selectClick() throws InterruptedException, AWTException {
		Robot robot = new Robot();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void robot_third_option_selectClick() throws InterruptedException, AWTException {
		Robot robot = new Robot();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void robot_fourth_option_selectClick() throws InterruptedException, AWTException {
		Robot robot = new Robot();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void Robotclick(WebElement Element) throws AWTException, InterruptedException {
		Robot robot = new Robot(); // Robot class throws AWT Exception
		Thread.sleep(2000); // Thread.sleep throws InterruptedException
		robot.keyPress(KeyEvent.VK_DOWN); // press arrow down key of keyboard to navigate and select Save radio button

		Thread.sleep(2000); // sleep has only been used to show case each event separately
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		// press enter key of keyboard to perform above selected action
	}

	public void SelectDropdownValue(WebElement element, String string) {

		org.openqa.selenium.support.ui.Select status = new org.openqa.selenium.support.ui.Select(element);
		status.selectByVisibleText(string);
	}

	public void waitFor(String textToBeDisplayedOnPage) throws InterruptedException {
		try {
			new WebDriverWait((WebDriver) driver, Duration.ofSeconds(2000)).until(ExpectedConditions
					.textToBePresentInElement(driver.get().findElement(By.xpath("//body")), textToBeDisplayedOnPage));
		} catch (Exception e) {
			System.out.println("TEXT WAS NOT FOUND IN THE CURRENT PAGE");
		}

	}

//	public void explicitlyWait(WebElement element, String string)
//	{
//		  WebDriverWait wait=new WebDriverWait((WebDriver) driver, Duration.ofSeconds(20));
//		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Skip']"))).click();
//		
//					
//	}

	public void SelectDropdownValue1(WebElement element, String string) {

		org.openqa.selenium.support.ui.Select status = new org.openqa.selenium.support.ui.Select(element);
		status.selectByVisibleText(string);
	}

	public void waitFor1(String textToBeDisplayedOnPage) throws InterruptedException {
		try {
			new WebDriverWait((WebDriver) driver, Duration.ofSeconds(2000)).until(ExpectedConditions
					.textToBePresentInElement(driver.get().findElement(By.xpath("//body")), textToBeDisplayedOnPage));
		} catch (Exception e) {
			System.out.println("TEXT WAS NOT FOUND IN THE CURRENT PAGE");
		}

	}

	/*
	 * BY Using Actions and mouse over
	 */

	public void move_to_element(WebElement Element) {
		Actions act = new Actions(getDriver());
		act.moveToElement(Element).perform();

	}

	public void move_to_element_click(WebElement Element) {
		Actions act = new Actions(getDriver());
		act.moveToElement(Element).click().build().perform();

	}

	public void move_to_element_click_target(WebElement Element) {
		Actions act = new Actions(getDriver());
		act.moveToElement(Element).click(Element).build().perform();

	}

	public void Double_click(WebElement Element) {
		Actions act = new Actions(getDriver());
		act.doubleClick(Element).perform();

	}

	public void Double_click_target(WebElement Element) {
		Actions act = new Actions(getDriver());
		act.doubleClick(Element).build().perform();

	}

	public void contextClick(WebElement Element) {
		Actions act = new Actions(getDriver());
		act.contextClick(Element).perform();

	}

	public void contextClick_target(WebElement Element) {
		Actions act = new Actions(getDriver());
		act.contextClick(Element).build().perform();

	}

	public void drag_And_Drop(WebElement Element) {
		Actions act = new Actions(getDriver());
		act.dragAndDrop(Element, Element).build().perform();

	}

	public void drag_And_Drop_BY(WebElement Element, WebElement xOffset_vaule, WebElement yOffset_vaule) {
		Actions act = new Actions(getDriver());
		act.dragAndDropBy(Element, 0, 0).build().perform();

	}

	public void clickAndHold(WebElement Element) {
		Actions act = new Actions(getDriver());
		act.release(Element).perform();

	}

	public void clickAndHold_target(WebElement Element) {
		Actions act = new Actions(getDriver());
		act.release(Element).perform();

	}

	public void release(WebElement Element) {
		Actions act = new Actions(getDriver());
		act.release(Element).perform();

	}

	public void release_target(WebElement Element) {
		Actions act = new Actions(getDriver());
		act.release(Element).build().perform();

	}

	/*
	 * Select Class using
	 */

	public void Select_All_Check_boxs(WebElement Element) {
		org.openqa.selenium.support.ui.Select s_All = new org.openqa.selenium.support.ui.Select(Element);
		List<WebElement> select_options = s_All.getAllSelectedOptions();
		int size = select_options.size();

		for (int i = 0; i < size; i++) {

			select_options.get(i).click();

		}
	}

	public void Select(WebElement Element) {
		org.openqa.selenium.support.ui.Select s_All = new org.openqa.selenium.support.ui.Select(Element);
		s_All.getFirstSelectedOption();

	}

	/*
	 * X-path Write in String format
	 */
	public void expility_Wait_2(String X_path_full) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(X_path_full))).click();

	}

	/*
	 * Alert-Pop-up
	 */

	public void Alert_Accept() {
		Alert alt = (Alert) getDriver().switchTo().alert();
		alt.accept();

	}

	public void Alert_Dismiss() {
		Alert alt = (Alert) getDriver().switchTo().alert();
		alt.dismiss();

	}

	public void Alert_getText() {
		Alert alt = (Alert) getDriver().switchTo().alert();
		alt.getText();

	}

	public void Alert_Send_Keys(String message) {
		Alert alt = (Alert) getDriver().switchTo().alert();
		alt.sendKeys(message);

	}

	/*
	 * Open New Window
	 */

	public void open_new_Window() {
		getDriver().switchTo().newWindow(WindowType.WINDOW);

	}

	/*
	 * Open New Tab
	 */

	public void open_new_Tab() {
		getDriver().switchTo().newWindow(WindowType.TAB);

	}

	/*
	 * Take Screen Shot full page
	 */

	public boolean Screen_Shot_full_page(String Screenshot_page_name) throws IOException {

		try {

			TakesScreenshot ts = (TakesScreenshot) getDriver();
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File("./" + "\\Emp-Screen-shots\\" + Screenshot_page_name + ".png");
			FileUtils.copyFile(source, target);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}

	}

	public String getRandomString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;

	}

	public char randomChar() {
		Random r = new Random();
		return (char) (r.nextInt(26) + 'A');
	}

}