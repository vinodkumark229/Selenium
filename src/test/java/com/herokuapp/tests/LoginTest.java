package com.herokuapp.tests;

import java.sql.Driver;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.herokuapp.appLib.FormPage;
import com.herokuapp.templates.TestTemplate;
import com.relevantcodes.extentreports.LogStatus;
import com.sample.commonLib.CommonMethods;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends TestTemplate {
	
	@Test
	public void verifyLogin() {		
		try {
			test = reporter.startTest("Verify Login");
			loginPage.enterUsername();
			loginPage.enterPassword();
			loginPage.clickLoginBtn();
			test.log(LogStatus.PASS,"Test case passed.");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,"Test case failed with exception - "+e);		
			
		}		
	}	
}
