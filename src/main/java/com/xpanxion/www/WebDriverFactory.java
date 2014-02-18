package com.xpanxion.www;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * @author jchristi
 * 
 */
public class WebDriverFactory {

	private static Logger log = LoggerFactory.getLogger(WebDriverFactory.class);
	/**
*
*/
	public static final long TIMEOUT = 6;

	/**
	 * 
	 * @return
	 */
	public static WebDriver get() {
		DesiredCapabilities dc = DesiredCapabilities.firefox();
		dc.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
		return get(dc);
	}

	/**
	 * 
	 * @param cap
	 * @return
	 */
	public static WebDriver get(DesiredCapabilities cap) {
		WebDriver driver;
		try {
			
			log.info("Using local WebDriver (no remoteHub setting found in config).");
			driver = new FirefoxDriver(cap);
			
		} catch (NullPointerException e) {
			throw new RuntimeException(
					"No scenarios matching the given arguments were found", e);
		} catch (Exception e) {
			throw new RuntimeException(
					"Exception while attempting to create WebDriver", e);
		}

		return driver;
	}
}
