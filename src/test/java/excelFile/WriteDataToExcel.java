package excelFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		
		//Creates new row by deleting older data in row
		Row row = sheet.createRow(4);
		
		//Creates new cell by deleting older data in cell
		Cell cell1 = row.createCell(0);
		Cell cell2 = row.createCell(1);
		
		//Sets the value in to the cell
		cell1.setCellValue("Himadri");
		cell2.setCellValue("656876988");
		
		//To save the data entered into Excel
		FileOutputStream fos = new FileOutputStream("./src/test/resources/Testdata.xlsx");
		wb.write(fos);
		
		wb.close();
	}

}
