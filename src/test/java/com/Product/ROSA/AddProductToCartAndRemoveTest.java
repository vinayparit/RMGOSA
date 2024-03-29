package com.Product.ROSA;

//import java.io.FileInputStream;
import java.io.IOException;
//import java.time.Duration;
//import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.POMRepository.HomePage;
import com.POMRepository.LoginPage;
import com.POMRepository.MyCartPage;
import com.POMRepository.ProductDetailsPage;
import com.RMGOnlineShoppingApp.genericutils.BaseClass;
//import com.RMGOnlineShoppingApp.genericutils.ExcelUtils;
import com.RMGOnlineShoppingApp.genericutils.PropertyUtils;
import com.RMGOnlineShoppingApp.genericutils.WebDriverUtils;

public class AddProductToCartAndRemoveTest extends BaseClass {

	@Test
	public void addProductToCartAndRemoveTest() throws IOException, InterruptedException {
		// Create object for generic utils
//		PropertyUtils data = new PropertyUtils();
//		ExcelUtils excel = new ExcelUtils();
//		WebDriverUtils wLib = new WebDriverUtils();

//		WebDriver driver = new ChromeDriver();
//		wLib.maximizeWindow(driver);
//		wLib.waitForPageLoad(driver, 10);

		// Reading URL from Properties file
//		String URL = pLib.readDataFromPropertyFile("url");
//		String UserName = pLib.readDataFromPropertyFile("username");
//		String Password = pLib.readDataFromPropertyFile("password");

//		Thread.sleep(5000);
		// Trigger URL
//		driver.get(URL);

		// Click on Login
		HomePage hp = new HomePage(driver);
//		hp.clickLoginLink();
		
//		driver.findElement(By.xpath("//a[.='Login']")).click();

		// Login to the Application
//		LoginPage lp = new LoginPage(driver);
//		lp.loginToApp(UserName, Password);
		
//		driver.findElement(By.name("email")).sendKeys(UserName);
//		driver.findElement(By.name("password")).sendKeys(Password);
//		driver.findElement(By.name("login")).click();

		// Adding a product to cart
		hp.home();
		hp.electronics();
//		driver.findElement(By.xpath("//a[@class='dropdown-toggle'and .='Home']")).click();
//		driver.findElement(By.xpath(" //a[text()=' Electronics']")).click();
		driver.findElement(By.xpath("//a[text()='Lenovo K6 Power (Silver, 32 GB) '] ")).click();
		
		ProductDetailsPage pdp=new ProductDetailsPage(driver);
		pdp.addProductandRemove(driver);
		System.out.println("Product Add");
//		driver.findElement(By.xpath("//a[@class='btn btn-primary' and text()=' ADD TO CART']")).click();
//		wLib.waitUntilAlertisPresent(driver);
//		wLib.acceptAlert(driver);
		// driver.switchTo().alert().accept();

		// removing the product from cart
		MyCartPage mcp=new MyCartPage(driver);
		mcp.removeProduct(driver);
		System.out.println("Product Removed");
//		driver.findElement(By.name("remove_code[]")).click();
//		driver.findElement(By.name("submit")).click();
//		wLib.acceptAlert(driver);

		// logout
//		hp.signOut();
//		driver.findElement(By.xpath("//i[@class='icon fa fa-sign-out']")).click();

	}
}
