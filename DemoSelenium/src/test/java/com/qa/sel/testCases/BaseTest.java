package com.qa.sel.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

	private WebDriver driver;
	public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();
	
	public WebDriver getDriver() {
		return dr.get();
	}
	
	public void setDriver(WebDriver driver) {
		dr.set(driver);
	}
	
	public void openBrowser(String browser) {
		if(browser.equals("firefox")) {
			System.out.println("Launching browser: "+browser);
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equals("chrome")) {
			System.out.println("Launching browser: "+browser);
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		setDriver(driver);
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		getDriver().get("http://demo.guru99.com/v4/");
	}
	
	public void quit() {
		getDriver().quit();
	}

}
