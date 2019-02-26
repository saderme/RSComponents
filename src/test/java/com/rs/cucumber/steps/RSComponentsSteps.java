package com.rs.cucumber.steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.aventstack.extentreports.Status;
import com.rs.PageObjects.BasePage;
import com.rs.PageObjects.RSComponentsLoggedInPage;
import com.rs.PageObjects.RSComponentsHomePage;
import com.rs.PageObjects.RSComponentsLoginPage;
import com.rs.utilities.DriverManager;
import com.rs.ExtentListeners.ExtentManager;
import com.rs.ExtentListeners.ExtentTestManager;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RSComponentsSteps extends BaseSteps {

	public RSComponentsHomePage home;
	public RSComponentsLoginPage loginPage;
	public RSComponentsLoggedInPage signedinPage;

	protected Scenario scenario;
	static String scenarioName;
	static int x = 0;

	@Before
	public synchronized void  before(Scenario scenario) {

		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		x = x + 1;
		this.scenario = scenario;
		scenarioName = scenario.getName();
		ExtentTestManager.startTest("Scenario No : " + x + " : " + scenario.getName());
		ExtentTestManager.getTest().log(Status.INFO, "Scenario started : - " + scenario.getName());
		setUpFramework();
	}

	@After
	public void after(Scenario scenario) {

		if (scenario.isFailed()) {

			ExtentTestManager.logFail("Scenario Failed");
			ExtentTestManager.addScreenShotsOnFailure();
		} else {

			ExtentTestManager.scenarioPass();
		}

		ExtentManager.getReporter().flush();
		quit();

	}
	
	@Given("^launch browser '(.*?)'$")
	public void launch_browser(String browserName) throws Throwable {
		openBrowser(browserName);
	   ExtentTestManager.logInfo("Browser Opened : "+browserName);
	}

	@When("^user navigates to the URL '(.*?)'$")
	public void user_navigates_to_the_URL(String URL) throws Throwable {
	
		home = new RSComponentsHomePage().open(URL);
	}
	
	@And("^user clicks on '(.*?)' menu$")
	public void user_clicks_on_menu(String menuOption) throws Throwable {
		home.gotoTopMenuOption(menuOption);
	}

	@And("^user clicks on '(.*?)' submenu$")
	public void user_clicks_on_submenu(String menuOption) throws Throwable {
		home.gotoSubMenuOption(menuOption);
	}
	
	@And("^user clicks on '(.*?)' product category$")
	public void user_clicks_on_product_category(String prodCatOption) throws Throwable {
		home.gotoProductCategory(prodCatOption);
	}

    @And("^user filters on '(.*?)', selecting '(.*?)'$")
	public void user_filter_selecting(String filterOption, String filterValue) throws Throwable {
		home.clickFilter(filterOption);
		home.clickFilterValue(filterValue);	
		home.clickApplyFilter();
	}
	

	@Then("^product count should be '(.*?)'$")
	public void prod_count_should_be(String prodCount) throws Throwable {
		String actual = home.getProductCount();
		assertEquals(actual, prodCount, "Check product count");
	}
/*	@And("^user hovers on '(.*?)' menu$")
	public void user_hovers_on_menu(String menuOption) throws Throwable {
		home.hoverOnMenu(menuOption);

	}

	@And("^user hovers and clicks on '(.*?)' menu$")
	public void user_hovers_and_clickson_menu(String menuOption) throws Throwable {
		home.hoverClickOnMenu(menuOption);
	}	*/
	
	@And("^user selects '(.*?)' from the products page$")
	public void user_selects_products_from_products_page(String product) throws Throwable {
		home.selectProduct(product);
	}		
	
	@And("^the user searches for '(.*?)'$")
	public void user_searches_for_searchval(String searchVal) throws Throwable {
		home.search(searchVal);
	}		
	
	@And("^the user clicks Add to Basket$")
	public void user_clicks_add_to_basket() throws Throwable {
		home.clickAddtoBasket();
	}		     

	@And("^the user clicks View Basket$")
	public void user_clicks_view_basket() throws Throwable {
		home.clickViewBasket();
	}		     
	
	
	@When("^the product page for '(.*?)' is displayed$")
	public void product_page_displayed(String searchVal) throws Throwable {
		assertEquals(home.getStockText(), searchVal);
	}		
	
	
	@Then("^user click on login$")
	public void user_click_on_login() throws Throwable {
	
		loginPage = home.gotoLogin();
 	}
	
	@Then("^user logs in with valid credentials '(.*?)' and '(.*?)'$")
	public void user_enters_valid_credentials(String userName,String password) throws Throwable {
		signedinPage = loginPage.doLoginAsValidUser(userName, password);
	}	

	@Then("^user logs in with invalid credentials '(.*?)' and '(.*?)'$")
	public void user_enters_invalid_credentials(String userName,String password) throws Throwable {
		loginPage.doLoginAsInvalidUser(userName, password);
	}	
	
	@Then("^user is successfully logged in$")
	public void user_successfully_logged_in() throws Throwable {
		assertTrue(signedinPage.isUserLoggedIn());
	}
	
	@Then("^error message '(.*?)' is displayed$")
	public boolean error_message_is_displayed(String errormsg) throws Throwable {
		
		return loginPage.isErrorVisible();
	   
	}	
}
