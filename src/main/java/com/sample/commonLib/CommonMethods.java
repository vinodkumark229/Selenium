package com.sample.commonLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonMethods {
	
	
	WebDriver driver;
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return driver;		
	}
	
	public void launchBrowser(String browser_type, String url) {
		
		if (url=="safari") {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			System.out.println("Launching Safari Browser");
		}
		else if (url=="firefox"){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Launching Firefox Browser");
		}
		else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Launching Chrome Browser");
		}
		driver.get(url);
		System.out.println("Navigating to - "+url);
		setDriver(driver);
	}
	
	public void clickOnElement(WebDriver driver, By locator, String message, By locator_for_next_ele) {
		WebElement element = driver.findElement(locator);
		Boolean isEnabled = element.isEnabled();
		
		if (isEnabled==true) {
			element.click();
			System.out.println(message);
			try {
				driver.findElement(locator_for_next_ele);
			} catch (Exception e) {
				System.out.println("Click is not performed properly, please check. Here is the execption - "+e);
			}
		}
		else {
			System.err.println("The element"+ locator+ " is not present on page.");			
		}				
	}
	
	public void enterText(WebDriver driver, By locator, String text) {
		WebElement element = driver.findElement(locator);
		Boolean isEnabled = element.isEnabled();
		if (isEnabled==true) {
			element.sendKeys(text);
			System.out.println("Entered "+text+" into "+locator+" field");			
		}
		else {
			System.err.println("The element"+ locator+ " is not present on page.");
		}	
	}	
	
	public void closeAllBrowser(WebDriver driver) {
		driver.quit();		
	}
}
