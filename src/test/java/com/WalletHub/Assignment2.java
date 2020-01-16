package com.WalletHub;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.WalletHub.DriverUtility1;

public class Assignment2
{
	public static WebDriver driver;
	public static Properties obj = new Properties(); 
	public static FileInputStream objfile ;
	
  @Test
  public void function() throws IOException, InterruptedException
  {
	  /*Access the application.properties file and DriverUtility1*/
	  objfile = new FileInputStream(System.getProperty("user.dir")+"\\application.properties");
	  obj.load(objfile);
	  driver=DriverUtility1.supplyDriver("chrome");
	  driver.manage().window().maximize();
	  driver.get(obj.getProperty("baseUrl1"));
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//button[@class='btn blue-brds']")).click();//Click Write Review button
	  WebElement star1= driver.findElement(By.cssSelector("#reviews-section > modal-dialog > div > div > write-review > review-star > div > svg:nth-child(1)"));
	  WebElement star2= driver.findElement(By.cssSelector("#reviews-section > modal-dialog > div > div > write-review > review-star > div > svg:nth-child(2)"));
	  WebElement star3= driver.findElement(By.cssSelector("#reviews-section > modal-dialog > div > div > write-review > review-star > div > svg:nth-child(3)"));
	  WebElement star4= driver.findElement(By.cssSelector("#reviews-section > modal-dialog > div > div > write-review > review-star > div > svg:nth-child(4)"));
	  
	 Actions act = new Actions(driver);
	
	 act.moveToElement(star1).perform();
	// Thread.sleep(2000);
	 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 act.moveToElement(star2).perform();
	// Thread.sleep(2000);
	 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 act.moveToElement(star3).perform();
	// Thread.sleep(2000);
	 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 act.moveToElement(star4).perform();
	// Thread.sleep(2000);
	 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 star4.click();
	WebElement dropBox= driver.findElement(By.xpath("//div[@class='dropdown second']"));
	dropBox.click();
	//Thread.sleep(2000);
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//li[@class='dropdown-item' and text()='Health Insurance']")).click();//Click Text area
	driver.findElement(By.xpath("//textarea[@class='textarea wrev-user-input validate']")).sendKeys(obj.getProperty("text"));//Enter text upto 200 characters
	String charCount = driver.findElement(By.xpath("//span[@class='bold-font color-aqua']")).getText();//Get the count of text
	System.out.println("The count is   :"+charCount);
	driver.findElement(By.xpath("//div[ text()='Submit']")).click();//Click Submit button
	
	//Thread.sleep(2000);
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	driver.findElement(By.xpath("//li[@ng-class=\"{selected: is_tab('login')}\"]/a")).click();
	
	  //Thread.sleep(1000);
	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	 
	  driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("sanketmjoshi@gmail.com");//Enter Username
	  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("@Wallethub123");//Enter Pasword
	  driver.findElement(By.xpath("//span[text()='Login']")).click();//Click Login button
	

	  
	 // Thread.sleep(1000); 
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	WebElement username = driver.findElement(By.xpath("//div[@class='brgm-button brgm-user brgm-list-box']/span"));//move to username Sanket
	act.moveToElement(username).perform();
	driver.findElement(By.xpath("//div[@class='brgm-list brgm-user-list']/a[text()='Profile']")).click();//Click Profile menu
	String recommendationHeader = driver.findElement(By.xpath("//section[@class='pr-ct-box pr-rec']/h2")).getText();
	if(recommendationHeader.contains("Sanket Joshi's Recommendations"))
	{
		System.out.println("Review Feed is updated on the profile page");
	}
	else
	{
		System.out.println("Review feed is not updated on the profile page");
	}
	
	driver.findElement(By.xpath("//div[@class='pr-rec-texts-container']/a")).click();//Click hyperlink Test Insurance Company
	WebElement commentBy= driver.findElement(By.xpath("//span[@class='rvtab-ci-nickname regular-font' and text()='@sanketmjoshi']"));
	 String postedBy =commentBy.getText();
	//act.moveToElement(commentBy).perform();	
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(0,1000)");
     Assert.assertEquals(postedBy, "@sanketmjoshi");
     System.out.println("Review is displayed !");
	
	
  }
}




