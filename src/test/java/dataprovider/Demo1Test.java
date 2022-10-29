package dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Demo1Test {
	
	@Test(dataProvider = "dataForbookTicketTest")
	public void bookTicketTest(String source , String destination) {
		
		System.out.println("Book Ticket From : "+ source +" To : "+ destination);
	}
	
	@DataProvider
	public Object[][] dataForbookTicketTest(){
		Object[][] obj = new Object[5][2];
		
		obj[0][0] = "Bangalore";
		obj[0][1] = "Hyderabad";
		
		obj[1][0] = "Mysore";
		obj[1][1] = "Bangalore";
		
		obj[2][0] = "Bangalore";
		obj[2][1] = "Kerala";
		
		obj[3][0] = "Bangalore";
		obj[3][1] = "Mumbai";
		
		obj[4][0] = "Bangalore";
		obj[4][1] = "Kolkata";
		
		return obj;
	}
}
