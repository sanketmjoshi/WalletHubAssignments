/*******************************************************************
 * This code is Driver Utility to execute any browser Chrome/IE/FF**
 * ******************************************************************/
 

package com.WalletHub;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverUtility1
{
	public static WebDriver supplyDriver(String browser)
	{
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Driver Files1\\chromedriver.exe");
			return new ChromeDriver();				
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\Driver Files1\\chromedriver.exe");
			return new FirefoxDriver();
			
		}
		
		else if(browser.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", "src\\test\\resources\\Driver Files1\\chromedriver.exe");
			return new InternetExplorerDriver();
			
		}
		else
		{
			return null;
			
		}
		
		
	}
	

}
