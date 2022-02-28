package com.qa.sel.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLibrary {

	public static String path = System.getProperty("user.dir")+"/src/main/java/com/qa/sel/testData/HybridTestData.xlsx";

	public FileInputStream fis;
	public FileOutputStream foh;
	private XSSFWorkbook wb;
	private DataFormatter df;
		
	public ExcelLibrary() {
		try {
			fis = new FileInputStream(path);
			wb = new XSSFWorkbook(fis);
			df = new DataFormatter();
		} catch (IOException e) {
			Log.error("Excel sheet at given location not found: "+path);
		}
	}
	
	public ExcelLibrary(String path) {
		try {
			fis = new FileInputStream(path);
			wb = new XSSFWorkbook(fis);
			df = new DataFormatter();
		} catch (IOException e) {
			Log.error("Excel sheet at given location not found: "+path);
		}
	}
	
	public int getTotalRowCountPresentInSheet(String sheet) {
		int index = wb.getSheetIndex(sheet);
		if(index==-1) {
			return 0;
		}else {
			return wb.getSheet(sheet).getLastRowNum()+1;
		}
	}
	
	
	public int getTotalColumnCount(String sheet) {
		int index = wb.getSheetIndex(sheet);
		if (index==-1) {
			return 0;
		}else {
			return wb.getSheetAt(index).getRow(0).getLastCellNum();
		}
	}
	
	public String getCellData(String sheet, int rowIndex, int colIndex ) {
		
		int index = wb.getSheetIndex(sheet);
		
		if (rowIndex<0 || colIndex<0 || index==-1) {
			return "";
		}
		
		df = new DataFormatter();
		return df.formatCellValue(wb.getSheetAt(index).getRow(rowIndex).getCell(colIndex));
		
	}	
	
}
