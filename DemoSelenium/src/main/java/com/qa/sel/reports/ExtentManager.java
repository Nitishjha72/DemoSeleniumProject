package com.qa.sel.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.sel.base.TestBase;

public class ExtentManager extends TestBase{

	private static ExtentReports extent;
	
    public static ExtentReports createInstance(String fileName) {
    	ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Automation Framework Report By Nitish");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Automation Framework Report By Nitish");
        
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    	extent.setSystemInfo("HostName", "SIT Test Environment");
		extent.setSystemInfo("Project", "Hybrid Selenium Project by Nitish");
		extent.setSystemInfo("Test Manager", "Nitish");
		extent.setSystemInfo("OS", "Win10");
		return extent;
    }
	

}
