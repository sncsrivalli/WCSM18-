package excelFile;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Step 1:Convert physical file into java readable object
		FileInputStream fis = new FileInputStream("./src/test/resources/Testdata.xlsx");
		
		//Step 2: Open excel workbook
		Workbook wb = WorkbookFactory.create(fis);
		
//		//Step 3: Get control over the sheet
//		Sheet sheet = wb.getSheet("Sheet1");
//		
//		//Step 4: Get control over the row
//		Row row = sheet.getRow(2);
//		
//		//Step 5: Get control over the cell
//		Cell cell1 = row.getCell(0);
//		Cell cell2 = row.getCell(1);
//		
//		//Step 6: Fetch the data from the cell
//		String un = cell1.getStringCellValue();
//		double pwd = cell2.getNumericCellValue();
		
		String un = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		System.out.println(un);
		//System.out.println(pwd);
		
		//Step 7: close workbook
		wb.close();

	}

}
