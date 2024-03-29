package com.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.RMGOnlineShoppingApp.genericutils.WebDriverUtils;

public class OrderHistoryPage extends WebDriverUtils {
	// Declaration
	@FindBy(xpath = "//table[@class='table table-bordered']/tbody/tr[last()]/td[last()]")
	private WebElement trackOrderLink;

//	 initialization
	public OrderHistoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

// Utalization	
	public WebElement getTrackOrderLink() {
		return trackOrderLink;
	}

// Business logic
	public void trackOrder(WebDriver driver)
	{
		trackOrderLink.click();
	}
	public void switchWindow(WebDriver driver, String Title)
	{
		
		switchToWindow(driver, Title);
		waitUntilTitleContains(driver, Title);
	}

}
