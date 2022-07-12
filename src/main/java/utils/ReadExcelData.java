package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static FileInputStream file;
	public static String[][] excelData;
	public ReadExcelData() {
//	public static void main(String[] args) {

		try {
			file = new FileInputStream(new File("./src/test/resources/TestData.xlsx"));
			Workbook workbook = new XSSFWorkbook(file);
			Sheet sheet = workbook.getSheetAt(0);

			// storing the data from excel file to Map
			int i = 0;
			int rowNum = sheet.getLastRowNum();
			int cellNum = sheet.getRow(0).getPhysicalNumberOfCells();
			excelData = new String[rowNum][cellNum];
			// Reading the data in
			for (Row row : sheet) {
				int j = 0;
				for (Cell cell : row) {
					switch (cell.getCellType()) {
					case STRING:
						excelData[i][j] = cell.getRichStringCellValue().getString();
						break;
					case NUMERIC:
						if (DateUtil.isCellDateFormatted(cell)) {
							excelData[i][j] = cell.getDateCellValue() + "";
						} else {
							excelData[i][j] = cell.getNumericCellValue() + "";
						}
						break;
					case BOOLEAN:
						excelData[i][j] = cell.getBooleanCellValue() + "";

						break;
					case FORMULA:
						excelData[i][j] = cell.getCellFormula() + "";
						break;

					default:
					}
					j++;
				}
				i++;
			}
//			for (int k = 0; k < rowNum; k++) {
//				for (int l = 0; l < cellNum; l++) {
//					System.out.print(excelData[k][l] + "\t");
//				}
//				System.out.println("\n");
//			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		// printing the data in tabular form
//		for(int num:data.keySet()){
//			List<String> temp = data.get(num);
//			int count = 0;
//			for (String st : temp) {
//				System.out.print(st + "\t");
//				count++;
//				if (count == temp.size()) {
//					System.out.println("");
//				}
//
//			}
//		}
	}

}
