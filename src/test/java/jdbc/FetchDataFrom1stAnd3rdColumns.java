package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchDataFrom1stAnd3rdColumns {

	public static void main(String[] args) throws SQLException {
		// Step 1 : Create an object for db driver
		Driver dbDriver = new Driver();

		// Step 2: Register this dbDriver to JDBC
		DriverManager.registerDriver(dbDriver);

		// Step 3: Establish the JDBC connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advsel", "root", "root");

		// Step 4: Create the Statement
		Statement statement = connection.createStatement();

		// Step 5: Execute the Query
		ResultSet result = statement.executeQuery(" select * from wcsm18;");

		// Step 6: Fetch the data
		while (result.next()) {
			//Fetching the data using column numbers
			System.out.println(result.getInt(1) + "\t" + result.getString(3));
		}

		// Step 7: Close database connection
		connection.close();

	}

}
