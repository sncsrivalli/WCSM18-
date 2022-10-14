package javascriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PassDataUsingJavascript {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement searchTextField = driver.findElement(By.id("twotabsearchtextbox"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		//Pass data to the element
		jse.executeScript("arguments[0].value=arguments[1];", searchTextField,"phone");
		
	}

}
