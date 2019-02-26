package com.rs.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.rs.utilities.DriverManager;

public class RSComponentsHomePage extends BasePage {
		
	@FindBy(xpath = "//span[@class='keyValue bold']")
	private WebElement stockId;
	private String stockText;
	

	@FindBy(xpath="//a[@id=\"js-logInOut\"]")
	public WebElement logIn;

	@FindBy(xpath="//button[@id='btnSearch']")
	public WebElement searchIcon;
	
	
	@FindBy(xpath="//input[@id='searchTerm']")
	public WebElement searchBox;

	@FindBy(xpath="//button[contains(text(),'Add to basket')]")
	public WebElement addToBasket;
	
	
	@FindBy(xpath="//i[@class='icon-cart']")
	public WebElement viewBasket;
	
	public RSComponentsHomePage open(String url) {
	
		System.out.println("Page Opened");
		DriverManager.getDriver().navigate().to(url);
		return (RSComponentsHomePage) openPage(RSComponentsHomePage.class);
	}
	
	public RSComponentsLoginPage gotoLogin(){
		System.out.println("inside go to login");
		click(logIn, "Login Link");
		return (RSComponentsLoginPage) openPage(RSComponentsLoginPage.class);
			
	}

	public String getStockText(){
		stockText = stockId.getAttribute("innerHTML");
		return stockText;
	}
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(logIn);
	}

	@Override
	protected boolean isErrorVisible() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public WebElement getSearchBoxElement() {
		return searchBox;
	}
	
	public void search(String searchVal){
		
		type(searchBox,searchVal, "Search Box");
		click(searchIcon,"Search Icon");
	}

	public void clickAddtoBasket() {
		scrollToElelement(addToBasket);
		click(addToBasket,"Click Add to Basket");	
	}	
	
	public void clickViewBasket() {
		scrollToElelement(viewBasket);
		click(viewBasket,"Click View Basket");	
	}		

}
