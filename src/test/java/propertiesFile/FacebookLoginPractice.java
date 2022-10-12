package propertiesFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookLoginPractice {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/commonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String browser = p.getProperty("browser1");
//		switch(browser) {
//		case "chrome": WebDriver driver = new ChromeDriver(); break;
//		case "firefox" : WebDriver driver1 = new FirefoxDriver();break;
//		}
		String url = p.getProperty("url3");
		String user1 = p.getProperty("user1");
		String pwd1 = p.getProperty("pwd1");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		String actualTitle = driver.getTitle();
		String expectedTitle = "log in";
		if(actualTitle.contains(expectedTitle))
			System.out.println("Pass : Login page displayed");
		else
			System.out.println("Fail : Login page is not displayed");
		driver.findElement(By.id("email")).sendKeys(user1);
		driver.findElement(By.id("pass")).sendKeys(pwd1);
		driver.findElement(By.name("login")).submit();
		
//		Thread.sleep(2000);
//		p.put("user2", "manager");
//		p.put("pwd2", "123456");
//		FileOutputStream fos = new FileOutputStream("./src/test/resources/commonData.properties");
//		p.store(fos, "2 values updated");
//		
//		String user2 = p.getProperty("user2");
//		String pwd2 = p.getProperty("pwd2");
//		Thread.sleep(2000);
//		driver.findElement(By.id("email")).sendKeys(user2);
//		driver.findElement(By.id("pass")).sendKeys(pwd2);
//		driver.findElement(By.name("login")).submit();
		
		driver.quit();
		
	}

}
