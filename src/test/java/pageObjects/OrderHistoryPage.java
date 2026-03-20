package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderHistoryPage {
	public WebDriver driver;
	
	public OrderHistoryPage(WebDriver driver) {
		this.driver = driver;	
	}
	
	//Locators
	private By orderHistoryPageHeader = By.xpath("//h1/span[@class='maintext']");
	
	
	// Actions
	public String getOrderHistoryPageTitle() {
		return driver.getTitle();
	}
	
	public String getOrderHistoryPageHeader() {
		return driver.findElement(orderHistoryPageHeader).getText();
	}
}
