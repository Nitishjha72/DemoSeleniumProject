package com.qa.sel.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.sel.pages.AddCustomerPage;
import com.qa.sel.pages.HomePage;
import com.qa.sel.pages.LoginPage;
import com.qa.sel.utilities.DataProviders;
import com.qa.sel.utilities.Log;

public class AddCustomerPageTest extends AddCustomerPage {

	LoginPage loginPage;
	HomePage homePage;
	AddCustomerPage addCustomerPage;
	
	public AddCustomerPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		addCustomerPage = new AddCustomerPage();
	}
	
	@Test(dataProvider = "addCustomer", dataProviderClass = DataProviders.class)
	public void createNewCustomerTest(String customerName, String date, String address,
			String city, String state, String pin, String mob, String email, String password) throws InterruptedException {
		Log.startTestCase("createNewCustomerTest");
		homePage = loginPage.loginBankWebsite(prop.getProperty("userid"),prop.getProperty("password"));
		Log.info("Login to the application is successful");
		addCustomerPage = homePage.clickOnCustomer();
		addCustomerPage.enterCustomerDetails(customerName, date, address, city, state, pin, mob, email, password);
		addCustomerPage.clickSubmitBtn();
		Assert.assertTrue(addCustomerPage.checkIsCustomerCreated(),"New customer not created");
		Log.info("New customer id is: "+addCustomerPage.getNewCustomerId());
		Log.endTestCase("createNewCustomerTest");
	}
	

}
