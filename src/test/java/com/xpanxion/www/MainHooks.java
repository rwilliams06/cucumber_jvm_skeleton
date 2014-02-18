package com.xpanxion.www;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * Cucumber hooks are executed before or after each scenario
 * 
 * @author dhenry
 * @author jchristi
 */
public class MainHooks {
	/**
*
*/
	private Logger logger = LoggerFactory.getLogger(MainHooks.class);
	private WebDriver driver;

	public MainHooks(WebDriver driver) {
		this.driver=driver;
	}

	@Before
	public void prepare(Scenario scenario) {

	}

	// TODO: is there any way to get the SharedContext object?
	/**
	 * Logout the authenticated user after each scenario
	 */
	@After(order = 99999)
	public void takeScreenshot(Scenario scenario) {

		// embed screenshot in results of failed scenario
		if (scenario.isFailed()) {
			try {
				logger.info("Attaching screenshot to failed scenario output.");
				scenario.write("Attaching screenshot to failed scenario output.");
				scenario.write(driver.getCurrentUrl());
				byte[] data = ((TakesScreenshot) this.driver)
						.getScreenshotAs(OutputType.BYTES);
				scenario.embed(data, "image/png");
			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
				System.err.println(somePlatformsDontSupportScreenshots
						.getMessage());
			} catch (ClassCastException cce) {
				cce.printStackTrace();
			}
		}
	}

	@After(order = 1)
	public void tearDown() {
		// drop all session and cookie data in prep for next scenario
		// because we're going to reuse the browser
		logger.debug("Deleting cookies on browser.");
		this.driver.manage().deleteAllCookies();
	}
}
