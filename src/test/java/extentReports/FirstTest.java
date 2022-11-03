package extentReports;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries.BaseClassForRetry;

public class FirstTest extends BaseClassForRetry {
	
	@Test
	public void firstTest() {
		
		System.out.println("In first test");
		driver.get("https://www.amazon.com/");
		driver.quit();
		Assert.fail();
	}


}
