package groupExecution;

import org.testng.annotations.Test;

import genericLibraries.BaseClass;

public class FirstTest extends BaseClass{
	
	@Test(groups = "Smoke Tests")
	public void firstTest() {
		System.out.println("First Test");
	}

}
