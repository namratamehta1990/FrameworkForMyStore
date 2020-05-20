package com.mystore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyWishListsPage
{

	public WebDriver driver;

	public MyWishListsPage(WebDriver ldriver)
	{
		this.driver = ldriver;
		System.out.println("Inside My Wish Lists constructor");
	}
	
	@FindBy(xpath="//*[@class='lnk_wishlist']/a/span") 
	WebElement myWishListsBtn;
	
	@FindBy(xpath="(//*[@class='icon-chevron-left'])[1]") 
	WebElement backToYourAccount;
	
	public void verifyMyWishListsPage() throws InterruptedException
	{
		System.out.println("Inside My Wish Lists Method");
		Thread.sleep(3000);
		
		myWishListsBtn.click();
		Thread.sleep(3000);
		
		backToYourAccount.click();
		Thread.sleep(3000);
		
	}

}
