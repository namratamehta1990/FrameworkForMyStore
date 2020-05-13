package com.mystore.baseClass;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentAventReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.mystore.utilities.BrowserFactory;
import com.mystore.utilities.ConfigDataProvider;
import com.mystore.utilities.ExcelDataProvider;
import com.mystore.utilities.Helper;

public class BaseClass 
{
	public WebDriver driver;
	
	public ExcelDataProvider excel;
	
	public ConfigDataProvider config;
	
	public ExtentReports report;
	public ExtentTest logger;
	String reportPath;
	
	@BeforeSuite
	public void setUpSuite()
	{
		Reporter.log("Setting up reports and test started", true);
		
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();	
		
		reportPath = System.getProperty("user.dir")+"/Reports/MyStore_"+Helper.getCurrentDateTime()+".html";
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(reportPath));		
		
		report = new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Setting Done and test can be started", true);
	}

	
	@Parameters({"browser","url"})
	@BeforeClass
	public void setUp(String Browser, String qaUrl)
	{
		Reporter.log("Trying to start browser and getting application ready", true);
				
		System.out.println("Inside setUp Method");
		
		
		//driver = BrowserFactory.startApplication(driver,config.getBrowser(),config.getStagingURL());
		driver = BrowserFactory.startApplication(driver, Browser, qaUrl);
		
		Reporter.log("Browser and application is up and running", true);
	}

	@AfterClass
	public void tearDown()
	{
		System.out.println("Inside tearDown Method");
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result)
	{
		Reporter.log("Test is about to end", true);
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			try 
			{
				logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			} 
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			try 
			{
				logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			try 
			{
				logger.skip("Test Skipped", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		report.flush();
		
		Reporter.log("Test completed --- reports generated", true);
	}
}
