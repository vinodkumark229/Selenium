package com.herokuapp.templates;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sample.commonLib.CommonMethods;

public abstract class TestTemplate extends CommonMethods {
	
	CommonMethods commonMethods;
	
	public CommonMethods getObject() {
		return commonMethods;
	}	
	
    @BeforeClass
    public void openAplication () {
    	commonMethods = new CommonMethods();
    	commonMethods.launchBrowser("", "https://the-internet.herokuapp.com/login");
    }
    
    @Test
    abstract public void verifyLogin();
    
	@AfterClass
	public void quitApplication() {
		commonMethods.closeAllBrowser(commonMethods.getDriver());
	}
	
}
