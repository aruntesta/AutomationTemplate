package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.GenericUtils;
import utils.TestContextSetup;

public class HeaderSection {
	public WebDriver driver;
    public GenericUtils genericUtils;

	
	public HeaderSection(WebDriver driver) {
		this.driver = driver;
		this.genericUtils = new GenericUtils(driver);

	}
	
	//Locators
	private By LoginBtn = By.xpath("(//ul[@id='customer_menu_top']//li/a)[1]");
	private By WelcomeBack = By.xpath("//ul[@id='customer_menu_top']//li/a/div");
	private By OrderHistoryLink = By.xpath("(//span[text()='Check Your Order'])[1]");
	private By Account = By.xpath("(//span[text()='Account'])[1]");
	
	//Actions
	public void clickLoginBtn() {
		driver.findElement(LoginBtn).click();
	}
	
	public String getWelcomeBackText() {
		return driver.findElement(WelcomeBack).getText();
	}
	
	public void clickOrderHistoryLink() {
		genericUtils.hoverOverElement(Account);
		driver.findElement(OrderHistoryLink).click();
	}
	

}
