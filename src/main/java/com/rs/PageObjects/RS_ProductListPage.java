package com.rs.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.rs.ExtentListeners.ExtentTestManager;


public class RS_ProductListPage extends BasePage{

	
	@FindBy(xpath = "//div[@id='categories-grid']")
	private WebElement pl_categories;
	
	@FindBy(xpath = "//h2[@title='Circular Connectors']")
	private WebElement pl_Circ_Connectors;

	@FindBy(xpath = "//h2[@title='DIN Connectors']")
	private WebElement pl_DIN_Connectors;
	
		
	
	public WebElement getProductElem(String product){
		
		if ( product.equalsIgnoreCase("Circular Connectors"))
		{
			return pl_Circ_Connectors;
		} else if(product.equalsIgnoreCase("DIN Connectors")) {
			
			return pl_DIN_Connectors;
		}
		
		return null;
	}
	
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(pl_categories);
	}
	

	@Override
	protected boolean isErrorVisible() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void gotoMenu(WebElement element, String elementName){
		System.out.println("clicked on " + elementName);
		click(element, elementName);
	}

	public void hoverOnMenu(WebElement element, String elementName) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();		
	}	
	
}
	

	
	
