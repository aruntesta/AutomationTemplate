package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.ndjson.internal.com.fasterxml.jackson.core.exc.StreamReadException;
import io.cucumber.messages.ndjson.internal.com.fasterxml.jackson.databind.DatabindException;
import models.LoginData;
import pageObjects.LoginPage;
import utils.TestContextSetup;

public class LoginStepDef {
	public TestContextSetup testContextSetup;
	public LoginPage loginPage;
	public LoginData loginData;
	

	public LoginStepDef(TestContextSetup testContextSetup) throws StreamReadException, DatabindException, IOException {
		this.testContextSetup = testContextSetup;
		loginPage = testContextSetup.pageObjectManager.getLoginPage();
		loginData = testContextSetup.genericUtils.readJsonData("LoginData.json", LoginData.class);
	}


	@When("User enters valid username and password and logged in")
	public void user_enters_valid_username_and_password_and_logged_in() {
		loginPage.enterUsername(loginData.getUsername());
		loginPage.enterPassword(loginData.getPassword());
		loginPage.clickLoginBtn();
	}
	
	@When("User enters username {string} and password {string} and logged in")
	public void user_enters_username_and_password_and_logged_in(String Usrnme, String Pswrd) {
		loginPage.enterUsername(Usrnme);
		loginPage.enterPassword(Pswrd);
		loginPage.clickLoginBtn();
	}


}
