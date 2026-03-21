package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public Properties prop;
	public WebDriver driver;

	public WebDriver WebDriverManager() throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Global.properties");
		prop = new Properties();
		prop.load(fis);

		String browser_properties = prop.getProperty("browser").trim();
		String url = prop.getProperty("URL").trim();
		
		String browser_maven = System.getProperty("browser").trim();
		
		String browser = browser_properties!=null? browser_maven : browser_properties;

		if (driver == null) {
			if (browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else {
				System.out.println("Given browser name is invalid");
			}
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.get(url);
		}
		return driver;
	}
}
