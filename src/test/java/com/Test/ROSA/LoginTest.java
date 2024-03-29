package com.Test.ROSA;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.POMRepository.HomePage;
import com.POMRepository.LoginPage;
import com.RMGOnlineShoppingApp.genericutils.ExcelUtils;
import com.RMGOnlineShoppingApp.genericutils.PropertyUtils;
//import com.RMGOnlineShoppingApp.genericutils.PropertyUtils;
import com.RMGOnlineShoppingApp.genericutils.WebDriverUtils;

public class LoginTest {

	@Test(dataProvider = "genericDp")
	public void login(String UserName,String Password) throws IOException {
		
		WebDriver driver=new ChromeDriver();
		WebDriverUtils wLib=new WebDriverUtils();
		PropertyUtils pObj=new PropertyUtils();
		String URL=pObj.readDataFromPropertyFile("url");
		driver.get(URL);
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver, 10);
		
		HomePage hp=new HomePage(driver);
		hp.clickLoginLink();
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(UserName, Password);
		driver.quit();
	}
	
	@DataProvider
	public Object[][] genericDp() throws EncryptedDocumentException, IOException 
	{
		
		ExcelUtils eLib=new ExcelUtils();
		Object[][]value=eLib.readMultipleDataProvider("DataP");
		return value;
		
	}
	
	
}
