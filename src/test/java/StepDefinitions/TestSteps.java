package StepDefinitions;

import Pages.LoginPage;
import Utility.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class TestSteps {
	
	LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
		DriverFactory.getDriver().get("https://www.saucedemo.com/");
	}

	@When("user enters valid {string} and {string}")
	public void user_enters_valid_and(String userName, String password) {
	    loginPage.enterUsername(userName);
	    loginPage.enterPassword(password);
	    loginPage.clickLogin();
	}

	@Then("user should be redirected to the dashboard")
	public void user_should_be_redirected_to_the_dashboard() {
	    Assert.assertTrue("Verifying user is landed on dashboard page.", loginPage.isDashboardDisplayed());
	}
}
