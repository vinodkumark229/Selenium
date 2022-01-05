package com.sample.commonLib;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonMethods {
	
	WebDriver driver;
	public static Logger logger = Logger.getLogger(CommonMethods.class);
	protected static ExtentReports reporter;
	protected static ExtentTest test;
	
	public CommonMethods() {
		reporter = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");    	
	}
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return driver;		
	}
	
	public void launchBrowser(String browser_type, String url) {
		try {			
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
				ChromeOptions options = new ChromeOptions();
				
//				options.addArguments("headless");
				options.addArguments("start-maximized");
				driver = new ChromeDriver(options);
				logger.info("Launching Chrome Browser");					
				System.out.println("launching Chrome Browser");
			}
			driver.get(url);
			System.out.println("Navigating to - "+url);
			setDriver(driver);
		} catch (Exception e) {
//			logger.error("Exception occured in launchBrowser() - "+e);
			test.log(LogStatus.FAIL,"Failed to launch browser");
		}
	}
	
	public void clickOnElement(WebDriver driver, By locator, String message, By locator_for_next_ele) {
		WebElement element = driver.findElement(locator);
		Boolean isEnabled = element.isEnabled();
		
		if (isEnabled==true) {
			element.click();
			logger.info(message);
			test.log(LogStatus.INFO, message);
			try {
				driver.findElement(locator_for_next_ele);
			} catch (Exception e) {
				logger.error("Click is not performed properly, please check. Here is the execption - "+e);
				test.log(LogStatus.ERROR, "Click is not performed properly, please check. Here is the execption - "+e);
				
			}         			
		}
		else {
			logger.error("The element"+ locator+ " is not present on page.");
			test.log(LogStatus.ERROR, "The element"+ locator+ " is not present on page.");
		}				
	}
	
	public void enterText(WebDriver driver, By locator, String text) {
		try {
			WebElement element = driver.findElement(locator);
			Boolean isEnabled = element.isEnabled();
			if (isEnabled==true) {
				element.sendKeys(text);
				logger.info("Entered "+text+" into "+locator+" field");
				test.log(LogStatus.INFO, "Entered "+text+" into "+locator+" field");
			}
			else {
				logger.error("The element"+ locator+ " is not present on page.");
				test.log(LogStatus.ERROR, "The element"+ locator+ " is not present on page.");
			}			
		}
		catch (Exception e) {
			logger.error("Element - "+locator+" not found.");
			test.log(LogStatus.ERROR, "Element - "+locator+" not found.");
			String screenShotPath = null;
			try {
				screenShotPath = TakeScreenshot.capture(driver, "screenShotName");
			} catch (IOException innerE) {				
				innerE.printStackTrace();
			}
            test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenShotPath));   
		}	
		
	}	
	
	public void closeAllBrowser(WebDriver driver) {
		driver.quit();		
	}
}
