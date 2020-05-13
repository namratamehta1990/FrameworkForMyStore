package com.mystore.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactory 
{
	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL)
	{
		System.out.println("Inside startApplication Method");
		
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\eclipse-workspace_GIC\\FrameworkForMyStore\\Drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito"); options.addArguments("enable-automation"); options.addArguments("--headless"); options.addArguments("--no-sandbox"); options.addArguments("--window-size=1920,1080"); options.addArguments("--disable-gpu"); options.addArguments("--disable-extensions"); options.addArguments("--dns-prefetch-disable"); options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			
			driver = new ChromeDriver();
			
		}
		else if(browserName.equals("Chrome"))
		{
			
		}
		else
		{
			System.out.println("We do not support this browser");
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);	
		
		try
		{
			driver.get(appURL);	
		}
		catch(Exception e)
		{
			driver.navigate().refresh();
		}
		
		System.out.println("App url is : "+appURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public static void quitBrowser(WebDriver driver)
	{
		System.out.println("Inside QuiteBrowser Method");
		driver.quit();
	}
}
