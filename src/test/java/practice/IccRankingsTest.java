package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IccRankingsTest {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Click on Full Rankings
		driver.findElement(By.xpath("//a[@href='https://www.icc-cricket.com/rankings/mens/player-rankings/t20i/batting']")).click();
		
		//List of contents in table
		List<WebElement> countries = driver.findElements(By.xpath("//table/tbody/tr"));
		
		//Traverse through the contents of the table using loop
		for(int i=2;i<=countries.size();i++) {
			
			//To get the country name of each row using dynamic xpath
			String countryName= driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]/span[@class='table-body__logo-text']")).getText();
			
			//condition to check if the country name is IND
			if(countryName.equals("IND")) {
				//Fetch player name and store it in a variable
				String player = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]/a")).getText();
				//Fetch player's ratings and store it a variable
				String ratings = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText();
				//Printing the nationality, name and ratings of the player
				System.out.println(countryName + " "+player +" "+ratings);
			}
		}
		driver.quit();
	}

}
