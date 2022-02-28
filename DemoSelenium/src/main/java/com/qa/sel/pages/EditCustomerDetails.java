package com.qa.sel.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.sel.base.TestBase;
import com.qa.sel.utilities.DriverManager;
import com.qa.sel.utilities.Log;

public class EditCustomerDetails extends TestBase{

	public EditCustomerDetails() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	
	@FindBy(xpath="//*[@id='message3']/preceding-sibling::textarea")
	WebElement addressBox;
	
	@FindBy(xpath="//input[@name='city']")
	WebElement cityName;
	
	@FindBy(xpath="//*[@id='message5']/preceding-sibling::input")
	WebElement stateName;
	
	@FindBy(xpath="//input[@name='pinno']")
	WebElement pinNumber;

	@FindBy(xpath="//input[@name='telephoneno']")
	WebElement mobNumber;

	@FindBy(xpath="//input[@name='emailid']")
	WebElement emailBox;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordBox;
	
	@FindBy(xpath="//input[@name='sub']")
	WebElement editDetailSubmitBtn;
	
	@FindBy(xpath="//input[@name='cusid']")
	WebElement editCustIdTextBox;
	
	@FindBy(xpath="//input[@name='AccSubmit']")
	WebElement custIdSubmitBtn;

	public void clearAllTextBoxes() {
		addressBox.clear();
		cityName.clear();
		stateName.clear();
		pinNumber.clear();
		mobNumber.clear();
		emailBox.clear();
	}
	
	public void enterNewDetails(String address, String city, String state, String pin, String mob, String email) {
		addressBox.sendKeys(address);
		cityName.sendKeys(city);
		stateName.sendKeys(state);
		pinNumber.sendKeys(pin);
		mobNumber.sendKeys(mob);
		emailBox.sendKeys(email);
		editDetailSubmitBtn.click();
	}
	
	public void enterCustId(String custId) {
		editCustIdTextBox.sendKeys(custId);
		custIdSubmitBtn.click();
	}
	
	public boolean isChangeAlertPresent() {
		try {
			Alert alert = DriverManager.getDriver().switchTo().alert();
			Log.info("Alert present with the message: "+alert.getText());
			alert.accept();
			return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
	}

}
