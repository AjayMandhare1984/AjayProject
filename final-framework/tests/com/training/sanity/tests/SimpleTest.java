package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.training.generics.ScreenShot;
import com.training.pom.RegLoginPwdrecvPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class SimpleTest {


	private WebDriver driver; 
	private String baseUrl; 
	private RegLoginPwdrecvPOM Execution;
	private static Properties properties; 
	private ScreenShot screenShot; 
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@Before
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		Execution = new RegLoginPwdrecvPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
	
	@Test
	public void registrationPassTest() {
		
		    Execution.accountMenuClick();
		    Execution.registrationBtnClick();
		    Execution.sendFirstnameInput("aaa");
		    Execution.sendLastnameInput("bbb");
		    Execution.sendEmailInput("w@d.com");
		    Execution.sendTelephoneInput("123456789");
		    Execution.sendAddress1Input("sss");
		    Execution.sendAddress2Input("ggg");
		    Execution.sendCityInput("Pune");
		    Execution.sendPostcodeInput("12341");
		    Execution.seletCountryInputInput();
		    Execution.selectRegionStateInput();
		    Execution.sendPasswordInput("qwer!");
		    Execution.sendPasswordReInput("qwer!");
		    Execution.clickNewsletterNoInput();
		    Execution.selectPrivacyPolicyInput();
		    Execution.clickContinuneBtn();
		    Execution.verifyCongratsmsg();  
		    screenShot.captureScreenShot("Registration");
			
				}
}
