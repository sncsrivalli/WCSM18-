package groupExecution;

import org.testng.annotations.Test;

import genericLibraries.BaseClass;

public class FifthTest extends BaseClass{
	
	@Test(groups ={"Sanity Tests","Smoke Tests"})
	public void fifthTest() {
		System.out.println("Fifth Test");
	}


}
