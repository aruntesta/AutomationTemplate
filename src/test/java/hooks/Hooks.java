package hooks;

import java.io.IOException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.TestContextSetup;

public class Hooks {
	public TestContextSetup testContextSetup;

	public Hooks(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@After
	public void tearDown() throws IOException {
		testContextSetup.testBase.WebDriverManager().quit();
	}

}
