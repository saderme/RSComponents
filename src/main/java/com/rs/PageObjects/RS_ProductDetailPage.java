package com.rs.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.rs.ExtentListeners.ExtentTestManager;


public class RS_ProductDetailPage extends BasePage{

	
	@FindBy(xpath = "//span[@class='number']")
	private WebElement prodcount;
	
	@FindBy(xpath = "//a[contains(text(),'Mounting Type')]")
	private WebElement pf_mountingType;	

	@FindBy(xpath = "//label[@id='4294698844']//span[@class='icon icon-rs_150-checkbox filterCheckbox']")
	private WebElement chk_chassisMount;		
	
	@FindBy(xpath = "//rs-apply-button[@apply-function='facetFilters.applyFilters(1)']")
	private WebElement btn_apply_filter;			
	
	
	private String prodcountText;
	
	public WebElement getProductCountElem(){
		return prodcount;
	}
	
	public WebElement getApplyFilterElem(){
		return btn_apply_filter;
	}	
		
	public String getProductCountText(){
		prodcountText = prodcount.getAttribute("innerHTML");
		return prodcountText;
	}	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(prodcount);
	}
	
	public WebElement getProductFilterElem(String prodFilter){
		
		if ( prodFilter.equalsIgnoreCase("Mounting Type"))
		{
			return pf_mountingType;
		}
		//there is only one check so returning same element as default
		return pf_mountingType;
	}
	
	public WebElement getProductFilterValueElem(String prodValue){
		
		if ( prodValue.equalsIgnoreCase("Chassis Mount"))
		{
			return chk_chassisMount;
		}
		return chk_chassisMount;
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
	

	
	
