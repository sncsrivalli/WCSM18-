package robotClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario1 {

	public static void main(String[] args) throws AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("(//span[contains(.,\"Don't Change\")])[2]")).click();
		WebElement deals = driver.findElement(By.xpath("//a[.=\"Today's Deals\"]"));
		Actions a = new Actions(driver);
		a.moveToElement(deals).perform();
		a.contextClick().perform();
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_RIGHT);
		r.keyPress(KeyEvent.VK_ENTER);
		
		r.keyRelease(KeyEvent.VK_RIGHT);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		//driver.quit();
		
	}

}
