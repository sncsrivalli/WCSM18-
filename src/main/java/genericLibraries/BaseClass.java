package genericLibraries;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
	@BeforeSuite(alwaysRun = true)
	public void suiteSetup() {
		System.out.println("*****Before Suite********");
	}
	@BeforeTest(alwaysRun = true)
	public void testSetup() {
		System.out.println("*****Before Test********");
	}
	@BeforeClass(alwaysRun = true)
	public void classSetup() {
		System.out.println("*****Before Class********");
	}
	@BeforeMethod(alwaysRun = true)
	public void methodSetup() {
		System.out.println("*****Before Method********");
	}
	
	@AfterMethod(alwaysRun = true)
	public void methodTeardown() {
		System.out.println("*****After Method********");
	}
	@AfterClass(alwaysRun = true)
	public void classTeardown() {
		System.out.println("*****After Class********");
	}
	@AfterTest(alwaysRun = true)
	public void testTeardown() {
		System.out.println("*****After Test********");
	}
	@AfterSuite(alwaysRun = true)
	public void suiteTeardown() {
		System.out.println("*****After Suite********");
	}
	

}
