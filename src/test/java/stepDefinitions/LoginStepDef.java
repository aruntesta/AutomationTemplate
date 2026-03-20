package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import utils.TestContextSetup;

public class LoginStepDef {
	public TestContextSetup testContextSetup;
	public LoginPage loginPage;
	

	public LoginStepDef(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		loginPage = testContextSetup.pageObjectManager.getLoginPage();
	}


	@When("User enters valid username {string} and password {string} and logged in")
	public void user_enters_valid_username_and_password_and_logged_in(String username, String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();
	}



}
