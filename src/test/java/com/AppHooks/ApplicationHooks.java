package com.AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties config;
	
	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		config = configReader.init_Config();
	}
	
	@Before(order = 1)
	public void launchBrowser() {
		String browser = config.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browser);
	}
	
	
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}
	
	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			//Capture Screenshot
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] srcPath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcPath, "image/png", screenshotName);
			
		}
	}
	
}
