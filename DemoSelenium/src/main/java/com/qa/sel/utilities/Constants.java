package com.qa.sel.utilities;

public class Constants {

	//Different browser drivers path
	public static final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "/Drivers/chromedriver.exe";
	public static final String INTERNET_EXPLORER_DRIVER_PATH = System.getProperty("user.dir") + "/Drivers/IEDriverServer.exe";
	public static final String FIREFOX_DRIVER_PATH = System.getProperty("user.dir") + "/Drivers/geckodriver.exe";
	
	//Configuration file location
	public static final String CONFIG_FILE_LOCATION = System.getProperty("user.dir")+"/src/main/java/com/qa/sel/config/config.properties";
	
	//Timeouts
	public static final long PAGE_LOAD_TIMEOUT = 60;
	public static final long IMPLICIT_WAIT_TIMEOUT = 20;
	public static final long EXPLICIT_WAIT_TIMEOUT = 20;

	//Log4j configure file location
	public static final String LOG4J_CONFIG_LOCATION = System.getProperty("user.dir")+"/src/main/resources/log4j.properties";
	
	//Bank home page title
	public static final String LOGIN_PAGE_TITLE = "Guru99 Bank Home Page";
	
	public static final String CREATE_CUSTOMER_SHEET = "CreateCustomer";
	
}
