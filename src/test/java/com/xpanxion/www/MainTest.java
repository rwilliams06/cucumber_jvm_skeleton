package com.xpanxion.www;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class MainTest {
	
	@BeforeClass
	public static void setUp() {
		WebDriverSingleton.getInstance();
	}
	
	@AfterClass
	public static void tearDown() {
		WebDriverSingleton.getInstance().quit();
	}

}
