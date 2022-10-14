package javascriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RefreshTheWebPageUsingJS {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Navigate to the application
		jse.executeScript("window.location=arguments[0];", "https://www.amazon.com/");
		
		Thread.sleep(3000);
		//Refresh the page
		jse.executeScript("history.go(0)");

	}

}
