package hooks;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.TestBase;
import utils.TestContextSetup;

public class Hooks {
	public TestContextSetup testContextSetup;

	// TimeStamp code
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");
	Date now = new Date();
	String timestamp = formatter.format(now);

	public Hooks(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@After
	public void tearDown() throws IOException {
		testContextSetup.testBase.WebDriverManager().quit();
	}

	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException {
		WebDriver driver = testContextSetup.testBase.WebDriverManager();
		if (scenario.isFailed()) {
			File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", scenario.getName() + " " + timestamp + ".png");

		}
	}

}
