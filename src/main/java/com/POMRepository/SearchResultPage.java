package com.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

	// Declaration
	@FindBy(xpath = "//li[@class=\"lnk wishlist\"]")
	private WebElement wishlistSearchedProduct;

	@FindBy(xpath = "//button[.='Add to cart']")
	private WebElement addToCartSearchedProduct;

	// Initialization
	public SearchResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public WebElement getWishlistSearchedProduct() {
		return wishlistSearchedProduct;
	}

	public WebElement getAddToCartSearchedProduct() {
		return addToCartSearchedProduct;
	}

}
