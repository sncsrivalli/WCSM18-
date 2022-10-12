package excelFile;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchMultipleDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Convert physical file to java readable object
		FileInputStream fis = new FileInputStream("./src/test/resources/Testdata.xlsx");
		
		//Open workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Get control over sheet
		Sheet sheet = wb.getSheet("Sheet1");
		
		//Used to fetch exact values present in the cell
		DataFormatter df = new DataFormatter();
		
		//DataType[][] var = new Datatype[size][size];//To store excel data
		String[][] arr = new String[sheet.getLastRowNum()+1][sheet.getRow(3).getLastCellNum()+1];
		
		//for loop to store data into 2D Array//getLastRowNum()--> returns last row index
		for(int i=0; i<=sheet.getLastRowNum();i++) {
			//getLastCellNum()--> returns last cell index
			for(int j=0; j<=sheet.getRow(i).getLastCellNum();j++) {
				arr[i][j]= df.formatCellValue(sheet.getRow(i).getCell(j));//0,1
			}
		}
		
		//Print the stored values in console
		for(int i=0; i<=sheet.getLastRowNum();i++) {
			for(int j=0; j<=sheet.getRow(i).getLastCellNum();j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
		
		//Close the workbook
		wb.close();
	}

}
