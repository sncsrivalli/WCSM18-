package crossBrowserExecution;

import org.testng.annotations.Test;

import genericLibraries.BaseClass1;

public class FirstTest extends BaseClass1{
	
	@Test
	public void firstTest() {
		System.out.println("In first test");
		driver.get("https://www.amazon.com/");
	}

}
