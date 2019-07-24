package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.InvalidLogWithoutLogPlaceOrderPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class MediumTest {
	private WebDriver driver; 
	private String baseUrl; 
	private InvalidLogWithoutLogPlaceOrderPOM Execution;
	private static Properties properties; 
	private ScreenShot screenShot;
	
	@BeforeSuite
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);		
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		Execution = new InvalidLogWithoutLogPlaceOrderPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
	
	@Test(priority=1,enabled=false)
	public void invalidCredentialsPassTest() {
		    try {
		    	   Execution.accountMenuClick();
				   Execution.sendLoginEmail("aaannn@c.com");
				   Execution.sendLoginPwd("qwer!1");
				   Execution.loginClick();
				   Execution.verifyInvalidCredentialsWarn();
				   screenShot.captureScreenShot("InvalidLoginCredentials");
		    }
		    catch(Exception e)
		    {
		    	System.out.println("invalidCredentialsPassTest failed with exception" + e);
		    }
	}
	
	@Test(priority=2)
	public void checkoutWithoutLoginPassTest() {
		    try {
		    	   Execution.clickVitaeIaculisMassa();
		    }
		    catch(Exception e)
		    {
		    	System.out.println("checkoutWithoutLoginPassTest failed with exception" + e);
		    }
	}
	
	}
	

