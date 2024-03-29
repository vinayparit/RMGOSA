package com.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	// Declaration
	@FindBy(xpath = "//a[.='Login']")
	private WebElement loginLink;

	@FindBy(xpath = "//input[@class=\"search-field\"]")
	private WebElement seacrhBar;

	@FindBy(xpath = "//button[@class=\"search-button\"]")
	private WebElement searchButton;

	@FindBy(xpath = "//a[.='My Cart']")
	private WebElement myCartLink;

	@FindBy(xpath = "//a[.='Wishlist']")
	private WebElement wishlistLink;

	@FindBy(xpath = "//a[.='My Account']")
	private WebElement myAccountLink;

	@FindBy(xpath = "//a[.='Track Order']")
	private WebElement trackOrderLink;

	@FindBy(xpath = "//a[.='Home']")
	private WebElement homeLink;

	@FindBy(xpath = "//a[.=' Electronics' ]")
	private WebElement electronicsLink;

	@FindBy(xpath = "//a[.=' Fashion']")
	private WebElement fashionLink;

	@FindBy(xpath = "//a[.=' KIDS']")
	private WebElement kidsLink;

	@FindBy(xpath = "//a[.=' ornaments']")
	private WebElement ornamentsLink;

	@FindBy(xpath = "//a[.=' Bicycles']")
	private WebElement bicyclesLink;
	
	@FindBy(xpath = "//i[@class=\"icon fa fa-sign-out\"]")
	private WebElement signOut;

	
	// Initialization

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	// Utilization
	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getSeacrhBar() {
		return seacrhBar;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getMyCartLink() {
		return myCartLink;
	}

	public WebElement getWishlistLink() {
		return wishlistLink;
	}

	public WebElement getMyAccountLink() {
		return myAccountLink;
	}

	public WebElement getTrackOrderLink() {
		return trackOrderLink;
	}

	public WebElement getHomeLink() {
		return homeLink;
	}

	public WebElement getElectronicsLink() {
		return electronicsLink;
	}

	public WebElement getFashionLink() {
		return fashionLink;
	}

	public WebElement getKidsLink() {
		return kidsLink;
	}

	public WebElement getOrnamentsLink() {
		return ornamentsLink;
	}

	public WebElement getBicyclesLink() {
		return bicyclesLink;
	}
	
	public WebElement getSignOut() {
		return signOut;
	}
	

//	Business Logic

	public void clickLoginLink() {
		loginLink.click();
	}
	
	public void searchBar(String Product) {
		seacrhBar.sendKeys(Product);
		searchButton.click();
	}
	
	public void home()
	{
		homeLink.click();
	}
	
	public void myCart()
	{
		myCartLink.click();
	}
	
	public void signOut()
	{
		signOut.click();
	}
	public void electronics()
	{
		electronicsLink.click();
	}
	
}
