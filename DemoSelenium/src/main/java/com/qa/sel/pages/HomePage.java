package com.qa.sel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.sel.base.TestBase;
import com.qa.sel.utilities.DriverManager;

public class HomePage extends TestBase{

	@FindBy(xpath="//a[contains(text(),'Edit Customer')]")
	WebElement editCustomerNav;
	
	@FindBy (xpath="//tr[@class='heading3']/td")
	WebElement managerId;
	
	@FindBy (xpath="//a[text()='New Customer']")
	WebElement newCustomerBtn;
	

	public HomePage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	public EditCustomerDetails clickOnEditCustomer() {
		editCustomerNav.click();
		return new EditCustomerDetails();
	}
	
	public String getManagerId() {
		String manager = managerId.getText();
		return manager;
	}
	
	public AddCustomerPage clickOnCustomer() {
		newCustomerBtn.click();
		return new AddCustomerPage();
	}
	
}
