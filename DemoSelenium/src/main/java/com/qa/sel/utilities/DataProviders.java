package com.qa.sel.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

	ExcelLibrary exl = new ExcelLibrary();
	
	
	@DataProvider(name="credentials")
	public Object[][] getCredentials() {
		
		int rowCount = exl.getTotalRowCountPresentInSheet("Credentials");
		int colCount = exl.getTotalColumnCount("Credentials");
		Log.info("Total rows including header in Credentials sheet: "+rowCount);
		Log.info("Total columns in Credentails sheet: "+colCount);
		Object[][] data = new Object[rowCount-1][colCount];
		for (int i=1; i<rowCount; i++) {
			for(int j=0; j<colCount; j++) {
				data[i-1][j]=exl.getCellData("Credentials", i, j);
			}
		}
		return data;
	}
	
	
	@DataProvider(name="addCustomer")
	public Object[][] getNewCustomerDetails(){
		
		int rowCount = exl.getTotalRowCountPresentInSheet("CreateCustomer");
		int colCount = exl.getTotalColumnCount("CreateCustomer");
		Log.info("Total rows including header in CreateCustomer sheet: "+rowCount);
		Log.info("Total columns in CreateCustomer sheet: "+colCount);
		Object[][] data = new Object[rowCount-1][colCount];
		for (int i=1; i<rowCount; i++) {
			for(int j=0; j<colCount; j++) {
				data[i-1][j]=exl.getCellData("CreateCustomer", i, j);
			}
		}
		return data;
		//return new Object[][] {{"Nitish", "Nitish", "Nitish", "Nitish", "Nitish", "Nitish", "Nitish", "Nitish", "Nitish"}};
		
	}
	
	@DataProvider(name="editCustomerDetails")
	public Object[][] getEditCustomerDetails(){
		
		int rowCount = exl.getTotalRowCountPresentInSheet("EditCustomer");
		int colCount = exl.getTotalColumnCount("EditCustomer");
		Log.info("Total rows including header in EditCustomer sheet: "+rowCount);
		Log.info("Total columns in EditCustomer sheet: "+colCount);
		Object[][] data = new Object[rowCount-1][colCount];
		for (int i=1; i<rowCount; i++) {
			for(int j=0; j<colCount; j++) {
				data[i-1][j]=exl.getCellData("EditCustomer", i, j);
			}
		}
		return data;
	}
	
	
	
}
