package com.qa.sel.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CommonUtilities{

	public static void logConfig() {
		SimpleDateFormat sf = new SimpleDateFormat("_ddMMyyyy_HHmmss");
		String date = sf.format(new Date());
		System.setProperty("current_date", date);
		PropertyConfigurator.configure(Constants.LOG4J_CONFIG_LOCATION);
	}
	
	public static String getSystemCurrentDateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("_ddMMyyyy_HHmmss");
		return sdf.format(new Date());
	}

	public static String getFailedScreenshot(WebDriver driver) {
		String destPath = "";
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			destPath = System.getProperty("user.dir")+"/Screenshots/FailedScreenshots/Screenshot"+getSystemCurrentDateTime()+".png";
			File dest = new File(destPath);
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			Log.error("Error occurred while taking failed screenshot");
			Log.error(e.toString());
		}
		return destPath;		
	}
	
	public static void getScreenshot(WebDriver driver) {
		try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"/Screenshots/OtherScreenshots/Screenshot"+getSystemCurrentDateTime()+".png"));
		} catch (IOException e) {
			Log.error("Error occurred while taking screenshot");
			Log.error(e.toString());
		}
	}
	
}
