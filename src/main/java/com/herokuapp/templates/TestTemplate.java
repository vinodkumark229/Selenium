package com.herokuapp.templates;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.herokuapp.appLib.FormPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.sample.commonLib.CommonMethods;

public abstract class TestTemplate extends CommonMethods {
	
	protected CommonMethods commonMethods;
	protected Logger logger;
	protected String scriptName;
	protected FormPage loginPage;
	
	
    @BeforeSuite
    public void openAplication () {
    	logger = Logger.getLogger(this.getClass().getName());
    	logger.info("Executing Before Suite");
    	scriptName = this.getClass().getSimpleName().trim();
    	commonMethods = new CommonMethods();
    	commonMethods.launchBrowser("", "https://the-internet.herokuapp.com/login");
    	loginPage = new FormPage(commonMethods.getDriver());
    	
    }
    
    @Test
    abstract public void verifyLogin();
    
	@AfterSuite
	public void quitApplication() {
		reporter.endTest(test);
		reporter.flush();
		logger.info("Executing After Suite");
		commonMethods.closeAllBrowser(commonMethods.getDriver());
	}
	
}
