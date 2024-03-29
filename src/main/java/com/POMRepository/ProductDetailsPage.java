package com.POMRepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.RMGOnlineShoppingApp.genericutils.WebDriverUtils;

public class ProductDetailsPage extends WebDriverUtils {

	// Declaration
	@FindBy(xpath = "//i[@class='fa fa-heart']")
	private WebElement addToWishlist;

	@FindBy(xpath = "//a[@class='btn btn-primary' and text()=' ADD TO CART']")
	private WebElement addToCart;

	@FindBy(xpath = "//div[@class=\"arrow plus gradient\"]")
	private WebElement arrowPlusGradient;

	@FindBy(xpath = "//div[@class=\"arrow minus gradient\"]")
	private WebElement arrowMinusGradient;

	@FindBy(xpath = "//li[@class=\"active\"]")
	private WebElement reviewLink;

	@FindBy(xpath = "//a[text()='DESCRIPTION']")
	private WebElement descriptionLink;

	@FindBy(xpath = "//table[@class='table table-bordered']/tbody/tr[1]/td[2]")
	private WebElement qualityRating1;

	@FindBy(xpath = "//table[@class='table table-bordered']/tbody/tr[1]/td[3]")
	private WebElement qualityRating2;

	@FindBy(xpath = "//table[@class='table table-bordered']/tbody/tr[1]/td[4]")
	private WebElement qualityRating3;

	@FindBy(xpath = "//table[@class='table table-bordered']/tbody/tr[1]/td[5]")
	private WebElement qualityRating4;

	@FindBy(xpath = "//table[@class='table table-bordered']/tbody/tr[1]/td[6]")
	private WebElement qualityRating5;

	@FindBy(xpath = "//table[@class='table table-bordered']/tbody/tr[2]/td[2]")
	private WebElement priceRating1;

	@FindBy(xpath = "//table[@class='table table-bordered']/tbody/tr[2]/td[3]")
	private WebElement priceRating2;

	@FindBy(xpath = "//table[@class='table table-bordered']/tbody/tr[2]/td[4]")
	private WebElement priceRating3;

	@FindBy(xpath = "//table[@class='table table-bordered']/tbody/tr[2]/td[5]")
	private WebElement priceRating4;

	@FindBy(xpath = "//table[@class='table table-bordered']/tbody/tr[2]/td[6]")
	private WebElement priceRating5;

	@FindBy(xpath = "//table[@class='table table-bordered']/tbody/tr[3]/td[2]")
	private WebElement valueRating1;

	@FindBy(xpath = "//table[@class='table table-bordered']/tbody/tr[3]/td[3]")
	private WebElement valueRating2;

	@FindBy(xpath = "//table[@class='table table-bordered']/tbody/tr[3]/td[4]")
	private WebElement valueRating3;

	@FindBy(xpath = "//table[@class='table table-bordered']/tbody/tr[3]/td[5]")
	private WebElement valueRating4;

	@FindBy(xpath = "//table[@class='table table-bordered']/tbody/tr[3]/td[6]")
	private WebElement valueRating5;

	@FindBy(xpath = "//input[@id='exampleInputName']")
	private WebElement yourNameTextfeild;

	@FindBy(xpath = "//input[@id='exampleInputSummary']")
	private WebElement summary;

	@FindBy(xpath = "//textarea[@id='exampleInputReview']")
	private WebElement review;

	@FindBy(xpath = "//button[@name='submit']")
	private WebElement submitReview;
	
//	Initialization
	public ProductDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getWishlist() {
		return addToWishlist;
	}

	public WebElement getAddToCart() {
		return addToCart;
	}

	public WebElement getArrowPlusGradient() {
		return arrowPlusGradient;
	}

	public WebElement getArrowMinusGradient() {
		return arrowMinusGradient;
	}

	public WebElement getReviewLink() {
		return reviewLink;
	}

	public WebElement getDescriptionLink() {
		return descriptionLink;
	}

	public WebElement getQualityRating1() {
		return qualityRating1;
	}

	public WebElement getQualityRating2() {
		return qualityRating2;
	}

	public WebElement getQualityRating3() {
		return qualityRating3;
	}

	public WebElement getQualityRating4() {
		return qualityRating4;
	}

	public WebElement getQualityRating5() {
		return qualityRating5;
	}

	public WebElement getPriceRating1() {
		return priceRating1;
	}

	public WebElement getPriceRating2() {
		return priceRating2;
	}

	public WebElement getPriceRating3() {
		return priceRating3;
	}

	public WebElement getPriceRating4() {
		return priceRating4;
	}

	public WebElement getPriceRating5() {
		return priceRating5;
	}

	public WebElement getValueRating1() {
		return valueRating1;
	}

	public WebElement getValueRating2() {
		return valueRating2;
	}

	public WebElement getValueRating3() {
		return valueRating3;
	}

	public WebElement getValueRating4() {
		return valueRating4;
	}

	public WebElement getValueRating5() {
		return valueRating5;
	}

	public WebElement getYourNameTextfeild() {
		return yourNameTextfeild;
	}

	public WebElement getSummary() {
		return summary;
	}

	public WebElement getReview() {
		return review;
	}

	public WebElement getSubmitReview() {
		return submitReview;
	}
	
//	Business Logic
	public void addToWishlist()
	{
		addToWishlist.click();
	}
	public void addToCart()
	{
		addToCart.click();
	}
	public void clickOnReview()
	{
		reviewLink.click();
	}
	public void quality()
	{
		qualityRating5.click();
	}
	public void price() 
	{
		priceRating5.click();
	}
	public void value()
	{
		valueRating5.click();
	}
	public void reviewRating5()
	{
		qualityRating5.click();
		priceRating5.click();
		valueRating5.click();
	}
	
	public void yourName(HashMap<String, String> map,WebDriver driver)
	{
		for (Entry<String, String> s : map.entrySet())

		{
			driver.findElement(By.id(s.getKey())).clear();
			driver.findElement(By.id(s.getKey())).sendKeys(s.getValue());
		}
	}
	
	public void submitReview()
	{
		submitReview.click();
	}
	
	public void scroll()
	{
		scrollByAmt(0,600);
	}
	
	public void review(HashMap<String, String> map,WebDriver driver)
	{
//		scrollToEle(review);
		
		waitUntilEleToBeClickable(driver, reviewLink);
		reviewLink.click();
		waitUntilEleToBeClickable(driver, qualityRating5);
		qualityRating5.click();
//		waitUntilEleToBeClickable(driver, priceRating5);
		priceRating5.click();
//		waitUntilEleToBeClickable(driver, valueRating5);
		valueRating5.click();
		for (Entry<String, String> s : map.entrySet())

		{
			driver.findElement(By.id(s.getKey())).clear();
			driver.findElement(By.id(s.getKey())).sendKeys(s.getValue());
		}
//		waitUntilEleToBeClickable(driver, submitReview);
		submitReview.click();
		reviewLink.click();
	}	
	
	public void addProductandRemove(WebDriver driver)
	{
		addToCart.click();
		waitUntilAlertisPresent(driver);
		acceptAlert(driver);
	}
	
}
