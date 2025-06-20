package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

	 private static ExtentReports extent;

	    public static ExtentReports getInstance() {
	        if (extent == null) {
	            ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");
	            extent = new ExtentReports();
	            extent.attachReporter(spark);
	            extent.setSystemInfo("Framework", "Selenium-Cucumber-TestNG");
	            extent.setSystemInfo("Environment", "QA");
	        }
	        return extent;
	    }
}
