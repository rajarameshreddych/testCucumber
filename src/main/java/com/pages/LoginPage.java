package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;

	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By signIn = By.id("SubmitLogin");
	private By forgotPasswordLink = By.linkText("Forgot your password?");
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isForgotPasswordLinkExists() {
		return driver.findElement(forgotPasswordLink).isDisplayed();
	}
	
	public void enterUserName(String username) {
		driver.findElement(emailId).sendKeys(username);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickOnLogin() {
		driver.findElement(signIn).click();
	}

	public AccountsPage doLogin(String un, String pwd) {
		System.out.println("login with: " + un + " and " + pwd);
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signIn).click();
		return new AccountsPage(driver);
	}
}
