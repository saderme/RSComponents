package com.rs.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rs.ExtentListeners.ExtentTestManager;
import com.rs.utilities.DriverFactory;
import com.rs.utilities.DriverManager;

public abstract class BasePage<T> {


	protected RS_Top_Menu topMenu;
	protected RS_ProductListPage pl;
	protected RS_ProductDetailPage pd;	
	
	public WebElement mnu_Our_Services;
	
	
	protected WebDriver driver;
	
	 private long LOAD_TIMEOUT = 40;
     private int AJAX_ELEMENT_TIMEOUT = 30;

	    public BasePage() {
	        this.driver = DriverManager.getDriver();
	    }
	    
	    
	    public T openPage(Class<T> clazz) {
	        T page = null;
	        try {
	            driver = DriverManager.getDriver();
	            AjaxElementLocatorFactory ajaxElemFactory = new AjaxElementLocatorFactory(driver, AJAX_ELEMENT_TIMEOUT);
	            page = PageFactory.initElements(driver, clazz);
	            PageFactory.initElements(ajaxElemFactory, page);
	            ExpectedCondition pageLoadCondition = ((BasePage) page).getPageLoadCondition();
	            waitForPageToLoad(pageLoadCondition);
	   
	            
	        } catch (NoSuchElementException e) {
	        /*    String error_screenshot = System.getProperty("user.dir") + "\\target\\screenshots\\" + clazz.getSimpleName() + "_error.png";
	            this.takeScreenShot(error_screenshot);
	     */       throw new IllegalStateException(String.format("This is not the %s page", clazz.getSimpleName()));
	        }
	        return page;
	    }


	    
	    private void waitForPageToLoad(ExpectedCondition pageLoadCondition) {
	    	WebDriverWait wait = new WebDriverWait(driver,LOAD_TIMEOUT);
	        wait.until(pageLoadCondition);
	    }

	    protected abstract ExpectedCondition getPageLoadCondition();

	    protected abstract boolean isErrorVisible();
	    
		public void click(WebElement element, String elementName) {
			element.click();
			ExtentTestManager.testReport.get().info("Clicking on : "+elementName);
		}


		public void type(WebElement element, String value, String elementName) {

			element.sendKeys(value);
			ExtentTestManager.testReport.get().info("Typing in : "+elementName+" entered the value as : "+value);
		
		}
	
		public void gotoTopMenuOption(String menuOption){
			
            AjaxElementLocatorFactory ajaxElemFactory = new AjaxElementLocatorFactory(driver, AJAX_ELEMENT_TIMEOUT);
            topMenu = PageFactory.initElements(driver, RS_Top_Menu.class);
            PageFactory.initElements(ajaxElemFactory, topMenu);	 
            
			if (menuOption.equals("All Products")) {
				click(topMenu.getAllProductsElem(), "All Products");
			} else if (menuOption.equals("My Account")) {
				click(topMenu.getMyAccountElem(), "My Account");
			}else if (menuOption.equals("New Products")) {
				click(topMenu.getNewProductsElem(), "New Products");
			}
		}

		public void gotoSubMenuOption(String submenuOption){
			
			click(topMenu.getElement(submenuOption), submenuOption);

		}

		public void clickFilter(String filterOption){
            AjaxElementLocatorFactory ajaxElemFactory = new AjaxElementLocatorFactory(driver, AJAX_ELEMENT_TIMEOUT);
            pd = PageFactory.initElements(driver, RS_ProductDetailPage.class);
            PageFactory.initElements(ajaxElemFactory, pd);	 
			
			scrollToElelement(pd.getProductFilterElem(filterOption));
			click(pd.getProductFilterElem(filterOption), filterOption);
		}

		public void clickFilterValue(String filterValue){
            AjaxElementLocatorFactory ajaxElemFactory = new AjaxElementLocatorFactory(driver, AJAX_ELEMENT_TIMEOUT);
            pd = PageFactory.initElements(driver, RS_ProductDetailPage.class);
            PageFactory.initElements(ajaxElemFactory, pd);	 			
			click(pd.getProductFilterValueElem(filterValue), filterValue);
		}
		
		public void clickApplyFilter(){
        AjaxElementLocatorFactory ajaxElemFactory = new AjaxElementLocatorFactory(driver, AJAX_ELEMENT_TIMEOUT);
            pd = PageFactory.initElements(driver, RS_ProductDetailPage.class);
            PageFactory.initElements(ajaxElemFactory, pd);			
			click(pd.getApplyFilterElem(), "Click Apply Filter");
		}		
		
		
		
		
		public void gotoProductCategory(String gotoProductCategory){
			
            AjaxElementLocatorFactory ajaxElemFactory = new AjaxElementLocatorFactory(driver, AJAX_ELEMENT_TIMEOUT);
            pl = PageFactory.initElements(driver, RS_ProductListPage.class);
            PageFactory.initElements(ajaxElemFactory, pl);	 

			click(pl.getProductElem(gotoProductCategory),gotoProductCategory);
		}	
		
		public void scrollDown() {
			JavascriptExecutor jse = (JavascriptExecutor)driver; 
			jse.executeScript("scroll(0, 250);");
		}
		
		public void selectProduct(String product){
			
            AjaxElementLocatorFactory ajaxElemFactory = new AjaxElementLocatorFactory(driver, AJAX_ELEMENT_TIMEOUT);
            pl = PageFactory.initElements(driver, RS_ProductListPage.class);
            PageFactory.initElements(ajaxElemFactory, pl);	 

			click(pl.getProductElem(product),product);
		}
		

		public String getProductCount(){
			
            AjaxElementLocatorFactory ajaxElemFactory = new AjaxElementLocatorFactory(driver, AJAX_ELEMENT_TIMEOUT);
            pd = PageFactory.initElements(driver, RS_ProductDetailPage.class);
            PageFactory.initElements(ajaxElemFactory, pd);	
            String pcount = pd.getProductCountText();
			ExtentTestManager.testReport.get().info("Product Count is: "+pcount);
            return pcount;
		}
		
		public void scrollToElelement (WebElement element) {
			Actions actions = new Actions(driver);
			actions.moveToElement(element);
			actions.perform();
		}
}
