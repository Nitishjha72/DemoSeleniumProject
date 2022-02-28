package com.qa.sel.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.qa.sel.reports.ExtentManager;
import com.qa.sel.utilities.CommonUtilities;
import com.qa.sel.utilities.Constants;
import com.qa.sel.utilities.DriverManager;
import com.qa.sel.utilities.Log;
import com.qa.sel.utilities.WebEventListener;

public class TestBase {

	//public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	protected WebDriver driver;
	
    public TestBase() {
	    this.driver = DriverManager.getDriver();
	}
	
	@BeforeSuite
	public void loadConfig() {
		CommonUtilities.logConfig();
		try {
			fis = new FileInputStream(Constants.CONFIG_FILE_LOCATION);
			prop = new Properties();
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void initialization() {
		
		String browser = prop.getProperty("browser");
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",Constants.CHROME_DRIVER_PATH);
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<String, Object>();
	        // Set the notification setting it will override the default setting.
	        prefs.put("profile.default_content_setting_values.notifications", 2);
	        options.setExperimentalOption("prefs", prefs);
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			DriverManager.setWebDriver(new ChromeDriver(options));
		}
		else if(browser.equals("firefox")) {
			System.setProperty("webdriver.chrome.driver",Constants.FIREFOX_DRIVER_PATH);
			DriverManager.setWebDriver(new FirefoxDriver());
		}
		else {
			System.out.println("No driver selected");
		}
		e_driver = new EventFiringWebDriver(DriverManager.getDriver());
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		DriverManager.setWebDriver(e_driver);
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().deleteAllCookies();
		DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
		DriverManager.getDriver().get(prop.getProperty("url"));
	}
	
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() throws IOException
	{
		DriverManager.getDriver().quit();
		Log.info("Browser Terminated");
		Log.info("-----------------------------------------------");
	}

}
