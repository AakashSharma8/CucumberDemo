package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	// By Locators:
	private By username = By.name("UserName");
	private By password = By.xpath("//input[@placeholder='Password']");
	private By loginButton = By.name("command");

	// 2. constructor of the page class
	public LoginPage(WebDriver driver) {

		this.driver = driver;

	}

	// 3. page actions
	public String getLoginPageTitle() {
		return driver.getTitle();

	}

	public String getPasswordButtomText() {
		return driver.findElement(password).getAttribute("placeholder");

	}

	public void enterUsername(String us_name) {

		driver.findElement(username).sendKeys(us_name);

	}

	public void enterPassward(String pass) {

		driver.findElement(password).sendKeys(pass);

	}

	public void ClickOnLogin() {

		driver.findElement(loginButton).click();
	}
}
