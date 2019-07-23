package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegLoginPwdrecvPOM {
	private WebDriver driver;
	
	
	public RegLoginPwdrecvPOM (WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href=\"http://retail.upskills.in/account/account\"]//i[@class=\"fa fa-user-o\"]")
	private WebElement accountMenu;
	
	@FindBy(xpath="//a[@class=\"btn btn-primary\"]")
	private WebElement registrationBtn;
	
	@FindBy(xpath="//input[@id=\"input-firstname\"]")
	private WebElement firstnameInput;
	
	@FindBy(xpath="//input[@id=\"input-lastname\"]")
	private WebElement lastnameInput;
	
	@FindBy(xpath="//input[@id=\"input-email\"]")
	private WebElement emailInput;
	
	@FindBy(xpath="//input[@id=\"input-telephone\"]")
	private WebElement telephoneInput;
	
	@FindBy(xpath="//input[@id=\"input-address-1\"]")
	private WebElement address1Input;
	
	@FindBy(xpath="//input[@id=\"input-address-2\"]")
	private WebElement address2Input;
	
	@FindBy(xpath="//input[@id=\"input-city\"]")
	private WebElement cityInput;
	
	@FindBy(xpath="//input[@id=\"input-postcode\"]")
	private WebElement postcodeInput;
	
	@FindBy(xpath="//select[@id=\"input-country\"]")
	private WebElement countryInput;
	
	@FindBy(xpath="//select[@id=\"input-zone\"]")
	private WebElement regionStateInput;
	
	@FindBy(xpath="//input[@name=\"password\"]")
	private WebElement passwordInput;
	
	@FindBy(xpath="//input[@name=\"confirm\"]")
	private WebElement passwordReInput;
	
	@FindBy(xpath="//input[@name='newsletter' and @value='0']")
	private WebElement newsletterNoInput;
	
	@FindBy(xpath="//input[@name=\"agree\" and @value=\"1\"]")
	private WebElement privacyPolicyInput;
	
	@FindBy(xpath="//input[@value=\"Continue\" and @class=\"btn btn-primary\"]")
	private WebElement continuneBtn;
	
	@FindBy(xpath="//div[@class=\"tb_text_wrap tb_sep\"]")
	private WebElement congratsmsg;
	
	@FindBy(xpath="//a[@class=\"btn btn-primary\"]")
	private WebElement continueB;
	
	@FindBy(xpath="//div[@class=\"form-group\"]/input[@name=\"email\"]")
	private WebElement loginEmail;
	
	@FindBy(xpath="//input[@id=\"input-password\"]")
	private WebElement loginPassword;
	
	@FindBy(xpath="//input[@class=\"btn btn-primary\"]")
	private WebElement loginclick;
	
	@FindBy(xpath="//div[@id=\"System_nyHsmShk\"]/align/h2")
	private WebElement accountscreen;
	
	
	@FindBy(xpath="//div/input[@id=\"input-email\"]")
	private WebElement emailaddress;
	
	@FindBy(xpath="//div[@class=\"alert alert-success\"]")
	private WebElement pwdrecoversucc;
	
	
	
	public void accountMenuClick() {
		this.accountMenu.click();
	}
	
	public void registrationBtnClick() {
		this.registrationBtn.click();
	}
	
	public void sendFirstnameInput(String firstname) {
		this.firstnameInput.clear(); 
		this.firstnameInput.sendKeys(firstname); 
		
	}
	
	public void sendLastnameInput(String lastnameInput) {
		this.lastnameInput.clear(); 
		this.lastnameInput.sendKeys(lastnameInput); 
	}
	
	public void sendEmailInput(String emailInput) {
		this.emailInput.clear(); 
		this.emailInput.sendKeys(emailInput); 
	}
	
	public void sendTelephoneInput(String telephoneInput) {
		this.telephoneInput.clear(); 
		this.telephoneInput.sendKeys(telephoneInput); 
	}
	
	public void sendAddress1Input(String address1Input) {
		this.address1Input.clear(); 
		this.address1Input.sendKeys(address1Input); 
	}
	
	public void sendAddress2Input(String address2Input) {
		this.address2Input.clear(); 
		this.address2Input.sendKeys(address2Input); 
	}
	
	public void sendCityInput(String cityInput) {
		this.cityInput.clear(); 
		this.cityInput.sendKeys(cityInput); 
	}
	
	public void sendPostcodeInput(String postcodeInput) {
		this.postcodeInput.clear(); 
		this.postcodeInput.sendKeys(postcodeInput); 
	}
	
	public void seletCountryInputInput() {
		Select sel = new Select(countryInput);
		sel.selectByVisibleText("India");
				
	}
	
	public void selectRegionStateInput() {
		Select sel = new Select(regionStateInput);
		sel.selectByVisibleText("Maharashtra");
			
	}
	
	public void sendPasswordInput (String passwordInput) {
		this.passwordInput.clear(); 
		this.passwordInput.sendKeys(passwordInput); 
	}
	
	public void sendPasswordReInput (String passwordReInput) {
		this.passwordReInput.clear(); 
		this.passwordReInput.sendKeys(passwordReInput); 
	}
	
	public void clickNewsletterNoInput () {
		boolean isRb=newsletterNoInput.isSelected();
		if(isRb) {
		}
		else{
			this.newsletterNoInput.click();
		}
	}
	
	public void selectPrivacyPolicyInput () {
		this.privacyPolicyInput.click();
	}
	
	public void clickContinuneBtn() {
		this.continuneBtn.click(); 
	}
	
	public void verifyCongratsmsg() {
		boolean pass1 =this.congratsmsg.isDisplayed();
		
		boolean pass2 =this.continueB.isDisplayed();
		if(pass1==pass2) {
			System.out.println("Test Pass");}
		else {
			System.out.println("Test Fail");}
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
	
	public void verifyLoginSuccess() {
		String accsucc = this.accountscreen.getText().trim();
		if(accsucc.contains("My Account")) {
			System.out.println("Test Pass");
		} 
		else {
			System.out.println("Test Fail");
			}
		
	}
	
	public void forgotPwdClick() {
		this.driver.findElement(By.linkText("Forgotten Password")).click();
	}
	
	
	public void sendEmailAddressInput(String emailaddress) {
		this.emailaddress.clear();
		this.emailaddress.sendKeys(emailaddress);
	}
	
	public void pwdRecoverContinueBtnClick() {
		this.driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
	}
	
	public void verifyPwdRecoverSuccess() {
		String pwdrecsuccmsg = this.pwdrecoversucc.getText().trim();
		if(pwdrecsuccmsg.contains("An email with a confirmation link has been sent your email address.")) {
			System.out.println("Test Pass");
		} 
		else {
			System.out.println("Test Fail");
			}
	}
}



