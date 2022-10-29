package groupExecution;

import org.testng.annotations.Test;

import genericLibraries.BaseClass;

public class FourthTest extends BaseClass{
	
	@Test(groups ="Sanity Tests")
	public void fourthTest() {
		System.out.println("Fourth Test");
	}


}
