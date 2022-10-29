package groupExecution;

import org.testng.annotations.Test;

import genericLibraries.BaseClass;

public class SecondTest extends BaseClass{
	@Test(groups = "Smoke Tests")
	public void secondTest() {
		System.out.println("Second Test");
	}

}
