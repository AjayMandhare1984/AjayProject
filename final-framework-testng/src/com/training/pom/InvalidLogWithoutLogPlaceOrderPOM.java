package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
	
	@FindBy (id="button-cart")
	private WebElement addCartBtn;
	
	@FindBy (linkText="shopping cart")
	private WebElement cartMsg;
	
	@FindBy (xpath="//i[@class=\'tb_icon ico-linea-ecommerce-bag\']")
	private WebElement cartBtn;	
	
	@FindBy (xpath="//div[@class='content']/h3")
	private WebElement cartInfo;
	
	@FindBy (xpath="//form[@id='cart_form']/div/table/tbody/tr/td[@class='image']/a/img")
	private WebElement image;
	
	@FindBy (xpath="//form[@id='cart_form']/div/table/tbody/tr/td[@class='name']")
	private WebElement name;
	
	@FindBy (xpath="//form[@id='cart_form']/div/table/tbody/tr/td[@class='model']")
	private WebElement model;
	
	@FindBy (xpath="//form[@id='cart_form']/div/table/tbody/tr/td[@class='quantity']/div/input")
	private WebElement quantity;
	
	
	@FindBy (xpath="//form[@id='cart_form']/div/table/tbody/tr/td[@class='price']")
	private WebElement price;
	
	@FindBy (xpath="//form[@id='cart_form']/div/table/tbody/tr/td[@class='total']")
	private WebElement total;
	
	
	@FindBy (xpath="//div/a[@class='btn btn-primary']")
	private WebElement checkoutBtn;
	
	@FindBy (linkText="Checkout")
	private WebElement ordercheckoutBtn;
	
	
	@FindBy (xpath="//a[@target='_self']")
	private WebElement homeBtn;	
	
	
	@FindBy (xpath="//input[@name='payment_address'and @checked='checked']")
	private WebElement checkoutPayment;
	
	@FindBy (xpath="//input[@name='shipping_address'and @checked='checked']")
	private WebElement checkoutShipping;
	
	@FindBy (id="button-payment-address")
	private WebElement paymentContBtn;
	
	@FindBy (id="button-shipping-address")
	private WebElement shippingContBtn;
	
	@FindBy(name="shipping_method")
	private WebElement freeshiprediobtn;
	
	@FindBy(xpath="//div[@id='accordion']/div[4]/div[2]/div/p[4]/textarea")
	private WebElement firstcommenttextbox;
	
	@FindBy(xpath="//div[@id='accordion']/div[5]/div[2]/div/p[3]/textarea")
	private WebElement secondcommenttextbox;
	
	@FindBy (id="button-shipping-method")
	private WebElement shippingmethodContBtn;
		
	@FindBy(id="button-payment-method")
	private WebElement paymentmethodcontbtn;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement agreecheckbox;
	
	@FindBy(xpath="//div/input[@id='button-confirm']")
	private WebElement confirmorderbtn;
	
	@FindBy(xpath="//div[@id='System_mY98YHaM']/div/p")
	private WebElement orderconfirmmsg;
	
	@FindBy (xpath="//div[@class='content']/div")
	private WebElement cartInformation;
	
	 
	
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
	
    public void clickAddCartBtn() {
    	types = new WaitTypes(driver);
		types.waitForElement(this.addCartBtn, 60);
		   this.addCartBtn.click();	
		   		   
	   }
    
    public void verifyCartMasg() {
    	types = new WaitTypes(driver);
		types.waitForElement(this.cartMsg, 60);  
		
		String cartdata=this.cartMsg.getText(); 
		Assert.assertEquals(cartdata,"shopping cart", "Error");
		
   	
	}

     public void mouseOverAndVerifyCart() {    	
    	types = new WaitTypes(driver);
		types.waitForElement(this.cartBtn, 60); 
    	Actions act= new Actions(driver);
    	act.moveToElement(cartBtn).build().perform(); 
    	String cartContaints=this.cartInfo.getText();    	
    	Assert.assertEquals(cartContaints,"Shopping Cart", "Error");
    	  	
  	    	  	
    }
     
    public void clickOnViewCartBtn() {
        this.cartBtn.click();
   	    types = new WaitTypes(driver);
		types.waitForElement(this.image, 60);
		String imagevalue=this.image.getAttribute("title");		
		Assert.assertEquals(imagevalue,"Integer Vitae Iaculis Massa", "Cart details Invalid");
		
		String namevalue=this.name.getText();			
		Assert.assertEquals(namevalue,"Integer Vitae Iaculis Massa", "Cart details Invalid");
		
		String modelvalue=this.model.getText();
		Assert.assertEquals(modelvalue,"Integer Vitae Iaculis Massa", "Cart details Invalid");
		
		String quantityvalue=this.quantity.getAttribute("type");
		Assert.assertEquals(quantityvalue,"text", "Cart details Invalid");
		
		String pricevalue=this.price.getAttribute("class");
		Assert.assertEquals(pricevalue,"price", "Cart details Invalid");
		
		String classvalue=this.total.getAttribute("class");
		Assert.assertEquals(classvalue,"total", "Cart details Invalid");
	    
    
    }
    

    
    public void clickCheckoutBtn() {
    	this.checkoutBtn.click();
    	String login=driver.findElement(By.id("input-email")).getAttribute("name");
        Assert.assertEquals(login,"email", "Error");
    }
    
    public void clickHomeBtn() {
    	this.homeBtn.click();
    }
    
    public void clickOrderCheckoutBtn() {
    	this.ordercheckoutBtn.click();
    	
    }
    
    public void verifyPaymentAdd() {
    	String paymentadd=this.checkoutPayment.getAttribute("name");
    	Assert.assertEquals(paymentadd,"payment_address", "Error");
    	
    	
    }
    
    public void clickPaymentBtn() {
    	
    	this.paymentContBtn.click();
    }
    
    public void verifyShippingAdd() {
    	String shippingadd=this.checkoutShipping.getAttribute("name");
    	Assert.assertEquals(shippingadd,"shipping_address", "Error");
    }
    
    public void clickShippingBtn() {
    	
    	this.shippingContBtn.click();
   	    types = new WaitTypes(driver);
		types.waitForElement(this.freeshiprediobtn, 60);
		Boolean shipBtn=this.freeshiprediobtn.isSelected();
		Boolean commentbox=this.firstcommenttextbox.isDisplayed();
		if(shipBtn&&commentbox) {
			System.out.println("Continue");
		}
		else {
			System.out.println("Test Fail");
			
			}
    }
    
    public void enterFirstComment(String firstcomment) {
    	
		this.firstcommenttextbox.sendKeys(firstcomment);
    }
    
    public void clickShippingMethodContBtn() {
    	this.shippingmethodContBtn.click();
    }
    
    public void enterSecondComment(String secondcomment) {
    	
		this.secondcommenttextbox.sendKeys(secondcomment);
    }
    
    public void clickAgrreCheckBox() {
    	
    	this.agreecheckbox.click();
    }
    
    public void clickPaymentMethodContBtn() {
    	
    	this.paymentmethodcontbtn.click();
    
    }
    
    public void clickConfirmOrderBtn() {
    	this.confirmorderbtn.click();
    }
    
    public void successfullOrderVerification() {
    	
    	String confirmmsg=this.orderconfirmmsg.getText();
    	Assert.assertEquals(confirmmsg,"Your order has been successfully processed!", "Error");
    	Actions act= new Actions(driver);
    	act.moveToElement(cartBtn).build().perform(); 
    	String ordersucess=this.cartInformation.getText();    	
    	Assert.assertEquals(ordersucess,"Your shopping cart is empty!", "Error");
    }
}






