package com.krn.actitime.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XLSXReaderUtil {
	
	public Row getRow(String fileName, String sheetName, int rowNum) {
		Row row = null;
		try {
			FileInputStream fis = new FileInputStream(fileName);
			Workbook workBook= WorkbookFactory.create(fis);
			Sheet sheet = workBook.getSheet(sheetName);
			row= sheet.getRow(rowNum);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}
	
	public int getRowCount(String fileName, String sheetName) {
		int rowCount=0;
		try {
			FileInputStream fis = new FileInputStream(fileName);
			Workbook workBook= WorkbookFactory.create(fis);
			Sheet sheet = workBook.getSheet(sheetName);
			rowCount = sheet.getLastRowNum();
						
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowCount;
	}
	
	public int getColumnCount(String fileName, String sheetName, int rowNum) {
		int columnCount=0;
		Row row = null;
		try {
			FileInputStream fis = new FileInputStream(fileName);
			Workbook workBook= WorkbookFactory.create(fis);
			Sheet sheet = workBook.getSheet(sheetName);
			row= sheet.getRow(rowNum);
			columnCount = row.getLastCellNum();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return columnCount;
	}
	
	public String getCellData(Row row, int colNum) {
		String cellData= null;
		Cell cell=  row.getCell(colNum);
		cellData = cell.getStringCellValue();
		return cellData;
	}
	
	public String getCellData(String fileName, String sheetName, int rowNum, int colNum ) {
		String cellData = null;
		Row row = getRow("..\\Data\\"+fileName+".xlsx", sheetName, rowNum);
		cellData= getCellData(row,colNum );
		return cellData;
	}
	
}
