package com.CRM.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.CRM.qa.util.Testutil;
import com.CRM.qa.util.WebeventListener;

public class Testbase {

	public static WebDriver driver;
	public static Properties prop;
    public static EventFiringWebDriver e_driver;
    public static WebeventListener eventlistener; 
	public Testbase() throws IOException {
		prop = new Properties();
		FileInputStream fi = new FileInputStream(
				"C:\\Users\\SimTaj\\workspace\\worspceselenium\\FreeCRMtest\\src\\main\\java\\com\\CRM\\qa\\config\\config.properties  ");

		prop.load(fi);

	}

	public static void initialisation() throws IOException {
		 prop.getProperty("browser");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SimTaj\\workspace\\chromedriver.exe");
		driver = new ChromeDriver();

		e_driver = new EventFiringWebDriver(driver);
		eventlistener = new WebeventListener();
		// we have to register eventlistner with EventFiringWebdriver object
		
		e_driver.register(eventlistener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Testutil.PageLoadTime, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutil.ImplicitWait, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}

	
	  
	
	
	
	
	
	
	
}
