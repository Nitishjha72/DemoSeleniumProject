package com.qa.sel.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.sel.pages.HomePage;
import com.qa.sel.pages.LoginPage;
import com.qa.sel.utilities.Constants;
import com.qa.sel.utilities.Log;

public class LoginPageTest extends LoginPage  {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
		
	}
	
	@BeforeMethod()
	public void setup() {
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test
	public void loginPageTitleTest() {
		Log.startTestCase("loginPageTitleTest");
		String actualTitle = loginPage.getLoginPageTitle();
		Log.info("Actual title found is: "+actualTitle);
		Assert.assertEquals(actualTitle, Constants.LOGIN_PAGE_TITLE,"Login page title is different from what is expected");
		Log.endTestCase("loginPageTitleTest");
	}
	
	@Test
	public void bankLogoTest() {
		Log.startTestCase("bankLogoTest");
		Boolean isLogoPresent = loginPage.validateBankLogo();
		Assert.assertTrue(isLogoPresent);
		Log.endTestCase("bankLogoTest");
	}
	
	@Test
	public void loginTest() {
		Log.startTestCase("loginTest");
		homePage = loginPage.loginBankWebsite(prop.getProperty("userid"),prop.getProperty("password"));
		String managerId = homePage.getManagerId();
		Assert.assertTrue(managerId.contains(prop.getProperty("userid")));
		Log.endTestCase("loginTest");
	}
	
	
}
