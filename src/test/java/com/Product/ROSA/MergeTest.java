package com.Product.ROSA;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.POMRepository.HomePage;
import com.POMRepository.LoginPage;
import com.POMRepository.MyCartPage;
import com.POMRepository.MyWishlistPage;
import com.POMRepository.OrderHistoryPage;
import com.POMRepository.PaymentMethodPage;
import com.POMRepository.ProductDetailsPage;
import com.RMGOnlineShoppingApp.genericutils.BaseClass;
@Listeners(com.RMGOnlineShoppingApp.genericutils.ListenerImp.class) 
public class MergeTest extends BaseClass {

	@Test
	public void addProductToCartAndRemoveTest() {
		HomePage hp = new HomePage(driver);
		ProductDetailsPage pdp = new ProductDetailsPage(driver);
		MyCartPage mcp = new MyCartPage(driver);
		// Adding a product to cart
		hp.home();
//		hp.getHomeLink().click();
		hp.electronics();
		driver.findElement(By.xpath("//a[text()='Lenovo K6 Power (Silver, 32 GB) '] ")).click();

		pdp.addProductandRemove(driver);
		System.out.println("Product Add");

		// removing the product from cart
		mcp.removeProduct(driver);
		System.out.println("Product Removed");
	}

	@Test
	public void addProductToCartTest() throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		ProductDetailsPage pdp = new ProductDetailsPage(driver);
		MyCartPage mcp = new MyCartPage(driver);
		MyWishlistPage mwp = new MyWishlistPage(driver);
		PaymentMethodPage pmp = new PaymentMethodPage(driver);

		String Product = pLib.readDataFromPropertyFile("product");

		Thread.sleep(5000);

		// Search for the Product (redmi)
		hp.getSeacrhBar().sendKeys(Product);
		hp.getSearchButton().click();
		System.out.println("Product Searched");

		WebElement redmi = driver.findElement(By.xpath("//img[@src=\"admin/productimages/3/mi-redmi-note-4-1.jpeg\"]"));
		redmi.click();
		Thread.sleep(3000);

		// Add product to wish list
		pdp.addToWishlist();
		System.out.println("Product Add to wishlist");

		// Move product from wish list to my cart
		mwp.addToCart();
		System.out.println("Product moved to mycart from wishlist");

		// Click on my cart icon
		hp.myCart();

		// Clear and update billing and shipping address
		// Pass the key and values from the HashMap
		HashMap<String, String> map = eLib.readMultipleData("OSACommonData");
		mcp.addDetails(map, driver);
		System.out.println("Shipping details added");

		// Click on proceed checkout
		mcp.checkOut();

		// Select payment method
		pmp.cod();
		System.out.println("Payment Done through COD");

	}

	@Test
	public void addProductToWishListAndRemoveTest() throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		ProductDetailsPage pdp = new ProductDetailsPage(driver);
		MyWishlistPage mwp = new MyWishlistPage(driver);

		String Product = pLib.readDataFromPropertyFile("product");

		Thread.sleep(5000);

		// Click on home link
		hp.home();

		// search for product
		hp.searchBar(Product);
		System.out.println("Product Searched");
		driver.findElement(By.linkText("Affix Back Cover for Mi Redmi Note 4")).click();

		// Adding to wishlist
		pdp.addToWishlist();
		System.out.println("Product Add to wishlist");

		// Removing from wishlist
		mwp.removeFromWishlist(driver);
		System.out.println("Product removed from wishlist");
	}

	@Test
	public void trackOrderTest() throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		ProductDetailsPage pdp = new ProductDetailsPage(driver);
		MyCartPage mcp = new MyCartPage(driver);
		MyWishlistPage mwp = new MyWishlistPage(driver);
		PaymentMethodPage pmp = new PaymentMethodPage(driver);
		OrderHistoryPage ohp = new OrderHistoryPage(driver);

		String Product = pLib.readDataFromPropertyFile("product");
		String childTitle = "Order Tracking Details";
		String parentTitle = "Order History";

		Thread.sleep(5000);

		// Search for the Product (redmi)
		hp.searchBar(Product);
		System.out.println("Product Searched");

		WebElement redmi = driver.findElement(By.xpath("//img[@src=\"admin/productimages/3/mi-redmi-note-4-1.jpeg\"]"));
		redmi.click();
		Thread.sleep(3000);

		// Add product to wish list
		pdp.addToWishlist();
		System.out.println("Product Add to wishlist");

		// Move product from wish list to my cart
		mwp.addToCart();
		System.out.println("Product Moved to mycart");

		// Click on my cart icon
		hp.myCart();

		// Clear and update billing and shipping address
		// Pass the key and values from the HashMap

		HashMap<String, String> map = eLib.readMultipleData("OSACommonData");

		// MyCartPage mcp = new MyCartPage(driver);
		mcp.addDetails(map, driver);
		System.out.println("Product Shipping details added");

		// Click on proceed checkout
		mcp.checkOut();

		// Select payment method
		pmp.cod();
		System.out.println("Product payment method selected as COD");

		// TrackOrder

		ohp.trackOrder(driver);
		ohp.switchWindow(driver, childTitle);

		String id = driver.findElement(By.xpath("//table/tbody/tr/td[2]")).getText();
		String track = driver.findElement(By.xpath("//table/tbody/tr[3]/td[1]")).getText();
		System.out.println(track);
		System.out.println(id);
		driver.close();

		// Swicthing back to main page
		ohp.switchWindow(driver, parentTitle);

	}
	@Test(retryAnalyzer = com.RMGOnlineShoppingApp.genericutils.RetryImpClass.class)
	public void addReviewTest() throws IOException {
		String URL = pLib.readDataFromPropertyFile("url");
		String UserName = pLib.readDataFromPropertyFile("username");
		String Password = pLib.readDataFromPropertyFile("password");
		String Product = pLib.readDataFromPropertyFile("product");
		
		
		HomePage hp = new HomePage(driver);
		hp.searchBar(Product);

		// Search for the Product (redmi)
		WebElement redmi = driver.findElement(By.xpath("//img[@src=\"admin/productimages/3/mi-redmi-note-4-1.jpeg\"]"));
		redmi.click();

		ProductDetailsPage pdp = new ProductDetailsPage(driver);
		pdp.scroll();

		HashMap<String, String> map = eLib.readMultipleData("ReviewPageCommonData");
		// finding the review

		pdp.review(map, driver);
		
		
	}

}
