package pageObjects;

import org.openqa.selenium.WebDriver;

import utils.TestContextSetup;

public class PageObjectManager {
	public LoginPage loginPage;
	public WebDriver driver;
	public HeaderSection headerSection;
	public OrderHistoryPage orderHistoryPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getLoginPage() {
		loginPage = new LoginPage(driver);
		return loginPage;
	}
	
	public HeaderSection getHeaderSection() {
		headerSection = new HeaderSection(driver);
		return headerSection;
	}

	public OrderHistoryPage getOrderHistoryPage() {
		orderHistoryPage = new OrderHistoryPage(driver);
		return orderHistoryPage;
	}
}
