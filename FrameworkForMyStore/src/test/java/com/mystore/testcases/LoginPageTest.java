package com.mystore.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.mystore.baseClass.BaseClass;
import com.mystore.pages.LoginPage;
import com.mystore.utilities.ExcelDataProvider;
import com.mystore.utilities.Helper;


public class LoginPageTest extends BaseClass 
{
	
	@Test(priority=1)
	public void loginApp() throws InterruptedException
	{
		System.out.println("Inside loginApp Method");
		
		logger=report.createTest("MyStore application"); 
	
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting Application");

		loginPage.loginToApplication(excel.getStringdata("Login", 0, 0), excel.getStringdata("Login", 0, 1));
		
		logger.pass("Login done successfully");

	}
	
	
}
