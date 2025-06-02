package Runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "@target/failedscenarios123.txt",
		glue = {"StepDefinitions"},
		tags = "@Login",
		plugin = {"pretty", 
				  "html:target/cucumber-reports.html",
				  "json:target/cucumber-report.json",
				  "rerun:target/failedscenarios.txt"
				  //"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				  },
		monochrome = false
)
public class FailureReRunner extends AbstractTestNGCucumberTests {
	
	@Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios(); // runs each scenario in parallel
    }
}
