package pageobject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.BaseClass;
import utils.ExtentReport;

public class Listeners extends BaseClass implements ITestListener {

	ExtentReports extent = ExtentReport.getReportObject();// catching variable came from other class
	ExtentTest test; // thread safe for this extent Test class
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); // this object will store all test objects

	public void onTestStart(ITestResult result) {
		// ExtentTest test=extent.createTest("Test Name");
		// test may be ovriden by other class in parallel execution so test object
		// should be thread safe
		// object will be created unique to test method( test) and catch it in test ,
		// resposible for listen and report back to extent report

		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test); // sending all new test objects created by test cases to the thread pool,
		// thread local will give is responsible give right object while reporting pass
		// or fail

	}

	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed");

	}

	public void onTestFailure(ITestResult result) {

		extentTest.get().fail(result.getThrowable()); // failure log will be retrieved and sent to the method(fail) so
														// that report can see all failures log
		WebDriver driver = null;

		String methodName = result.getMethod().getMethodName();
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			// attach screenshot to report

			extentTest.get().addScreenCaptureFromPath(getScreenshot(methodName, driver),
					result.getMethod().getMethodName());
			// getScreenshot(methodName, driver);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		extent.flush(); // so that listeners stop and generate report

	}

}
