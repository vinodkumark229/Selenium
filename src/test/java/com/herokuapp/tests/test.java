package com.herokuapp.tests;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class test {

	@Test(groups = {"smoke","regression"})
	public void LoginToAmazon() {
		System.out.println("This method won't be exec");
	}
	
	public static void main(String[] args) throws InterruptedException {
		 
		
		
		
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String alert_loc = "//*[@id='confirmButton']";
		Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement etest = driver.findElement(By.xpath(alert_loc));
		Actions obj =new Actions(driver);
		
		
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		WebElement element;
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(alert_loc)));
		
		Wait wiat1 = new FluentWait(driver).withTimeout(10, TimeUnit.SECONDS).pollingEvery(2,TimeUnit.SECONDS).ignoring(ElementNotVisibleException.class);
		wiat1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(alert_loc)));
		
//        JavascriptExecutor js = (JavascriptExecutor)driver;	
//        String alert_loc = "//*[@id='confirmButton']";
        driver.get("https://demoqa.com/frames"); 
//        driver.manage().window().maximize();
//        driver.findElement(By.xpath(alert_loc)).click();
//        Thread.sleep(5000);
//        String str = driver.switchTo().alert();
//        
//        System.out.println(str);
//        Thread.sleep(5000);
		
	    String frame_loc = "#frame2";
	    String frame_element_loc = "#sub-frame-error";
	    
		
		driver.quit();
	}
}