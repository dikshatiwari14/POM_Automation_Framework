package com.nagarro.seleniumAssignment.Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.nagarro.seleniumAssignment.Base.Base;

public class TestListener implements ITestListener {

	public static ExtentReports extent;
	
	public void onStart(ITestContext context) {

		Base.log.info(" Test Suite --- " + context.getName() + " started ...");
		extent = ExtentManager.getInstance();

	}

	public void onFinish(ITestContext context) {
		Base.log.info(" Test Suite --- " + context.getName() + " ending...");
		extent.flush();
	}

	public void onTestStart(ITestResult result) {
		Base.test=extent.createTest(result.getName());
		Base.test.log(Status.INFO,result.getName() + "--- Test Case Started..." );
		Base.log.info("*** Running test method " + result.getName() + "...");
	}

	public void onTestSuccess(ITestResult result) {
		Base.test.log(Status.PASS, "Test Case passed" + result.getName());
		Base.log.info("*** Executed " + result.getName() + " Test Case Successfully ***");
		
	}

	public void onTestFailure(ITestResult result) {
		Base.test.log(Status.FAIL, "TestCase failed IS" + result.getName());
		Base.log.info("*** Executed " + result.getName() + " Test Case Failed ***");

		try {
			String screenshotPath = ScreenshotCaptureUtil.getScreenshot(Base.driver, result.getName());
			Base.test.addScreenCaptureFromPath(screenshotPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		Base.test.log(Status.SKIP, "Test Case Skipped");
		Base.log.info("*** Test " + result.getName() + " skipped ***"); 
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		Base.log.info("*** Test failed but within percentage % " + result.getName());
		Base.test.log(Status.FAIL, "*** Test failed but within percentage % " + result.getName());
	}

}
