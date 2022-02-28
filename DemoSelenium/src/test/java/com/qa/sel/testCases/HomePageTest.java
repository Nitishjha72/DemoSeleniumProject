package com.qa.sel.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.sel.pages.AddCustomerPage;
import com.qa.sel.pages.HomePage;
import com.qa.sel.pages.LoginPage;
import com.qa.sel.utilities.Log;

public class HomePageTest extends HomePage {
	
	HomePage homePage;
	LoginPage loginPage;
	AddCustomerPage addCustomerPage;
	
	public HomePageTest(){
		super();

	}
	
	@BeforeMethod()
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		addCustomerPage = new AddCustomerPage();
	}
	
	
	@Test
	public void testAddNewCustomerNavigationTest() throws InterruptedException {
		Log.startTestCase("testAddNewCustomerNavigationTest");
		homePage = loginPage.loginBankWebsite(prop.getProperty("userid"),prop.getProperty("password"));
		Log.info("Login to the application is successful");
		addCustomerPage =homePage.clickOnCustomer();
		Assert.assertTrue(addCustomerPage.isPageHeaderPresent(),"Navigation to customer page is not working");
		Log.endTestCase("testAddNewCustomerNavigationTest");	
	}

}
