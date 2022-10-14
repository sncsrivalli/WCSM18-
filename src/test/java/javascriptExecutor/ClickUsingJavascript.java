package javascriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickUsingJavascript {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		
		WebElement laptopsTablets = driver.findElement(By.xpath("//img[@alt='Shop Laptops & Tablets']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		//Scroll till the element
		jse.executeScript("arguments[0].scrollIntoView(true);",laptopsTablets);
		
		//Click on the element
		jse.executeScript("arguments[0].click();", laptopsTablets);

	}

}
