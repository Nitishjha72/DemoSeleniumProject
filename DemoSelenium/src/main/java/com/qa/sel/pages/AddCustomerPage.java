package com.qa.sel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.sel.base.TestBase;
import com.qa.sel.utilities.DriverManager;

public class AddCustomerPage extends TestBase {
	
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input")
	WebElement customerNameInput;
	
	@FindBy(xpath="//input[@id='dob']")
	WebElement dateField;
	
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
	WebElement submitBtn;
	
	@FindBy(xpath="//input[@name='res']")
	WebElement resetBtn;
	
	@FindBy(xpath="//p[@class=\"heading3\" and contains(text(),'Add New Customer')]")
	WebElement addCustomerPageHeader;
	
	@FindBy(xpath="//p[@class=\"heading3\"]")
	WebElement createCustomerSuccessfulMessage;
	
	@FindBy(xpath="//*[@id='customer']/tbody/tr[4]/td[2]")
	WebElement newCustomerId;
	
	public AddCustomerPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	
	public void clickSubmitBtn() {
		submitBtn.click();
	}
	
	public void clickResetBtn() {
		resetBtn.click();
	}
	
	public boolean isPageHeaderPresent() {
		return addCustomerPageHeader.isDisplayed();
	}

	public void enterCustomerDetails(String customerName, String date, String address,
			String city, String state, String pin, String mob,String email, String password
			) {
		customerNameInput.sendKeys(customerName);
		dateField.sendKeys(date);
		addressBox.sendKeys(address);
		cityName.sendKeys(city);
		stateName.sendKeys(state);
		pinNumber.sendKeys(pin);
		mobNumber.sendKeys(mob);
		emailBox.sendKeys(email);
		passwordBox.sendKeys(password);
	}
	
	public boolean checkIsCustomerCreated() {
		return createCustomerSuccessfulMessage.isDisplayed();		
	}
	
	public String getNewCustomerId() {
		return newCustomerId.getText();
	}
}
