package propertiesFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FetchDataFromPropertiesFile {

	public static void main(String[] args) throws IOException {
		
		//Step 1: Convert the physical file into Java readable Object
		FileInputStream fis = new FileInputStream("./src/test/resources/commonData.properties");
		
		//Step 2: Create an Object for Properties class
		Properties p = new Properties();
		
		//Step 3: Load all the keys to the project
		p.load(fis);
		
		//Step 4: Fetch the data from properties file
		String browser = p.getProperty("browser");
		System.out.println(browser);

	}

}
