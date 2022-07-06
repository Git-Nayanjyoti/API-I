package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
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
	FileInputStream file;
	Workbook workbook;
	Sheet sheet = workbook.getSheetAt(0);

	public ReadExcelData() throws Exception {
		file = new FileInputStream(new File("./src/test/resources/Book2.xlsx"));
		workbook  = new XSSFWorkbook(file);
		// storing the data from excel file to Map
		Map<Integer, List<String>> data = new HashMap<Integer, List<String>>();
		int i = 0;

		// Reading the data in
		for(Row row:sheet){
			data.put(i, new ArrayList<String>());
			for (Cell cell : row) {
				switch (cell.getCellType()) {
				case STRING:
					data.get(i).add(cell.getRichStringCellValue().getString());
					break;
				case NUMERIC:
					if (DateUtil.isCellDateFormatted(cell)) {
						data.get(i).add(cell.getDateCellValue() + "");
					} else {
						data.get(i).add(cell.getNumericCellValue() + "");
					}
					break;
				case BOOLEAN:
					data.get(i).add(cell.getBooleanCellValue() + "");

					break;
				case FORMULA:
					data.get(i).add(cell.getCellFormula() + "");
					break;
				default:
					data.get(i).add(" ");
				}
			}
			i++;
		}

		// printing the data in tabular form
		for(int num:data.keySet()){
			List<String> temp = data.get(num);
			int count = 0;
			for (String st : temp) {
				System.out.print(st + "\t");
				count++;
				if (count == temp.size()) {
					System.out.println("");
				}

			}
		}
	}


}
