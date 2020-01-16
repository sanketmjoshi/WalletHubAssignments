package com.WalletHub;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment1
{
	public static WebDriver driver;
	public static Properties obj = new Properties(); 
	public static FileInputStream objfile ;
	
	
	
  @BeforeTest
  public void function() throws IOException, InterruptedException 
  {
	  /*Access the application.properties file and DriverUtility1*/
	  objfile = new FileInputStream(System.getProperty("user.dir")+"\\application.properties");
	  obj.load(objfile);
	  driver=DriverUtility1.supplyDriver("chrome");
	  driver.manage().window().maximize();
	  driver.get(obj.getProperty("fbUrl"));
	  
  }
  
  @Test
	public void readexcel() throws IOException, InterruptedException
	{
	 
	  String path = "src\\test\\resources\\Test Data.xlsx";
	  File file = new File(path);
	  try
	  {
		InputStream is = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(is);
		XSSFSheet sheet1 = 	workbook.getSheet("Sheet1");

		int lastrow = sheet1.getLastRowNum();
		System.out.println(lastrow);
		
          String userName=sheet1.getRow(1).getCell(0).getStringCellValue();
          String password=sheet1.getRow(1).getCell(1).getStringCellValue();
			login(userName,password);
			workbook.close();
	
	  }
	  catch (FileNotFoundException e)
	  {
		e.printStackTrace();
	  }
		  
	}
  
	  
	  public void login(String emailId,String password) throws InterruptedException 
		 {
		  driver.findElement(By.xpath("//input[@id='email']")).sendKeys(emailId);
		  driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
		  driver.findElement(By.xpath("//input[@value='Log In']")).click();
		  Thread.sleep(10000);
		  driver.findElement(By.xpath("//span[text()='Create Post']")).click();
		  Thread.sleep(10000);
		  driver.findElement(By.xpath("//div[@class='_1p1v']")).sendKeys("Hello World");
		  driver.findElement(By.xpath("//button[@class='_1mf7 _4r1q _4jy0 _4jy3 _4jy1 _51sy selected _42ft _42fr']")).click();
		 
		   }
	  
	  
  }
  
  
  
  

