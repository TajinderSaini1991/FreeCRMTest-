package com.CRM.testcaseslayer;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.CRM.qa.base.Testbase;
import com.CRM.qa.pagelayers.Contactpage;
import com.CRM.qa.pagelayers.Homepage;
import com.CRM.qa.pagelayers.Loginpage;

import com.CRM.qa.util.Testutil;

public class ContactpageTest extends Testbase{
	
	
	Loginpage loginpage;
	Testutil testutil;
	Homepage homepage;
    Contactpage contactpage;
	public ContactpageTest() throws IOException {
		super();

	}

	@BeforeMethod

	public void setup() throws IOException {
		initialisation();
		loginpage = new Loginpage();
		contactpage= new Contactpage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		testutil = new Testutil();
		testutil.switchToFrame();
		//contactpage = homepage.clickContactsLink(); // to be commented while executing test case 3
	
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test(priority = 1)
	public void ContactLabel() throws IOException{
		contactpage = homepage.clickContactsLink();
		Assert.assertTrue(contactpage.verifyContactsLabel(),"contact label missing");
	}
	
	@Test(priority = 2)
	
	public void CheckBox() throws IOException{
		contactpage = homepage.clickContactsLink();
		contactpage.verifyContactcheckbox();
	}
	@DataProvider
	public Object[][]getCRMTestData() throws IOException{
		Object data[][]= testutil.GetTestData();
		return data;
	}

	@Test(priority =3 ) // without using excel sheet
	
	public void CreateNewContact() throws InterruptedException{
		
		homepage.clickNewContact();
	    Thread.sleep(3000);
		contactpage.createNewContact("Mr.","john","chung","google");}
		
		
	
	
	@Test(priority =3, dataProvider= "getCRMTestData" )
	
	public void CreateNewContact(String title, String Fname, String Lname,String Company) throws InterruptedException{
		
		homepage.clickNewContact();
	    Thread.sleep(3000);
		contactpage.createNewContact(title,Fname,Lname,Company);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
