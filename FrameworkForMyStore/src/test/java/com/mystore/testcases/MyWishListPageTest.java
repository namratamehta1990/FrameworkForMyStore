package com.mystore.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.mystore.baseClass.BaseClass;
import com.mystore.pages.LoginPage;
import com.mystore.pages.MyWishListsPage;
import com.mystore.utilities.ExcelDataProvider;
import com.mystore.utilities.Helper;


public class MyWishListPageTest extends BaseClass 
{
		
	@Test()
	public void verifyMyWishListPageTest() throws InterruptedException
	{
		System.out.println("Inside My Wish Lists Method");
		
		logger=extent.createTest("My Wish List application"); 
	
		MyWishListsPage myWishListsPage = PageFactory.initElements(driver, MyWishListsPage.class);
		
		logger.info("Visit My Wish Lists Page Application");
		
		myWishListsPage.verifyMyWishListsPage();

		logger.pass("My Wish Lists page visited successfully");
		
		//extent.flush();

	}
	
	
}
