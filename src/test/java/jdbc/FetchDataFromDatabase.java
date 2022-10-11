package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchDataFromDatabase {

	public static void main(String[] args) throws SQLException {
		
		// Step 1 : Create an object for db driver
		Driver dbDriver = new Driver();
		
		//Import Driver from com.mysql.cj.jdbc only
		// new Driver(); -> throws sql exception
		
		//Step 2: Register this dbDriver to JDBC
		DriverManager.registerDriver(dbDriver);
		
		
		//Step 3: Establish the JDBC connection
		//Import Connection, Statement and ResultSet from java.sql package only
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advsel","root","root");

		//Step 4: Create the Statement
		Statement statement = connection.createStatement();
		
		//Step 5: Execute the Query
		ResultSet result = statement.executeQuery(" select * from wcsm18;");
		
		//Step 6: Fetch the data
		while(result.next()) {
			System.out.println(result.getInt("EmpId")+"\t"+result.getString("EmpName")+"\t"+result.getString("Address"));
		}
	
		//Step 7: Close database connection
		connection.close();
	}

}
