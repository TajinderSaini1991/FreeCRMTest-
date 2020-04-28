package com.CRM.qa.pagelayers;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import com.CRM.qa.base.Testbase;
import com.CRM.qa.util.Testutil;

public class Contactpage extends Testbase {
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactslabel;
	//@FindBy(xpath = "//select[@name='title'or @classname='select']")
	@FindBy(name="title")
//	@FindBy(xpath="/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/fieldset/form/table/tbody/tr[2]/td[1]/table/tbody/tr[1]/td[2]/select")
	WebElement title;
	
	@FindBy(name="first_name")
	WebElement firstname;
	
	@FindBy(name="surname")
	WebElement lastname;
	
	@FindBy(name= "client_lookup")
	WebElement company;
	
	
	@FindBy(xpath="//input[@type='submit' and @value ='Save']")
	WebElement save;
	
	
	
	public Contactpage() throws IOException{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel(){
		return contactslabel.isDisplayed();
	}
	
	public void verifyContactcheckbox(){
driver.findElement(By.xpath(" /html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/form/form/table/tbody/tr[6]/td[1]/input")).click();
	}
	
	
	
	
	public void createNewContact(String ttle,String fname, String lname, String cmpny){
		Select select = new Select(title);
		select.selectByVisibleText(ttle);
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		company.sendKeys(cmpny);
		save.click();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
