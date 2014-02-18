package com.xpanxion.www;

import org.openqa.selenium.WebDriver;

public class WebDriverSingleton {
	
	/**
	 * the singleton WebDriver instance
	 */
	private static WebDriver driver;
	
	/**
	 * Returns the singleton WebDriver instance
	 * 
	 * @return singleton Webdriver instance
	 */
	public static WebDriver getInstance() {
		if (driver == null) {
				driver = WebDriverFactory.get();
		}
		return driver;
	}
}
