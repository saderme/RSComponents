package com.rs.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RSComponentsLoginPage extends BasePage {

	@FindBy(xpath = "//input[@name='username']")
	public WebElement email;

	@FindBy(xpath = "//input[@name='j_password']")
	public WebElement pass;

	@FindBy(xpath = "//input[@title='Log in']")
	public WebElement signin;

	@FindBy(xpath = "//h4[contains(text(),'Your Username and/or Password is invalid')]")
	public WebElement errormsg;	

	
	public RSComponentsLoginPage doLoginAsInvalidUser(String username, String password) {

		type(email, username, "Username textbox");
		type(pass, password, "Password textbox");
		click(signin, "Log in Button");
		return this;
	}

	public RSComponentsLoggedInPage doLoginAsValidUser(String username, String password) {

		type(email, username, "Username textbox");
		type(pass, password, "Password textbox");
		click(signin, "Log in Button");
		
		return (RSComponentsLoggedInPage) openPage(RSComponentsLoggedInPage.class);

	}
	
	public void selectProduct(String product) {

		RS_ProductListPage pl = (RS_ProductListPage) openPage(RS_ProductListPage.class);
		click(pl.getProductElem(product), "Log in Button");

	}
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(email);
	}
	
	public boolean isErrorVisible() {
		// TODO Auto-generated method stub
		return errormsg.isDisplayed();
	}
}
