package com.qa.sel.reports;

import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.qa.sel.utilities.CommonUtilities;
import com.qa.sel.utilities.DriverManager;

public class ExtentListener implements ITestListener{

	static String fileName = "Automation_Test_Report"+CommonUtilities.getSystemCurrentDateTime()+".html";
	private static ExtentReports extent = ExtentManager.createInstance(System.getProperty("user.dir")+"/ExtentReport/"+fileName);
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		ExtentTest test = extent.createTest(result.getTestClass().getName()+"     @TestCase : "+result.getMethod().getMethodName());
        testReport.set(test);
	}
	
	public void onTestSuccess(ITestResult result) {
		
		CommonUtilities.getScreenshot(DriverManager.getDriver());
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"TEST CASE:- "+ methodName.toUpperCase()+ " PASSED"+"</b>";		
		testReport.get().pass(MarkupHelper.createLabel(logText, ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestResult result) {
	    	
	    String imgPath = CommonUtilities.getFailedScreenshot(DriverManager.getDriver());
	    String excepionMessage=Arrays.toString(result.getThrowable().getStackTrace());
	    String failureLogg="<b>"+"TEST CASE:- "+ result.getMethod().getMethodName().toUpperCase()+ " FAILED"+"</b>";
	    testReport.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured: Click to see"
				+ "</font>" + "</b >" + "</summary>" +excepionMessage.replaceAll(",", "<br>")+"</details>"+" \n");
		testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>", 
				MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
		testReport.get().log(Status.FAIL, MarkupHelper.createLabel(failureLogg, ExtentColor.RED));
	}
	
	public void onTestSkipped(ITestResult result) {
		
		CommonUtilities.getScreenshot(DriverManager.getDriver());
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"Test Case:- "+ methodName+ " Skipped"+"</b>";		
		testReport.get().skip(MarkupHelper.createLabel(logText, ExtentColor.YELLOW));
	}
	
	public void onFinish(ITestContext context) {
		if (extent != null) {

			extent.flush();
		}
	}

}
