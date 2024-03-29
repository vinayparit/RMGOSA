package com.RMGOnlineShoppingApp.genericutils;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.POMRepository.HomePage;
import com.POMRepository.LoginPage;


public class BaseClass {
	public DataBaseUtils db = new DataBaseUtils();
	public PropertyUtils pLib = new PropertyUtils();
	public ExcelUtils eLib = new ExcelUtils();
	public JavaUtils jLib = new JavaUtils();
	public WebDriverUtils wLib = new WebDriverUtils();
	public static WebDriver driver;
	
	@BeforeSuite(alwaysRun = true)
	public void connectToDataBase() throws SQLException {
		db.connectToDataBase();
		System.out.println("--Connected to DataBase--");
	}

//	@Parameters("Browser")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser() throws IOException {
		String Browser = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");

		if (Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (Browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver(); 
		} else {
			System.out.println("Invalid Broswer");
		}
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver, 10);
		driver.get(URL);

		System.out.println("URL Triggered");
	}

	@BeforeMethod(alwaysRun = true)
	public void loginToApp() throws IOException {
		String UserName = pLib.readDataFromPropertyFile("username");
		String Password = pLib.readDataFromPropertyFile("password");

		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(UserName, Password);

		System.out.println("Logged in Successfully");
	}

	@AfterMethod(alwaysRun = true)
	public void logoutFromApp() {
		HomePage hp = new HomePage(driver);
		hp.signOut();

		System.out.println("Logged Out Successfully");
	}

	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();

		System.out.println("Closed Browser");
	}

	@AfterSuite(alwaysRun = true)
	public void disconnectDataBase() throws SQLException {
		db.disconnectDataBase();

		System.out.println("Disconnected Browser");
	}

}
