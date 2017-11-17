/**
 * @class_Description: This class is used to handle the Testdata from ExcelSheet
 * @created_on: 11/11/2017
 * @lastEdited_on: 11/16/2017
 * @lastEdited_by: Jemson
 */
package com.thefloow.seleniumappium.excelutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.thefloow.seleniumappium.constant.Constant;


/**
 * @author Jemson
 *
 */
public class Excelutility {	

	private static File file = null;
	private static FileInputStream inputStream = null;
	public static Workbook workbook =null;
	
	public static CellStyle style = null;
	public static Font font = null;
	private static Sheet sheet = null;
	private static Row row = null;
	private static Cell cell =null;
	
	private static int totalRows=0;
	private static int totalCols=0;
	private static String datafilePath =Constant.datafilePath;
	//To open the input stream to fetch the data from excel
		public static void openStream() throws IOException{
			file =    new File(datafilePath);
		    inputStream = new FileInputStream(file);     
		    String fileExtensionName = datafilePath.substring(datafilePath.indexOf("."));
		    
		     if(fileExtensionName.equals(".xlsx")){
		    	 workbook = new XSSFWorkbook(inputStream);
		    }
		     else if(fileExtensionName.equals(".xls")){
		         workbook = new HSSFWorkbook(inputStream);
		    }  
		}
	//To close the input stream after fetched data
		public static void closeStream() throws IOException{
			inputStream.close();
		}
	//To read the data from the concerned cell
		public static String readExcel(String sheetName,String tcID,String header) throws Exception{
		Object result = null;
		try
		{
			sheet = workbook.getSheet(sheetName);
		   	totalRows=sheet.getLastRowNum();
			row=sheet.getRow(0);
			totalCols=row.getLastCellNum();
			
			for(int k=1;k<=totalRows;k++){
				String testCaseID=sheet.getRow(k).getCell(0).getStringCellValue();
											
				if(testCaseID.equalsIgnoreCase(tcID)){
					for(int l=1;l<totalCols;l++){
						
						String testData_FieldName=sheet.getRow(0).getCell(l).getStringCellValue();
																		
						if(testData_FieldName.equalsIgnoreCase(header)){
							cell = sheet.getRow(k).getCell(l);
							if(cell!=null){
						    	switch (cell.getCellType()) {
								case Cell.CELL_TYPE_NUMERIC:// numeric value in excel
									if(DateUtil.isCellDateFormatted(cell)){
										Date myDate = cell.getDateCellValue();
										SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
								        result = formatter.format(myDate);
									}
									else{
										result = new BigDecimal(cell.getNumericCellValue()).toPlainString();
									}
									break;
									
								case Cell.CELL_TYPE_STRING: // string value in excel
									result = cell.getStringCellValue();
									break;
									
								case Cell.CELL_TYPE_BOOLEAN: // boolean value in excel
									result = cell.getBooleanCellValue();
									break;
									
								case Cell.CELL_TYPE_BLANK: // blank value in excel
									result = cell.getStringCellValue();
									break;
								
								case Cell.CELL_TYPE_ERROR: // Error value in excel
									result = cell.getErrorCellValue()+"";
									break;
						    	}
					    	}
						}
					}
					k=totalRows+1;
				}
			}
		}
		catch (Exception ex){
			throw ex;
			}
		return result.toString();	
	}

}
