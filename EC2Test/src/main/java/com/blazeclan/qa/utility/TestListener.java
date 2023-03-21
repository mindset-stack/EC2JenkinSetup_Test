package com.blazeclan.qa.utility;

import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.blazeclan.qa.base.CommonFunctions;
import com.blazeclan.qa.logging.Log;
import com.blazeclan.qa.reports.ExtentManager;
import com.blazeclan.qa.reports.ExtentTestManager;

public class TestListener extends CommonFunctions implements ITestListener {
	
	public void onStart(ITestContext context)
	{

		System.out.println("*** Test suit" + context.getName() +" Started ****");
	}

	public void onTestStart(ITestResult result)
	{
		Log.info(result.getName() + " Test is starting. ");
		ExtentTestManager.startTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
	}

	public void onFinish(ITestContext testContext) {
		Log.info("I am on finish method " +testContext.getName());
		ExtentManager.createExtentReports().flush();


	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Method failed " +result.getName());
		Log.error(result.getName() +"Test is failed");
		System.out.println(Arrays.toString(result.getParameters()));
		String screenshotPath = captureScreenshot(result.getName(),"failed");

		try {
			ExtentTestManager.getTest().addScreenCaptureFromPath(screenshotPath);
			MediaEntityBuilder screenshot= MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath);
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed", screenshot.build());
			ExtentTestManager.getTest().info(MarkupHelper.createLabel("failed", ExtentColor.RED));



		}catch(Exception e){
			e.printStackTrace();

		}

	}

	public void onTestSuccess(ITestResult result) {

		Log.info(result.getName() + "Test is passed");
			Log.info(result.getName() +" " +  result.getInstanceName()+ " " +result.id() + " " +Arrays.toString(result.getFactoryParameters()));
		String screenshotpath =captureScreenshot(result.getName(),"Success");
		MediaEntityBuilder screenshot= MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath);
		ExtentTestManager.getTest().log(Status.PASS, "Test Passed ", screenshot.build());


	}

	public void onTestSkipped(ITestResult result) {

		System.out.println("Mehtod skipped "+result.getName());
		Log.warn(result.getName() +"Test is skipped");
		Log.info(Arrays.toString(result.getParameters()));
		String screenshotPath= captureScreenshot(result.getName(),"Skipped");
		MediaEntityBuilder screenshot= MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath);
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped" , screenshot.build());
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestresult) {
		Log.info("Test failed but it is in defined success ration" +iTestresult.getName());


	}


}
