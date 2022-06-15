package excelUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Excel {

	public FileInputStream fis;
	public FileOutputStream fos;
	public Workbook bk;
	public Sheet sheet;
	public Cell cell;
	public Row row;
	public String excelPath;
	public Map<String,Integer> columns = new HashMap<>();

	public void readExcel(String excelPath, String sheetName) throws Exception{
		File f = new File(excelPath);
		bk = WorkbookFactory.create(f);
		sheet=bk.getSheet(sheetName);
		this.excelPath=excelPath;

		int size = sheet.getLastRowNum()-sheet.getFirstRowNum();

		for(int i=0; i<=0; i++) {

			int size2 = sheet.getRow(i).getLastCellNum();

			for (int j=0; j<size2; j++) {

				cell=sheet.getRow(i).getCell(j);
				columns.put(cell.getStringCellValue(), cell.getColumnIndex());
			}


		}
		




	}

	public String getCellData(int rownum, int colnum) throws Exception{

		cell=sheet.getRow(rownum).getCell(colnum);
		String cellData = null;
		switch (cell.getCellType()) {
		case STRING:
			cellData = cell.getStringCellValue();
			break;
		case NUMERIC:
			if(DateUtil.isCellDateFormatted(cell)) {
				cellData = String.valueOf(cell.getDateCellValue());
			}
			else {
				cellData = String.valueOf((long)cell.getNumericCellValue());
			}
			break;
		case BOOLEAN:
			cellData = Boolean.toString(cell.getBooleanCellValue());
			break;
		case BLANK:
			cellData="";
			break;
		default:
			break;
		}


//		System.out.println(cellData);
		return cellData;
	}

	public String getCellData(String columnname) throws Exception{
		String dir = System.getProperty("user.dir");
		File f = new File(dir+"\\TestData\\testData.xlsx");
		bk = WorkbookFactory.create(f);
		sheet=bk.getSheet("Sheet1");
		for(int i=0; i<=0; i++) {

			int size2 = sheet.getRow(i).getLastCellNum();

			for (int j=0; j<size2; j++) {

				cell=sheet.getRow(i).getCell(j);
				columns.put(cell.getStringCellValue(), cell.getColumnIndex());
			}

		}
		return getCellData(1,columns.get(columnname));
	}



}
