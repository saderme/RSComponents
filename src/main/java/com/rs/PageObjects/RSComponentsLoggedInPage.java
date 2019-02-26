package com.rs.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RSComponentsLoggedInPage extends BasePage{
	
	@FindBy(xpath = "//a[@title='Log Out']")
	public WebElement signout;
	
	@FindBy(xpath = "//a[@title='All Products']")
	public WebElement mnu_All_Products;

	@FindBy(xpath = "//a[@title='Our Brands']")
	public WebElement mnu_Our_Brands;
	
	@FindBy(xpath = "//a[@title='New Products']")
	public WebElement mnu_New_Products;
	
	@FindBy(xpath = "//a[@title='My Account']")
	public WebElement mnu_My_Account;
	
	@FindBy(xpath = "//a[@title='Our Services']")
	public WebElement mnu_Our_Services;
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(signout);
	}
	
	public boolean isUserLoggedIn() {
		return signout.isDisplayed();

	}

	@Override
	protected boolean isErrorVisible() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
	

	
	
