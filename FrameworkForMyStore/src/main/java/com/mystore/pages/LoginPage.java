package com.mystore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage 
{
	public WebDriver driver;

	public LoginPage(WebDriver ldriver)
	{
		this.driver = ldriver;
		System.out.println("Inside LoginPage constructor");
	}
	
	@FindBy(className="login") 
	WebElement signInBtn;
	
	@FindBy(id="email") 
	WebElement emailID;
	
	@FindBy(id="passwd") 
	WebElement password;
	
	@FindBy(id="SubmitLogin") 
	WebElement signIn;
	
	public void loginToApplication(String emailIDApp, String passwordApp)
	{
		System.out.println("Inside loginToApplication Method");
		
		signInBtn.click();
		
		emailID.click();
		emailID.sendKeys(emailIDApp);
		
		password.click();
		password.sendKeys(passwordApp);
		
		signIn.click();
		
	}
	
}
