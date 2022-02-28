package com.qa.sel.pages;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.sel.base.TestBase;
import com.qa.sel.utilities.DriverManager;

public class LoginPage extends TestBase{

	@FindBy(name="uid")
	WebElement useridTextbox;
	
	@FindBy(name="password")
	WebElement passwordTextbox;
	
	@FindBy(name="btnLogin")
	WebElement loginBtn;
	
	@FindBy(xpath="//h2[@class='barone']")
	WebElement bankLogo;
	
	
	public LoginPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	
	public boolean validateBankLogo() {
		
		return bankLogo.isDisplayed();
	}
	
	public HomePage loginBankWebsite(String userid, String pwd) {
		useridTextbox.sendKeys(userid);
		passwordTextbox.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}
	
	public boolean isAlertPresent() {
		try {
			DriverManager.getDriver().switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	public String getLoginPageTitle() {
		return DriverManager.getDriver().getTitle();
	}

}
