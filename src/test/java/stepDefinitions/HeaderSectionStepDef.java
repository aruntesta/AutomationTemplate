package stepDefinitions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HeaderSection;
import pageObjects.LoginPage;
import utils.TestContextSetup;

public class HeaderSectionStepDef {
	public TestContextSetup testContextSetup;
	public HeaderSection headerSection;

	public HeaderSectionStepDef(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		headerSection = testContextSetup.pageObjectManager.getHeaderSection();

	}

	@Given("User is on login page")
	public void user_is_on_login_page() {
		headerSection.clickLoginBtn();
	}

	@Then("User should redirect to the homepage as logged in")
	public void user_should_redirect_to_the_homepage_as_logged_in() {
		String logoutTxt = headerSection.getWelcomeBackText();
		assertEquals(logoutTxt, "Welcome back Arun", "User is not logged in");
	}

	@And("User clicks the check your order link in the header")
	public void user_clicks_the_check_your_order_link_in_the_header() {
		headerSection.clickOrderHistoryLink();
	}

}
