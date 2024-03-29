package com.RMGOnlineShoppingApp.genericutils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;




public class ListenerImp implements ITestListener {
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		String MethodName=result.getMethod().getMethodName();
		WebDriverUtils wLib=new WebDriverUtils();
		try {
			wLib.getScreenShot(BaseClass.driver, MethodName);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
	}
}
