package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	static ExtentReports extent;

	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir") + "\\reports\\testreport.html"; // setting the path
		ExtentSparkReporter report = new ExtentSparkReporter(path); // expects path where report should be stored
		// extent spark is helper class to genrate report , it is reponsible for
		// modifications

		report.config().setReportName("Automation Testing");
		report.config().setDocumentTitle("Test Results");

		// extent report is main class responsible for reporting execution

		// ExtentReports extent = new ExtentReports(); line no 8
		extent = new ExtentReports();
		extent.attachReporter(report); // attach report to main class & attach object to it so that object provides all
										// details
		extent.setSystemInfo("Tester", "Deepthi Shetty");
		return extent;
	}

}
