package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethodsPractice {
	

	@Test(invocationCount = 2)
	public void demo1() {

		System.out.println("demo1");
	}

	@Test(invocationCount = 4, enabled = false)
	public void demo2() {

		System.out.println("demo2");
	}

	@Test(priority = -1, invocationCount = 3)
	public void demo3() {

		System.out.println("demo3");
		Assert.fail();
	}

	@Test(dependsOnMethods = {"demo3", "demo1"})
	public void demo4() {

		System.out.println("demo4");
	}

}
