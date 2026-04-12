package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.messages.ndjson.internal.com.fasterxml.jackson.core.exc.StreamReadException;
import io.cucumber.messages.ndjson.internal.com.fasterxml.jackson.databind.DatabindException;
import io.cucumber.messages.ndjson.internal.com.fasterxml.jackson.databind.ObjectMapper;

public class GenericUtils {
	public WebDriver driver;
	public WebDriverWait wait;
	public Actions actions;
	
	public GenericUtils(WebDriver driver) {
		this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        actions = new Actions(driver);
	}
	
    private static final ObjectMapper objectMapper = new ObjectMapper();
    
    public <T> T readJsonData(String filePath, Class<T> clazz) throws StreamReadException, DatabindException, IOException {
   
            File file = new File(".\\src\\test\\resources\\testdata\\"+filePath);
            return objectMapper.readValue(file, clazz);
    }
	
	public void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
	
	public void hoverOverElement(By locator) {
	        Actions actions = new Actions(driver);
	        actions.moveToElement(driver.findElement(locator)).build().perform();
	}

}
