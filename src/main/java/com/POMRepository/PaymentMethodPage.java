package com.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentMethodPage {

// Declaration	
	@FindBy(xpath = "//input[@value=\"COD\"]")
	private WebElement codRadioButton;

	@FindBy(xpath = "//input[@value=\"Internet Banking\"]")
	private WebElement internetBankingRadioButton;

	@FindBy(xpath = "//input[@value=\"Debit / Credit card\"]")
	private WebElement debitAndCreditCardRadioButton;

	@FindBy(xpath = "//input[@value=\"submit\"]")
	private WebElement submitButton;

// Initialization	
	public PaymentMethodPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

// Utilization
	public WebElement getCodRadioButton() {
		return codRadioButton;
	}

	public WebElement getInternetBankingRadioButton() {
		return internetBankingRadioButton;
	}

	public WebElement getDebitAndCreditCardRadioButton() {
		return debitAndCreditCardRadioButton;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
//	Business Logic
	public void cod()
	{
		codRadioButton.click();
		submitButton.click();
	}
	public void internetBanking()
	{
		internetBankingRadioButton.click();
		submitButton.click();
	}
	public void debitAndCreditCard()
	{
		debitAndCreditCardRadioButton.click();
		submitButton.click();
	}
	

}
