package com.CRM.testcaseslayer;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.BeforeMethod;

import com.CRM.qa.base.Testbase;
import com.CRM.qa.pagelayers.Homepage;
import com.CRM.qa.pagelayers.Loginpage;

public class LoginpageTest extends Testbase {
Loginpage loginpage;
Homepage homepage;
	public LoginpageTest() throws IOException {
		super(); // it will call the super class i.e. base class constructor. We need this constructor to initialize properties 
		         // file 
		
	}

	@BeforeMethod
	public void setup() throws IOException
	{initialisation();
		loginpage = new Loginpage();
		} 
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
		
	}
	
	@Test(priority =1,groups= {"smoke"})
	public void loginpageTitleTest()
	{  
     String ti =	loginpage.VerifyHomePageTitle();
	Assert.assertEquals(ti,"CRMPRO - CRM software for customer relationship management, sales, and support." ,"title not matched");
     // Assert.assertEquals(title,"CRMPRO  - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority =2, groups={"smoke"})
	public void logotest()
	{
	boolean logo=	loginpage.verifyCRMlogo();
	Assert.assertTrue(logo);
	}
	
	@Test(priority =3, groups = {"smoke"})
	public void loginTest() throws IOException
	{ 
	homepage =	loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	
	
	
	
	
	
	
	
}
