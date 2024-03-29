package com.POMRepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.RMGOnlineShoppingApp.genericutils.WebDriverUtils;

public class MyCartPage extends WebDriverUtils {

	// Declaration
	@FindBy(xpath = "//button[.='Add to cart']")
	private WebElement addToCartButton;

	@FindBy(name = "remove_code[]")
	private WebElement checkBox;

	@FindBy(xpath = "//div[@class=\"arrow plus gradient\"]")
	private WebElement arrowPlusGradient;

	@FindBy(xpath = "//div[@class=\"arrow minus gradient\"]")
	private WebElement arrowMinusGradient;

	@FindBy(xpath = "//a[.='Continue Shopping']")
	private WebElement continueShoppingLink;

	@FindBy(xpath = "//input[@value=\"Update shopping cart\"]")
	private WebElement updateShoppingCartLink;

	@FindBy(name = "ordersubmit")
	private WebElement proccedToCheckoutButton;

	@FindBy(name = "update")
	private WebElement billingUpdateButton;

	@FindBy(name = "shipupdate")
	private WebElement shippingUpdateButton;

	@FindBy(xpath = "//div[@class=\"total-price-basket\"]")
	private WebElement totalPriceBasket;

	@FindBy(xpath = "//div[@class=\"basket\"]")
	private WebElement basket;

	// Initialization

	public MyCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public WebElement getAddToCartButton() {
		return addToCartButton;
	}

	public WebElement getCheckBox() {
		return checkBox;
	}

	public WebElement getArrowPlusGradient() {
		return arrowPlusGradient;
	}

	public WebElement getArrowMinusGradient() {
		return arrowMinusGradient;
	}

	public WebElement getContinueShoppingLink() {
		return continueShoppingLink;
	}

	public WebElement getUpdateShoppingCartLink() {
		return updateShoppingCartLink;
	}

	public WebElement getProccedToCheckoutButton() {
		return proccedToCheckoutButton;
	}

	public WebElement getBillingUpdateButton() {
		return billingUpdateButton;
	}

	public WebElement getShippingUpdateButton() {
		return shippingUpdateButton;
	}

	public WebElement getTotalPriceBasket() {
		return totalPriceBasket;
	}

	public WebElement getBasket() {
		return basket;
	}
	
//	Business Logic
	public void addDetails(HashMap<String, String> map,WebDriver driver)
	{
		for (Entry<String, String> s : map.entrySet())

		{
			driver.findElement(By.name(s.getKey())).clear();
			driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
		}

	}
	
	public void checkOut()
	{
		proccedToCheckoutButton.click();
	}
	
	public void removeProduct(WebDriver driver)
	{
		checkBox.click();
		updateShoppingCartLink.click();
		acceptAlert(driver);
		acceptAlert(driver);
	}

}
