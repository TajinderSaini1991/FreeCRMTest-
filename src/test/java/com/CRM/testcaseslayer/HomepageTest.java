package com.CRM.testcaseslayer;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.CRM.qa.base.Testbase;
import com.CRM.qa.pagelayers.Contactpage;
import com.CRM.qa.pagelayers.Homepage;
import com.CRM.qa.pagelayers.Loginpage;
import com.CRM.qa.util.Testutil;

public class HomepageTest extends Testbase {
	Loginpage loginpage;
	Testutil testutil;
	Homepage homepage;
    Contactpage contactpage;
	public HomepageTest() throws IOException {
		super();

	}

	@BeforeMethod

	public void setup() throws IOException {
		initialisation();
		loginpage = new Loginpage();
		contactpage= new Contactpage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil = new Testutil();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 1, groups= {"smoke"})
	public void verifyhomepagetitleTest() {

		String title = homepage.verifyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO", "home page title is not correct");
	}

	@Test(priority = 2)
	public void verifyusernamelabel() {
		testutil.switchToFrame();
		Assert.assertTrue(homepage.verifyhomepageUser());
	}
	
	@Test(priority=3)
	
	public void verifyContactslinkTest() throws IOException{
		testutil.switchToFrame();
	contactpage =	homepage.clickContactsLink();
	}
	
	
	
	
	
	
	
	
	
}
