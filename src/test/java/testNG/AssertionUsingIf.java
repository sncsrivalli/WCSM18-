package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionUsingIf {
	
	@Test
	public void demo() {
//		String s1= "hi";
//		String s2 = "hello";
//		
//		SoftAssert s = new SoftAssert();
//		s.assertEquals(s1, s2);
	//	Assert.assertEquals(s1, s2);
//		if(s1.equals(s2))
		//System.out.println("Test Pass");
//		else
		//	System.out.println("Test Fail");
		
		//s.assertAll();
		
		Assert.assertTrue(1==1 || 2==3 || 0==0);
		
	}

}
