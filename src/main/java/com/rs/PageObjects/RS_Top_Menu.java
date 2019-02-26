package com.rs.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.rs.ExtentListeners.ExtentTestManager;


public class RS_Top_Menu extends BasePage{
	
	//Main Menu
	@FindBy(xpath = "//a[@title='All Products']")
	private WebElement mnu_All_Products;

	@FindBy(xpath = "//a[@title='Our Brands']")
	private WebElement mnu_Our_Brands;
	
	@FindBy(xpath = "//a[@title='New Products']")
	private WebElement mnu_New_Products;
	
	@FindBy(xpath = "//a[@title='My Account']")
	private WebElement mnu_My_Account;
	
	@FindBy(xpath = "//a[@title='Our Services']")
	private WebElement mnu_Our_Services;
	
	//Submenu
	@FindBy(xpath = "//a[@href='/web/c/connectors/']")
	private WebElement sub_AP_Connectors;


	public WebElement getAllProductsElem(){return this.mnu_All_Products;}
	public WebElement getOurBrandsElem()  {return this.mnu_Our_Brands;	}
	public WebElement getMyAccountElem() {return this.mnu_My_Account;	}
	public WebElement getNewProductsElem(){return this.mnu_New_Products;}
	
	public WebElement getElement(String element){
		if (element.equals("Connectors")) {
			return sub_AP_Connectors;			
		} 
		return null;
	}	

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(mnu_All_Products);
	}
	

	@Override
	protected boolean isErrorVisible() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void hoverOnMenu(WebElement element, String elementName) {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();		
	
	}	
	
}
	

	
	
