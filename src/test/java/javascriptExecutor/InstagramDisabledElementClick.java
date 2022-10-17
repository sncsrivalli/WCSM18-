package javascriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InstagramDisabledElementClick {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.instagram.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement userNameTextField = driver.findElement(By.name("username"));
		WebElement passwordTextField = driver.findElement(By.name("password"));
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		System.out.println("Before entering username and password");
		if(loginButton.isEnabled())
			System.out.println("Enabled");
		else
			System.out.println("Disabled");
		
		userNameTextField.sendKeys("9177432389");
		passwordTextField.sendKeys("shitoku@87");
		
		System.out.println("After entering username and password");
		if(loginButton.isEnabled())
			System.out.println("Enabled");
		else
			System.out.println("Disabled");
			
		jse.executeScript("arguments[0].click();", loginButton);
		

	}

}
