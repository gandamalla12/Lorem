package com.LoremCRM.genericLib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	public String readPropData(String propPath,String key) throws Throwable {
		FileInputStream fis=new FileInputStream(propPath);
		Properties prop=new Properties();
		prop.load(fis);
		String propValue = prop.getProperty(key, "Incorrect key");
		return propValue;
	}
	
	public String readDataFromExcel(String excelPath,String sheet,int row,int cell) throws Throwable {
		FileInputStream fis=new FileInputStream(excelPath);
		Workbook wb=WorkbookFactory.create(fis);
		String excelValue=wb.getSheet(sheet).getRow(row).getCell(cell).toString();
		return excelValue;
	}
	
	public int getRowCount(String excelPath,String sheet) throws Throwable{
		FileInputStream fis=new FileInputStream(excelPath);
		Workbook wb=WorkbookFactory.create(fis);
		int rc=wb.getSheet(sheet).getLastRowNum();
		System.out.println(rc);
		return rc;
	}
	
	public void writeDataIntoExcel(String excelPath,String sheet,int row,int cell,String data) throws Throwable{
		FileInputStream fis=new FileInputStream(excelPath);
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheet).getRow(row).createCell(cell).setCellValue(data);	
		FileOutputStream fos =new FileOutputStream(excelPath);
		wb.write(fos);
	}
}