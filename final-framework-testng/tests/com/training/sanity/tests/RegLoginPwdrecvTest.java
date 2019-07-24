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
import com.training.pom.RegLoginPwdrecvPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class RegLoginPwdrecvTest {
	private WebDriver driver; 
	private String baseUrl; 
	private RegLoginPwdrecvPOM Execution;
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
		Execution = new RegLoginPwdrecvPOM(driver); 
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
	public void registrationPassTest() {
		    try {
		    Execution.accountMenuClick();
		    Execution.registrationBtnClick();
		    Execution.sendFirstnameInput("aaaggg");
		    Execution.sendLastnameInput("bbb");
		    Execution.sendEmailInput("aaaggg@c.com");
		    Execution.sendTelephoneInput("123456789");
		    Execution.sendAddress1Input("sss");
		    Execution.sendAddress2Input("ggg");
		    Execution.sendCityInput("Pune");
		    Execution.sendPostcodeInput("12341");
		    Execution.seletCountryInputInput();
		    Execution.selectRegionStateInput();
		    Execution.sendPasswordInput("qwer!12");
		    Execution.sendPasswordReInput("qwer!12");
		    Execution.clickNewsletterNoInput();
		    Execution.selectPrivacyPolicyInput();
		    Execution.clickContinuneBtn();
		    Execution.verifyCongratsmsg();  
		    screenShot.captureScreenShot("Registration");}
		    catch(Exception e)
		    {
		    	System.out.println("registrationPassTest failed with exception" + e);
		    }
	}
	
	@Test(priority=2)
	public void loginPassTest() {
		   try {
		   Execution.accountMenuClick();
		   Execution.sendLoginEmail("aaaggg@c.com");
		   Execution.sendLoginPwd("qwer!12");
		   Execution.loginClick();
		   Execution.verifyLoginSuccess();
		   screenShot.captureScreenShot("Login"); 
		   }
		   catch(Exception e)
		   {
		    	System.out.println("loginPassTest failed with exception" + e);
		   }
	}
	
	@Test(priority=3)
	public void recoverPwdPassTest() {
		   try {
		   Execution.accountMenuClick();
		   Execution.sendLoginEmail("aaaggg@c.com");
		   Execution.sendLoginPwd("qwer!");
		   Execution.loginClick();
		   Execution.forgotPwdClick();
		   Execution.sendEmailAddressInput("aaaggg@c.com");
		   Execution.pwdRecoverContinueBtnClick();
		   Execution.verifyPwdRecoverSuccess();
		   screenShot.captureScreenShot("RecoverPassword");
		   }
		   catch(Exception e)
		   {
		    	System.out.println("recoverPwdPassTest failed with exception" + e);
		   }
		
	}
}
	



