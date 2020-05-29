package com.nagarro.seleniumAssignment.Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.nagarro.seleniumAssignment.Base.Base;

public class TestListener implements ITestListener {

	public static ExtentReports extent;
	public static ExtentTest test;

	public void onStart(ITestContext context) {

		Base.log.info("*** Test Suite " + context.getName() + " started ***");
		extent = ExtentManager.getInstance();

	}

	public void onFinish(ITestContext context) {
		Base.log.info("*** Test Suite " + context.getName() + " ending ***");
		extent.flush();
	}

	public void onTestStart(ITestResult result) {
		Base.log.info("*** Running test method " + result.getName() + "...");
		test=extent.createTest(result.getName());
		test.log(Status.INFO,result.getName() + "*** Test Case Started..." );
	}

	public void onTestSuccess(ITestResult result) {
		Base.log.info("*** Executed " + result.getName() + " Test Case Successfully ***");
		test.log(Status.PASS, "Test Case passed" + result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		Base.log.info("*** Executed " + result.getName() + " Test Case Failed ***");
		test.log(Status.FAIL, "TestCase failed IS" + result.getName());

		try {
			String screenshotPath = ScreenshotCaptureUtil.getScreenshot(Base.driver, result.getName());
			test.addScreenCaptureFromPath(screenshotPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		Base.log.info("*** Test " + result.getName() + " skipped ***");
		test.log(Status.SKIP, "Test Case Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		Base.log.info("*** Test failed but within percentage % " + result.getName());
		test.log(Status.FAIL, "*** Test failed but within percentage % " + result.getName());
	}

}
