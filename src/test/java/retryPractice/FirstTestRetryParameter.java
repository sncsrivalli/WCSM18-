package retryPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries.BaseClassForRetry;

public class FirstTestRetryParameter extends BaseClassForRetry{
	
	@Test(retryAnalyzer = genericLibraries.RetryAnalyzerImplementation.class)
	public void firstTest() {
		
		System.out.println("In first test");
		driver.get("https://www.amazon.com/");
		Assert.fail();
	}


}
