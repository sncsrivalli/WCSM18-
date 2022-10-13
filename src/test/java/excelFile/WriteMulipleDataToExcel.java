package excelFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This program is to fetch the Mobile Prices from Flipkart and write the complete list to Excel
 * @author sncsr
 *
 */
public class WriteMulipleDataToExcel {

	public static void main(String[] args) throws IOException {
		//Launch Chrome browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//Maximize the browser
		driver.manage().window().maximize();
		
		//Navigate to application
		driver.get("https://www.flipkart.com");
		
		//Implicit Wait statement
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//Close login window
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		
		//Type 'phone' in search text field and Click on search button
		driver.findElement(By.name("q")).sendKeys("phone");
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).submit();

		//Fetch the list of Mobile names and Mobile prices
		List<WebElement> mobileNames = driver.findElements(By.xpath(
				"//div[@class='_1YokD2 _3Mn1Gg']/div[@class='_1AtVbE col-12-12']/following::div[@class='col col-7-12']/div[1]"));
		List<WebElement> mobilePrices = driver.findElements(By.xpath(
				"//div[@class='_1YokD2 _3Mn1Gg']/div[@class='_1AtVbE col-12-12']/following::div[@class='col col-5-12 nlI3QM']/div[1]/div[1]/div[1]"));
		
		//Declared Workbook reference as null since it can be used inside try and finally
		Workbook wb = null;
		
		//Using try and finally since closing Workbook is mandatory action once its usage is done
		try {
			
			//Convert physical excel file to java readable object
			FileInputStream fis = new FileInputStream("./src/test/resources/Testdata.xlsx");
			
			//Open Workbook
			wb = WorkbookFactory.create(fis);
			
			//Get Control Over MobilePrices Sheet
			Sheet sheet = wb.getSheet("MobilesPrices");
			
			//Fetching each mobile name and price and setting the values in excel in iterative manner 
			for (int i = 0; i < mobileNames.size(); i++) {
				String name = mobileNames.get(i).getText();
				String price = mobilePrices.get(i).getText();
				System.out.println(name + "\t" + price);
				sheet.createRow(i).createCell(0).setCellValue(name);
				sheet.getRow(i).createCell(1).setCellValue(price);
			}
			
			//Saving the data entered into excel sheet
			FileOutputStream fos = new FileOutputStream("./src/test/resources/Testdata.xlsx");
			wb.write(fos);
		} finally {
			//Closing the browser and excel workbook
			driver.quit();
			wb.close();
		}
	}
}