package practice;

import java.awt.Robot;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//span[.='From']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("BOM");

		driver.findElement(By.xpath("//p[.='Mumbai, India']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("DED");
		driver.findElement(By.xpath("//p[.='Dehradun, India']")).click();
		//Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[.='Search']")).click();
		Thread.sleep(2000);
		driver.quit();
	}

}
