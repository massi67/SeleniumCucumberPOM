package Runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		features = "src/test/java/Features",
		glue = {"StepDefinitions"},
		tags = "@Login",
		plugin = {"pretty", 
				  "html:target/cucumber-reports.html",
				  "json:target/cucumber-report.json",
				  "rerun:target/failedscenarios123.txt"
				  //"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				  },
		monochrome = false
)
public class TestRunner extends AbstractTestNGCucumberTests {
	
	@Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios(); // runs each scenario in parallel
    }
}
