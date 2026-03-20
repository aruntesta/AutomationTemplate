package stepDefinitions;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.OrderHistoryPage;
import utils.TestContextSetup;

public class OrderHistoryStepdef {
	public TestContextSetup testContextSetup;
	public OrderHistoryPage orderHistoryPage;
	
	public OrderHistoryStepdef(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		orderHistoryPage = testContextSetup.pageObjectManager.getOrderHistoryPage();
	}
	
	@Then ("User validates the page heading")
	public void user_validates_the_page_heading() {
		String orderHistoryPageHeader = orderHistoryPage.getOrderHistoryPageHeader();
		System.out.println(orderHistoryPageHeader);
	}

}
