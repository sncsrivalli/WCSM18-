package crossBrowserExecution;

import org.testng.annotations.Test;

import genericLibraries.BaseClass1;

public class SecondTest extends BaseClass1 {
	@Test
	public void secondTest() {
		System.out.println("In Second test");
		driver.get("https://www.facebook.com/");
	}

}
