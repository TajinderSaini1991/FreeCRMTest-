package com.CRM.qa.util;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.CRM.qa.base.Testbase;

public class Testutil extends Testbase {
	
		
	

	public Testutil() throws IOException {
		super();
		
	}

	public static long PageLoadTime = 20;
	public static long ImplicitWait =10;

	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
	
	public static Object[][] GetTestData() throws IOException{
		FileInputStream file= new FileInputStream("C:\\Users\\SimTaj\\workspace\\worspceselenium\\FreeCRMtest\\src\\main\\java\\com\\CRM\\qa\\testdata\\freeCRMdata.xlsx");
	
		XSSFWorkbook wb= new XSSFWorkbook(file);
		XSSFSheet sht= wb.getSheet("Sheet1");
		Object[][] data = new Object[sht.getLastRowNum()][sht.getRow(0).getLastCellNum()];
		for (int i =0; i<sht.getLastRowNum();i++){
			for(int k=0;k<sht.getRow(0).getLastCellNum();k++){
				data[i][k]= sht.getRow(i+1).getCell(k).toString();
			}
		}
		
		return data;
		
		
	}
	

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));}
	
}
