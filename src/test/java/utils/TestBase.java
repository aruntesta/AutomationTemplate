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

		String browserName = prop.getProperty("browser").trim();
		String url = prop.getProperty("URL").trim();

		if (driver == null) {
			if (browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			} else if (browserName.equalsIgnoreCase("chrome")) {
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
