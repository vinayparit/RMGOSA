package com.RMGOnlineShoppingApp.genericutils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersUtils implements ITestListener {

	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		test = report.createTest(MethodName);
		Reporter.log(MethodName+"---------> Execution starts");
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"-----> Passed");
		Reporter.log(MethodName+"---------> Test Script Executed Successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		try {
			String MethodName = result.getMethod().getMethodName();
			String screenshot = WebDriverUtils.getScreenShot(BaseClass.driver, MethodName);
			test.log(Status.FAIL, MethodName+"----> TestScript failed");
			test.log(Status.FAIL, result.getThrowable());
			Reporter.log(MethodName+"----> Failed");
			test.addScreenCaptureFromPath(screenshot);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"----> TestScript Skipped");
		test.log(Status.SKIP, result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) 
	{
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./ExtentReport/report.html");
		htmlReport.config().setDocumentTitle("SDET-54");
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setReportName("Hospital managment System");
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		
		ExtentReports report = new ExtentReports();
		report.setSystemInfo("Base Platform", "windows");
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base URL", "http://rmgtestingserver/");
		report.setSystemInfo("Reporter Name", "Shanthala");
		
	}
	
	@Override
	public void onFinish(ITestContext context) 
	{
		report.flush();
	}
}
