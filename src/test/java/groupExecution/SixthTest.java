package groupExecution;

import org.testng.annotations.Test;

import genericLibraries.BaseClass;

public class SixthTest extends BaseClass{
	@Test(groups ={"Sanity Tests","Smoke Tests"})
	public void sixthTest() {
		System.out.println("Sixth Test");
	}

}
