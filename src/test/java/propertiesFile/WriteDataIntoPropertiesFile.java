package propertiesFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteDataIntoPropertiesFile {

	public static void main(String[] args) throws IOException {
		
		//Step 1: Convert the physical file into Java readable Object
		FileInputStream fis = new FileInputStream("./src/test/resources/commonData.properties");
		
		//Step 2: Create an Object for Properties class
		Properties p = new Properties();
		
		//Step 3: Load all the keys to the project
		p.load(fis);
		
		//To write data into properties file
		p.put("url2", "https://www.google.com/");
		
		//Save the data in properties file
		FileOutputStream fos = new FileOutputStream("./src/test/resources/commonData.properties");
		p.store(fos, "Properties File updated successfully");
	
	}

}
	