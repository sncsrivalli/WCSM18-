package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassForRetry {
	
	protected WebDriver driver;
	public static WebDriver sdriver;
	public static JavaUtility sjavaUtility;
	protected JavaUtility javaUtility;
	protected WebDriverUtility webdriver;
	
	@BeforeClass
	public void launchBrowser() {
			
			javaUtility = new JavaUtility();
			webdriver = new WebDriverUtility();
			
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			
			sjavaUtility = javaUtility;
			sdriver = driver;
			
			
	}

}
