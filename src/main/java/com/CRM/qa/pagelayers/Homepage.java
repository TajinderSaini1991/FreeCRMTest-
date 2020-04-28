package com.CRM.qa.pagelayers;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.qa.base.Testbase;

public class Homepage extends Testbase {

	@FindBy(xpath = "/html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[1]")
	WebElement homepageUser;
    
	//@FindBy(xpath="/html/body/table[1]/tbody/tr[3]/td[1]/div/div/ul/li[4]/a")
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	//@FindBy(xpath = "//a[@title='Contacts']")
	WebElement contactslink;
	
	@FindBy(xpath ="//a[contains(text(),'New Contact')]")
	//@FindBy(xpath="a[@title='New Contact']")
	WebElement newContact;

	@FindBy(xpath = "//a[@title='Deals']")
	WebElement dealslink;
	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasklink;

	// Initializing page objects using page factory
	public Homepage() throws IOException

	{
		PageFactory.initElements(driver, this);
	}
	public boolean verifyhomepageUser(){
	return	homepageUser.isDisplayed();
	}

	public String verifyHomePageTitle() {
		
		return driver.getTitle();
	}

	public Contactpage clickContactsLink() throws IOException {
		contactslink.click();
		return new Contactpage();
	}
	
	public void clickNewContact() throws InterruptedException{

	Actions act = new Actions(driver);
	
	act.moveToElement(contactslink).build().perform();
	Thread.sleep(2000);
	//act.moveToElement(newContact).click();
	newContact.click();
	}

	public Dealspage clickDealsLink() {
		dealslink.click();

		return new Dealspage();
	}

	public Taskpage clickTaskLink() {
		tasklink.click();
		return new Taskpage();
	}

}