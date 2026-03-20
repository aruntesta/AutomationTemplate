package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericUtils {
	public WebDriver driver;
	public WebDriverWait wait;
	public Actions actions;
	
	public GenericUtils(WebDriver driver) {
		this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        actions = new Actions(driver);
	}
	
	public void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
	
	public void hoverOverElement(By locator) {
	        Actions actions = new Actions(driver);
	        actions.moveToElement(driver.findElement(locator)).build().perform();
	}

}
