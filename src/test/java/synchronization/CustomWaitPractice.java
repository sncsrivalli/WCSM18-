package synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomWaitPractice {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		
		System.out.println(driver.getTitle());
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("phone");
		int count = 0;
		//Custom Wait
		while(count<20) {
			try {
				driver.findElement(By.id("nav-search-submit-button")).click();
				break;
			}
			catch(Exception e) {
				System.out.println("Element not found");
			}
		}
		driver.quit();

	}

}
