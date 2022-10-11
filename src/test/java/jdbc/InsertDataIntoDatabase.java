package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertDataIntoDatabase {

	public static void main(String[] args) throws SQLException {
		
		//Step 1: Create an object for Driver
		Driver dbDriver = new Driver();
		
		//Step 2: Register dbDriver to JDBC
		DriverManager.registerDriver(dbDriver);
		
		
		//Step 3: Establish JDBC connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advsel","root","root");

		//Step 4: Create Statement
		Statement statement = connection.createStatement();
		
		//Step 5: Execute Query
		int result = statement.executeUpdate("insert into wcsm18(EmpId,EmpName,Address) values(1006, 'Fgh', 'Goa');");
		System.out.println("Rows effected: "+result);
		
		//Step 6: Close database connection
		connection.close();
	}

}
