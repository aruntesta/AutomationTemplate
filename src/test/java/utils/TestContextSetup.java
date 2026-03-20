package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetup {
	public TestBase testBase;
	public WebDriver driver;
	public PageObjectManager pageObjectManager;
	public GenericUtils genericUtils;

	public TestContextSetup() throws IOException {
		
		testBase = new TestBase();
		driver = testBase.WebDriverManager();
		pageObjectManager = new PageObjectManager(driver);
		genericUtils = new GenericUtils(driver);
	} 
}
