package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassForRetry {
	
	protected WebDriver driver;
	
	
	@BeforeClass
	public void launchBrowser() {
	
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			
			
	}

}
