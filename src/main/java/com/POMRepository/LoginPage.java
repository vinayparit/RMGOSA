package com.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	// Declaration
	@FindBy(xpath = "//a[.='Login']")
	private WebElement loginLink;

	@FindBy(name = "email")
	private WebElement emailTextField;

	@FindBy(id = "exampleInputPassword1")
	private WebElement passwordTextField;

	@FindBy(name = "login")
	private WebElement loginButton;

	@FindBy(name = "fullname")
	private WebElement fullNameTextField;

	@FindBy(name = "emailid")
	private WebElement emailIdTextField;

	@FindBy(name = "contactno")
	private WebElement contactnoTextField;

	@FindBy(id = "password")
	private WebElement createpasswordTextField;

	@FindBy(name = "confirmpassword")
	private WebElement confirmpasswordTextField;

	@FindBy(name = "submit")
	private WebElement submitButton;

	// Initialization

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization

	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getFullNameTextField() {
		return fullNameTextField;
	}

	public WebElement getEmailIdTextField() {
		return emailIdTextField;
	}

	public WebElement getContactnoTextField() {
		return contactnoTextField;
	}

	public WebElement getCreatepasswordTextField() {
		return createpasswordTextField;
	}

	public WebElement getConfirmpasswordTextField() {
		return confirmpasswordTextField;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

//	Business Logic
	public void loginToApp(String UserName, String Password) {
		loginLink.click();
		emailTextField.sendKeys(UserName);
		passwordTextField.sendKeys(Password);
		loginButton.click();
	}

}
