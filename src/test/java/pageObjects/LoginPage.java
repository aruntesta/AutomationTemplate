package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	public WebDriver driver;


	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Locators
	
	private By userName = By.cssSelector("input#loginFrm_loginname");
	private By password = By.cssSelector("input#loginFrm_password");
	private By loginBtn = By.cssSelector("button[title='Login']");
	
	
	//Actions
	
	public void enterUsername(String usrName) {
		driver.findElement(userName).sendKeys(usrName);
	}
	
	public void enterPassword (String pswd) {
		driver.findElement(password).sendKeys(pswd);
	}
	
	public void clickLoginBtn() {
		driver.findElement(loginBtn).click();
	}

}
