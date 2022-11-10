package crossBrowserExecution;

import org.testng.annotations.Test;

import genericLibraries.BaseClassForCrossBrowserExecution;

public class SecondTest extends BaseClassForCrossBrowserExecution {
	@Test
	public void secondTest() {
		System.out.println("In Second test");
		driver.get("https://www.facebook.com/");
	}
//Second Test done
	
}
