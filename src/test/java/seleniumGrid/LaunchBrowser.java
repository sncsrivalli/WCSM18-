package seleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class LaunchBrowser {
	
	@Test
	public void gridPractice() throws MalformedURLException, InterruptedException {
		
		URL url = new URL("http://192.168.1.2:7777/wd/hub");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setPlatform(Platform.WINDOWS);
		cap.setBrowserName("chrome");
		
		WebDriver driver = new RemoteWebDriver(url,cap);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Thread.sleep(5000);
		driver.quit();
		
	}

}
