package crossBrowserExecution;

import org.testng.annotations.Test;

import genericLibraries.BaseClassForCrossBrowserExecution;

public class FirstTest extends BaseClassForCrossBrowserExecution{
	
	@Test
	public void firstTest() {
		System.out.println("In first test");
		driver.get("https://www.amazon.com/");
	}

}
