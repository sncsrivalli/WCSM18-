package javascriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDisabledElementUsingJS {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Navigate to the application
		driver.get("file:///C:/Users/sncsr/OneDrive/Desktop/disabledPractice.html");
		Thread.sleep(2000);
		
		//In Notepad : <input id="abc" type="text" disabled>
		//save it as .html file
		//To find Element Using Javascript
		jse.executeScript("document.getElementById('abc').value='ADMIN';");
		
		//To clear the text field
		jse.executeScript("document.getElementById('abc').value='';");
		
	}

}
