package com.mystore.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider 
{
	XSSFWorkbook wb;

	public ExcelDataProvider()
	{
		File src = new File("./TestData/LoginDetails.xlsx");
			FileInputStream fis;
			try 
			{
				fis = new FileInputStream(src);
				wb = new XSSFWorkbook(fis);
			} 
			catch (Exception e) 
			{
				System.out.println("Unable to read file"+e.getMessage());
			}
	}
	
	public String getStringdata(int SheetIndex, int row, int column)
	{
		
		return wb.getSheetAt(SheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	public String getStringdata(String SheetName, int row, int column)
	{
		
		return wb.getSheet(SheetName).getRow(row).getCell(column).getStringCellValue();
	}
	
	public double getNumericData(String SheetName, int row, int column)
	{
		return wb.getSheet(SheetName).getRow(row).getCell(column).getNumericCellValue();
	}
	
} 
