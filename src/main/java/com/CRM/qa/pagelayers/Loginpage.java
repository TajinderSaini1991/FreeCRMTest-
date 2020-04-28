package com.CRM.qa.pagelayers;



import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.qa.base.Testbase;

public class Loginpage extends Testbase {
	
	@FindBy(name= "username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
    WebElement loginButton;
	
	@FindBy(linkText="Sign Up")
	WebElement Signup;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement logo;
	  // now we have to initialize these object repositories/ web elements using page factory
	// this-- means current class objects i.e. initialize current class objects using driver from base class
	// all the variables will be initialized with this driver (loginPage.class can be used instead of this keyword)
	public Loginpage() throws IOException
	{
		PageFactory.initElements(driver,this);
	}
	
	// actions or methods
	public String VerifyHomePageTitle()
	
	{return driver.getTitle();
		
	}
	
	public boolean verifyCRMlogo()
	{
		return logo.isDisplayed();
		
	}
	
	
	public Homepage login(String uname, String pw) throws IOException 

		{username.sendKeys(uname);
		password.sendKeys(pw);	
		loginButton.click();
		return new Homepage();
		}
	
	
}
