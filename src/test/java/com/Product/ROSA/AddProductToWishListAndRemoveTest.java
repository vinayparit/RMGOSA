package com.Product.ROSA;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.POMRepository.HomePage;
import com.POMRepository.LoginPage;
import com.POMRepository.MyWishlistPage;
import com.POMRepository.ProductDetailsPage;
import com.RMGOnlineShoppingApp.genericutils.BaseClass;
//import com.RMGOnlineShoppingApp.genericutils.ExcelUtils;
//import com.RMGOnlineShoppingApp.genericutils.JavaUtils;
import com.RMGOnlineShoppingApp.genericutils.PropertyUtils;
import com.RMGOnlineShoppingApp.genericutils.WebDriverUtils;

public class AddProductToWishListAndRemoveTest extends BaseClass {

	@Test
	public void addProductToWishListAndRemoveTest() throws InterruptedException, IOException {
		// Create object for generic utils
//		PropertyUtils pLib = new PropertyUtils();
//				ExcelUtils eLib = new ExcelUtils();
//		WebDriverUtils wLib = new WebDriverUtils();

		// Open Browser
//		WebDriver driver = new ChromeDriver();
		// Maximize Browser
//		wLib.maximizeWindow(driver);
		// Implicit wait unitl page is loaded
//		wLib.waitForPageLoad(driver, 10);

		// Reading URL from Properties file
//		String URL = pLib.readDataFromPropertyFile("url");
//		String UserName = pLib.readDataFromPropertyFile("username");
//		String Password = pLib.readDataFromPropertyFile("password");
		String Product = pLib.readDataFromPropertyFile("product");

		Thread.sleep(5000);
		// Trigger URL
//		driver.get(URL);

		// Click on loginLink
		HomePage hp = new HomePage(driver);
//		hp.clickLoginLink();
//		driver.findElement(By.xpath("//a[.='Login']")).click();

		// Login to the Application

		LoginPage lp = new LoginPage(driver);
//		lp.loginToApp(UserName, Password);
//		driver.findElement(By.name("email")).sendKeys(UserName);
//		driver.findElement(By.name("password")).sendKeys(Password);
//		driver.findElement(By.name("login")).click();
//		Thread.sleep(3000);

//		Click on home link
		hp.home();
//		driver.findElement(By.xpath("//a[@class='dropdown-toggle'and .='Home']")).click();

// 		search for product
		hp.searchBar(Product);
		System.out.println("Product Searched");
//		driver.findElement(By.name("product")).sendKeys(Product);
//		driver.findElement(By.xpath("//button[@class='search-button']")).click();
		driver.findElement(By.linkText("Affix Back Cover for Mi Redmi Note 4")).click();

// 		Adding to wishlist
		ProductDetailsPage pdp=new ProductDetailsPage(driver);
		pdp.addToWishlist();
		System.out.println("Product Add to wishlist");
//		driver.findElement(By.xpath("//i[@class='fa fa-heart']")).click();

// 		Removing from wishlist
		MyWishlistPage mwp=new MyWishlistPage(driver);
		mwp.removeFromWishlist(driver);
		System.out.println("Product removed from wishlist");
		
//		driver.findElement(By.xpath("//i[@class='fa fa-times']")).click();
//		wLib.acceptAlert(driver);

		// logout
//		hp.signOut();
//		driver.findElement(By.xpath("//i[@class='icon fa fa-sign-out']")).click();

	}

}
