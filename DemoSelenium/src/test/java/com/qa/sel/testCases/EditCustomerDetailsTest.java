package com.qa.sel.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.sel.pages.EditCustomerDetails;
import com.qa.sel.pages.HomePage;
import com.qa.sel.pages.LoginPage;
import com.qa.sel.utilities.DataProviders;
import com.qa.sel.utilities.Log;

public class EditCustomerDetailsTest extends EditCustomerDetails {

	LoginPage loginPage;
	HomePage homePage;
	EditCustomerDetails editCustDetail;
	
	public EditCustomerDetailsTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		editCustDetail = new EditCustomerDetails();
	}
	
	@Test(dataProvider = "editCustomerDetails", dataProviderClass = DataProviders.class)
	public void editCustomerDetailTest(String address, String city, String state, String pin, String mob, String email) {
		Log.startTestCase("editCustomerDetailTest");
		homePage = loginPage.loginBankWebsite(prop.getProperty("userid"),prop.getProperty("password"));
		Log.info("Login to the application is successful");
		editCustDetail = homePage.clickOnEditCustomer();
		editCustDetail.enterCustId(prop.getProperty("custId"));
		editCustDetail.clearAllTextBoxes();
		editCustDetail.enterNewDetails(address, city, state, pin, mob, email);
		Assert.assertTrue(editCustDetail.isChangeAlertPresent(),"Records not changed. Some issue occurred!");
		Log.endTestCase("editCustomerDetailTest");
	}
	


}
