package com.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	/**
	 * This method is used to initialize the ThreadLocal driver based on browser type given
	 * @param browserName
	 * @return
	 */
	public WebDriver init_driver(String browserName) {
		System.out.println("Browser is "+browserName);

		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}
		else
			if(browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				tlDriver.set(new FirefoxDriver());
			}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
		
	}
	
	/**
	 * This method is used to get the driver with ThreadLocal
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}
