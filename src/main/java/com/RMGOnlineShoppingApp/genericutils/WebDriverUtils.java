package com.RMGOnlineShoppingApp.genericutils;

import java.awt.AWTException;
import java.awt.Robot;
//import java.awt.Window;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {

	WebDriver driver;
//	WebElement element;

	/*
	 * Implicit wait for the page load
	 */

	public void waitForPageLoad(WebDriver driver,int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}

	/*
	 * Maximize the window
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/*
	 * Minimize the window
	 */

	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/*
	 * Explicit wait until the element is visible
	 */

//	public WebDriverWait explicitWaitObj(WebDriver driver,WebElement element) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		return wait;
//	}

	public void waitUntilEleToBeVisible(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/*
	 * Explicit wait until the element is clickable
	 */

	public void waitUntilEleToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/*
	 * Explicit wait until the Alert is present
	 */

	public void waitUntilAlertisPresent(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.alertIsPresent());

	}
	/*
	 * Explicit wait until the TitleContains is present
	 */
	public void waitUntilTitleContains(WebDriver driver, String Title)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains(Title));	
	}
	

	/*
	 * Create an object to handle the dropdow
	 */
//	public Select dropdownObj( WebElement element) {
//		Select sel = new Select(element);
//		return sel;
//	}

	/*
	 * Selecting dropdown by index using dropdownObj method
	 */
	public void handleDropDown(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/*
	 * Selecting dropdown by value using dropdownObj method
	 */
	public void handleDropDown(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	/*
	 * Selecting dropdown by Visibletext using dropdownObj method
	 */
	public void handleDropDown(String text, WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	/*
	 * Create an object for actions class to handle the methods
	 */
//	public Actions actionsObj() {
//		Actions act = new Actions(driver);
//		return act;
//	}

	/*
	 * This method will drag and drop the element from scr to dst
	 */

	public void dragAndDrop(WebElement src, WebElement desc) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, desc).perform();
	}

	/*
	 * This method will mouse hover on the specified element
	 */

	public void mouseHoverOnElement(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	/*
	 * This method will perform right click on the top most left side of the webpage
	 */
	public void contextClick(WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}

	/*
	 * This method will perform right click on the specified elementin the webpage
	 */
	public void contextclickOnEle(WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	/*
	 * This method will click and hold on the mouse location
	 */
	public void clickAndHold(WebElement element) {
		Actions act = new Actions(driver);
		act.clickAndHold().perform();
	}

	/*
	 * This method will click and hold on the specified element in the webpage
	 */
	public void clickAndHoldEle(WebElement element) {
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();
	}

	/*
	 * This method will click on the mouse location in the webpage
	 */
	public void click(WebElement element) {
		Actions act = new Actions(driver);
		act.click().perform();
	}

	/*
	 * This method will click on the specified element in the webpage
	 */
	public void clickOnEle(WebElement element) {
		Actions act = new Actions(driver);
		act.click(element).perform();
	}

	/*
	 * This method will Double click on the mouse location in the webpage
	 */
	public void doubleClick(WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}

	/*
	 * This method will Double click on the specified element in the webpage
	 */
	public void doubleClickEle(WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	public void scrollByAmt(int x, int y) {
		Actions act = new Actions(driver);
		act.scrollByAmount(x, y).perform();

	}

	public void scrollToEle(WebElement element) {
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();
	}

	/*
	 * Creating object for robot class
	 */
	public Robot robotObj() throws AWTException {
		Robot rob = new Robot();
		return rob;
	}

	public void enterKey() throws AWTException {
		robotObj().keyPress(KeyEvent.VK_ENTER);
	}

	public void enterRelease() throws AWTException {
		robotObj().keyRelease(KeyEvent.VK_ENTER);
	}

	public void enterTAB() throws AWTException {
		robotObj().keyRelease(KeyEvent.VK_TAB);
	}

	/*
	 * Switching driver control to frames based on index
	 */

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/*
	 * Switching driver control to frame based on name or ID
	 */
	public void switchToFrame(WebDriver driver, String nameORid) {
		driver.switchTo().frame(nameORid);
	}

	/*
	 * Switching driver control to frame based on webelement address
	 */
	public void switchToFrame(WebDriver driver, WebElement address) {
		driver.switchTo().frame(address);
	}

	/*
	 * Switching driver controls within the windows
	 */
	public void switchToWindow(WebDriver driver, String expTitle) {
		Set<String> window = driver.getWindowHandles();
		Iterator<String> iter = window.iterator();

		while (iter.hasNext())
		{
			String win = iter.next();
			String currentTitle = driver.switchTo().window(win).getTitle();

			if (currentTitle.contains(expTitle))
			{
				break;
			}
		}
	}

	/*
	 * This method will accept the alert pop-up
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/*
	 * This method will dismiss the alert pop-up
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/*
	 * This method will write sequ of charcters the alert pop-up
	 */
	public void sendkeysAlert(WebDriver driver,String Data) {
		driver.switchTo().alert().sendKeys(Data);
		;
	}

	/*
	 * This method will take Screeshot of complete webpage and store it in folder
	 * called as Screenshot
	 */

	public static String getScreenShot(WebDriver driver,String screenShotName) throws IOException {
		JavaUtils jv = new JavaUtils();
		String ldt = jv.getSystemDate();

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = ".\\screenshot\\" + screenShotName + " " +ldt + ".png";
		File dst = new File(path);
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
	}

	/*
	 * This method will take Screeshot of specified element on webpage and store it
	 * in folder called as Screenshot
	 */
	public String getScreenShotOfEle(WebDriver driver,String screenShotName,WebElement element) throws IOException {
		JavaUtils jv = new JavaUtils();
		String ldt = jv.getSystemDate();

		File tempFile = element.getScreenshotAs(OutputType.FILE);
		String path = ".\\screenshot\\" + screenShotName +" "+ ldt + ".png";
		File permFile = new File(path);
		FileUtils.copyFile(tempFile, permFile);
		return permFile.getAbsolutePath();
	}

	/*
	 * Java Script Executor This method is will perform random scroll
	 */
	public void scrollAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}

	/*
	 * Java Script Executor This method is will perform scroll until the specified
	 * element
	 */
	public void scrollActionUntilEle(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0," + y + ")", element);
	}

}
