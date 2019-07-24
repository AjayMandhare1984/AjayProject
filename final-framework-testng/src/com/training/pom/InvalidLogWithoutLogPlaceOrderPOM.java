package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.training.generics.GenericMethods;
import com.trianing.waits.WaitTypes;

public class InvalidLogWithoutLogPlaceOrderPOM{
	private WebDriver driver;
	private WaitTypes types;
	private GenericMethods genericMethods;
	
	public InvalidLogWithoutLogPlaceOrderPOM (WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href=\"http://retail.upskills.in/account/account\"]//i[@class=\"fa fa-user-o\"]")
	private WebElement accountMenu;
	
	@FindBy(xpath="//div[@class=\"form-group\"]/input[@name=\"email\"]")
	private WebElement loginEmail;
	
	@FindBy(xpath="//input[@id=\"input-password\"]")
	private WebElement loginPassword;
	
	@FindBy(xpath="//input[@class=\"btn btn-primary\"]")
	private WebElement loginclick;
	
	@FindBy(xpath="//div[@class=\"alert alert-danger\"]")
	private WebElement invalidcredentialswarn;
	
	@FindBy(linkText="Integer Vitae Iaculis Massa")
	private WebElement vitaeIaculisMassa;
	
	@FindBy(id="copy")
	private WebElement copyRights;
	
	
	public void accountMenuClick() {
		this.accountMenu.click();
	}
	
	public void sendLoginEmail(String loginEmail) {
		this.loginEmail.clear(); 
		this.loginEmail.sendKeys(loginEmail); 
	}
	
	public void sendLoginPwd(String loginPassword) {
		this.loginPassword.clear(); 
		this.loginPassword.sendKeys(loginPassword); 
		
	}
	
	public void loginClick() {
		this.loginclick.click(); 
	}	
	
	public void verifyInvalidCredentialsWarn() {
		String invalidcredentialsmsg = this.invalidcredentialswarn.getText().trim();	

		if(invalidcredentialsmsg.contains("Warning: No match for E-Mail Address and/or Password.")) {
			System.out.println("Test Pass");
		} 
		else {
			System.out.println("Test Fail");
			}
	}
	
	public void clickVitaeIaculisMassa() {
		genericMethods = new GenericMethods(driver);
		genericMethods.scrollIntoView(this.copyRights);
		types = new WaitTypes(driver);
		types.waitForElement(this.vitaeIaculisMassa, 60);
		this.vitaeIaculisMassa.click();
		 
	}
	
}



