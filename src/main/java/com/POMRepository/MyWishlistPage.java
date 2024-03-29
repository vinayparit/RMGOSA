package com.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.RMGOnlineShoppingApp.genericutils.WebDriverUtils;

public class MyWishlistPage extends WebDriverUtils {

	// Declaration
	@FindBy(xpath = "//li[@class=\"lnk wishlist\"]")
	private WebElement wishlistLogo;

	@FindBy(xpath = "//a[.='Add to cart']")
	private WebElement addToCartFromWishlistLink;

	@FindBy(xpath = "//a[@onclick=\"return confirm('Are you sure you want to delete?')\"]")
	private WebElement removeProduct;

	// Initialization
	public MyWishlistPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization

	public WebElement getWishlistLogo() {
		return wishlistLogo;
	}

	public WebElement getAddToCartFromWishlistLink() {
		return addToCartFromWishlistLink;
	}

	public WebElement getRemoveProduct() {
		return removeProduct;
	}
	
	//Business Logic
	public void addToCart()
	{
		addToCartFromWishlistLink.click();
	}
	
	public void removeFromWishlist(WebDriver driver)
	{
		removeProduct.click();
		acceptAlert(driver);
	}
}
