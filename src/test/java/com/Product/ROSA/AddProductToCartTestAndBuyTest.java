package com.Product.ROSA;

import java.io.IOException;
//import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.POMRepository.HomePage;
import com.POMRepository.LoginPage;
import com.POMRepository.MyCartPage;
import com.POMRepository.MyWishlistPage;
import com.POMRepository.PaymentMethodPage;
import com.POMRepository.ProductDetailsPage;
import com.RMGOnlineShoppingApp.genericutils.BaseClass;
import com.RMGOnlineShoppingApp.genericutils.ExcelUtils;
import com.RMGOnlineShoppingApp.genericutils.PropertyUtils;
import com.RMGOnlineShoppingApp.genericutils.WebDriverUtils;

public class AddProductToCartTestAndBuyTest extends BaseClass {
	

	@Test
	public void addProductToCartTest() throws IOException, InterruptedException {

		// Create object for generic utils
//		PropertyUtils pLib = new PropertyUtils();
//		ExcelUtils eLib = new ExcelUtils();
//		WebDriverUtils wLib = new WebDriverUtils();
		
//		WebDriver driver = new ChromeDriver();
//		wLib.maximizeWindow(driver);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		wLib.waitForPageLoad(driver, 10);

		// Reading URL from Properties file
//		String URL = pLib.readDataFromPropertyFile("url");
//		String UserName = pLib.readDataFromPropertyFile("username");
//		String Password = pLib.readDataFromPropertyFile("password");
		String Product = pLib.readDataFromPropertyFile("product");

		Thread.sleep(5000);
		// Trigger URL
//		driver.get(URL);

		// Click on Login
		HomePage hp = new HomePage(driver);
//		hp.clickLoginLink();
//		driver.findElement(By.xpath("//a[.='Login']")).click();

		// Login to the Application
//		LoginPage lp = new LoginPage(driver);
//		lp.loginToApp(UserName, Password);
////		driver.findElement(By.name("email")).sendKeys(UserName);
//		driver.findElement(By.name("password")).sendKeys(Password);
//		driver.findElement(By.name("login")).click();

		// Search for the Product (redmi)
		hp.searchBar(Product);
		System.out.println("Product Searched");
//		driver.findElement(By.name("product")).sendKeys(Product);
//		driver.findElement(By.name("search")).submit();

		WebElement redmi = driver.findElement(By.xpath("//img[@src=\"admin/productimages/3/mi-redmi-note-4-1.jpeg\"]"));
		redmi.click();
		Thread.sleep(3000);

		// Add product to wish list
		ProductDetailsPage pdp = new ProductDetailsPage(driver);
		pdp.addToWishlist();
		System.out.println("Product Add to wishlist");

//		driver.findElement(By.xpath(
//				"//div[@class=\"favorite-button m-t-10\"]/parent::div[@class=\"col-sm-6\"]/descendant::a[@class=\"btn btn-primary\"]"))
//				.click();

		// Move product from wish list to my cart
		MyWishlistPage mwp = new MyWishlistPage(driver);
		mwp.addToCart();
		System.out.println("Product moved to mycart from wishlist");
//		driver.findElement(By.xpath("//a[.='Add to cart']")).click();

		// Click on my cart icon
		hp.myCart();
//		driver.findElement(By.xpath("//i[@class=\"icon fa fa-shopping-cart\"]")).click();

		// Clear and update billing and shipping address
		// Pass the key and values from the HashMap

		HashMap<String, String> map = eLib.readMultipleData("OSACommonData");

		MyCartPage mcp = new MyCartPage(driver);
		mcp.addDetails(map, driver);
		System.out.println("Shipping details added");

		// Pass the key and values from the HashMap
//		for (Entry<String, String> s : map.entrySet())
//
//		{
//			driver.findElement(By.name(s.getKey())).clear();
//			driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
//		}

		// Click on proceed checkout
		mcp.checkOut();
//		driver.findElement(By.name("ordersubmit")).click();

		// Select payment method
		PaymentMethodPage pmp = new PaymentMethodPage(driver);
		pmp.cod();
		System.out.println("Payment Done through COD");
//		driver.findElement(By.xpath("//input[@value=\"COD\"]")).click();
//		driver.findElement(By.name("submit")).click();

		// Logout from then application
//		hp.signOut();
//		driver.findElement(By.xpath("//i[@class=\"icon fa fa-sign-out\"]")).click();

	}

}
