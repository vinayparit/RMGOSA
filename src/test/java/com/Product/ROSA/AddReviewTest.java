package com.Product.ROSA;

import java.awt.AWTException;
//import java.awt.Robot;
//import java.awt.event.KeyEvent;

import java.io.IOException;
import java.util.HashMap;
//import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.POMRepository.HomePage;
import com.POMRepository.LoginPage;
import com.POMRepository.ProductDetailsPage;
import com.RMGOnlineShoppingApp.genericutils.ExcelUtils;
import com.RMGOnlineShoppingApp.genericutils.PropertyUtils;
import com.RMGOnlineShoppingApp.genericutils.WebDriverUtils;

public class AddReviewTest {

	@Test
	public void addReviewTest() throws InterruptedException, AWTException, IOException {

		// Create object for generic utils
		WebDriverUtils wLib = new WebDriverUtils();
		ExcelUtils excel = new ExcelUtils();
		PropertyUtils pLib = new PropertyUtils();
		String URL = pLib.readDataFromPropertyFile("url");
		String UserName = pLib.readDataFromPropertyFile("username");
		String Password = pLib.readDataFromPropertyFile("password");
		String Product = pLib.readDataFromPropertyFile("product");
//		

		WebDriver driver = new ChromeDriver();
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver, 10);
		Thread.sleep(5000);

		// triggering the url
		driver.get(URL);
		HomePage hp=new HomePage(driver);
		hp.clickLoginLink();
//		driver.findElement(By.xpath("//a[.='Login']")).click();
		
		// login to the application
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(UserName, Password);
		

//		driver.findElement(By.name("email")).sendKeys(UserName);
//		driver.findElement(By.name("password")).sendKeys(Password);
//		driver.findElement(By.name("login")).click();

		hp.searchBar(Product);
//		driver.findElement(By.name("product")).sendKeys(Product);
//		driver.findElement(By.name("search")).submit();

		// Search for the Product (redmi)
		WebElement redmi = driver.findElement(By.xpath("//img[@src=\"admin/productimages/3/mi-redmi-note-4-1.jpeg\"]"));
		redmi.click();
		
		ProductDetailsPage pdp=new ProductDetailsPage(driver);
		pdp.scroll();
		
		HashMap<String, String> map = excel.readMultipleData("ReviewPageCommonData");
		// finding the review
		
		pdp.review(map, driver);
		
//		WebElement review = driver.findElement(By.xpath("//a[text()='REVIEW']"));
////		wLib.waitUntilEleToBeClickable(review);
//		review.click();
//		WebElement quality = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[5]"));
//		quality.click();
//
//		WebElement price = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[5]"));
//		wLib.waitUntilEleToBeClickable(driver, price);
//		price.click();
//		WebElement value = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[3]/td[5]"));
//		value.click();
//
//		HashMap<String, String> map = excel.readMultipleData("ReviewPageCommonData");
//
//		// Pass the key and values from the HashMap
//		for (Entry<String, String> s : map.entrySet())
//
//		{
//			driver.findElement(By.id(s.getKey())).clear();
//			driver.findElement(By.id(s.getKey())).sendKeys(s.getValue());
//		}
//
//		WebElement submitButton = driver.findElement(By.xpath("//button[@name='submit']"));
//		submitButton.click();
//		driver.findElement(By.xpath("//a[text()='REVIEW']")).click();

	}
}
