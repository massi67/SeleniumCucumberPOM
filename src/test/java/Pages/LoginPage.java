package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(id = "user-name")
    WebElement username;
	
	@FindBy(id = "password")
    WebElement password;
	
	@FindBy(id = "login-button")
    WebElement loginBtn;
	
	@FindBy(xpath = "//div[@class='header_label']/div")
    WebElement dashboardTitle;
	
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String user) {
        username.sendKeys(user);
    }

    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    public void clickLogin() {
    	loginBtn.click();
    }

    public boolean isDashboardDisplayed() {
        return dashboardTitle.isDisplayed();
    }
}
