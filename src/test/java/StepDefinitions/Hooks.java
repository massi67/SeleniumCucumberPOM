package StepDefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Utility.DriverFactory;
import Utility.ExtentReportManager;
import io.cucumber.java.Scenario;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	public static ExtentReports extent = ExtentReportManager.getInstance();
	static ThreadLocal<ExtentTest> scenarioThread = new ThreadLocal<>();

	@Before()
    public void setUp(Scenario scenario) {
		ExtentTest test = extent.createTest(scenario.getName());
        scenarioThread.set(test);
        DriverFactory.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) {
    	if (scenario.isFailed()) {
            scenarioThread.get().fail("❌ Scenario Failed: " + scenario.getName());
        } else {
            scenarioThread.get().pass("✅ Scenario Passed");
        }
        DriverFactory.quitDriver();
        ExtentReportManager.getInstance().flush();
    }
    
    public static ExtentTest getTest() {
        return scenarioThread.get();
    }
}
