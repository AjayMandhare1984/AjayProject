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


public class InvalidLogWithoutLogPlaceOrderTest {
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
	
	@Test(priority=1)
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
		    
		    	   Execution.clickVitaeIaculisMassa();
		    	   Execution.clickAddCartBtn();
		    	   Execution.verifyCartMasg();
		    	   try {
					Thread.sleep(15000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
		    	  
		   		   Execution.mouseOverAndVerifyCart();
		   		   Execution.clickOnViewCartBtn();
		   		   Execution.clickCheckoutBtn();
		   		   screenShot.captureScreenShot("checkoutWithoutLogin");
		    
		    }
	
	@Test(priority=3)
	public void placeOrderPassTest() {
 	       Execution.accountMenuClick();
		   Execution.sendLoginEmail("bbbjjj@c.com");
		   Execution.sendLoginPwd("qwer!12");
		   Execution.loginClick();
		   Execution.clickHomeBtn();
		   Execution.clickVitaeIaculisMassa();
		   Execution.clickAddCartBtn();
    	   Execution.verifyCartMasg();
    	   try {
			Thread.sleep(15000);
		   } catch (InterruptedException e) {
			
			e.printStackTrace();
		   }
    	  
   		   Execution.mouseOverAndVerifyCart();
   		   Execution.clickOnViewCartBtn();
   		   Execution.clickOrderCheckoutBtn();
   		   Execution.verifyPaymentAdd();
   		   Execution.clickPaymentBtn();
    	   try {
			Thread.sleep(15000);
		   } catch (InterruptedException e) {
			
			e.printStackTrace();
		   }
   		   Execution.verifyShippingAdd();
   		   Execution.clickShippingBtn();
   		   Execution.enterFirstComment("Nice Product");
   		   Execution.clickShippingMethodContBtn();
   		   Execution.enterSecondComment("Pls Confirm Order");
   		   Execution.clickAgrreCheckBox();
   		   Execution.clickPaymentMethodContBtn();
   		   Execution.clickConfirmOrderBtn();
   		   Execution.successfullOrderVerification();
   		   screenShot.captureScreenShot("OrderSuccessfull");
  	
	       }
	}
	
	
	
	

