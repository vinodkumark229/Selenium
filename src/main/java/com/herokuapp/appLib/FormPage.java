package com.herokuapp.appLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sample.commonLib.CommonMethods;

public class FormPage extends CommonMethods {
	
	By username_loc = By.cssSelector("#username");
	By password_loc = By.cssSelector("#password");
	By login_loc = By.cssSelector("button[type='submit']");
	By logout_loc = By.cssSelector("[href$='logout']");
	
	private String username = "tomsmith";
	private String password = "SuperSecretPassword!";
	
	WebDriver driver;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public FormPage(WebDriver driver) {
		this.driver = driver;
	}
	
	CommonMethods commonMethods = new CommonMethods();
	
	public void enterUsername () {		
		commonMethods.enterText(driver, username_loc,username);
	}
	public void enterPassword () {		
		commonMethods.enterText(driver, password_loc,password);
	}
	public void clickLoginBtn() {
		commonMethods.clickOnElement(driver, login_loc, "Clicking on login button", logout_loc);
	}

}
