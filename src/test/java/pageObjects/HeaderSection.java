package pageObjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.GenericUtils;
import utils.TestContextSetup;

public class HeaderSection {
	public WebDriver driver;
	public GenericUtils genericUtils;

	public HeaderSection(WebDriver driver) {
		this.driver = driver;
		this.genericUtils = new GenericUtils(driver);

	}

	// Locators
	private By LoginBtn = By.xpath("(//ul[@id='customer_menu_top']//li/a)[1]");
	private By WelcomeBack = By.xpath("//ul[@id='customer_menu_top']//li/a/div");
	private By OrderHistoryLink = By.xpath("(//span[text()='Check Your Order'])[1]");
	private By Account = By.xpath("(//span[text()='Account'])[1]");
	private By SearchBox = By.xpath("//input[@id='filter_keyword']");
	private By SearchBoxCategory = By.xpath("//li[@class='search-category']/a");

	// Actions
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

	public String SearchCategoryInTheSearchBox(String categoryName) {
		driver.findElement(SearchBox).click();
		List<WebElement> categories = driver.findElement(SearchBoxCategory).findElements(SearchBoxCategory);
		String text = "";
		for (WebElement category : categories) {
			if (category.getText().contains(categoryName)) {
				text = text + category.getText();
			} else {
				text = "Given category not found in the searchbox";
			}
		}
		return text;

	}

}
