package javascriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InstagramDisabledElementClick {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.instagram.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement userNameTextField = driver.findElement(By.name("username"));
		userNameTextField.clear();
		WebElement passwordTextField = driver.findElement(By.name("password"));
		passwordTextField.clear();
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value=arguments[1];", userNameTextField,"9177432389");
		jse.executeScript("arguments[0].value=arguments[1];", passwordTextField,"135689");
		
		if(loginButton.isEnabled())
			System.out.println("Enabled");
		else
			System.out.println("Disabled");
			
		jse.executeScript("arguments[0].click();", loginButton);
		

	}

}
