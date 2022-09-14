package com.evolvus.jdbcHelloWorld;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		// create connection using jdbc url userName password

		String JDBC_H2_URL = "jdbc:h2:mem:evolvus";

		String userName = "sa";

		String password = "xya@123";

		try {

			// step 1 create connection object
			Connection connectionIbj = DriverManager.getConnection(JDBC_H2_URL, userName, password);

			
			//JdbcTemplate jdbcTemplate=new JdbcTemplate(connectionIb);
			// prepare the statement

			String createSql = "CREATE TABLE  student(stname varchar(100),strollnum varchar(200))";

			Statement statement = connectionIbj.createStatement();

			// running t he statemente
			boolean isCreated = statement.execute(createSql);

			System.out.println("the tabke status is " + isCreated);

			String insertSql = "INSERT INTO student(stname,strollnum) values('devendra','4gk10ec');";

			boolean isInserted = statement.execute(insertSql);

			System.out.println("the inserted records " + isInserted);

			String seleSql = "SELECT *  FROM student WHERE stname='devendra';";

			ResultSet resultSet = statement.executeQuery(seleSql);

			while (resultSet.next()) {
				System.out.println(" the rollNumber:::" + resultSet.getString("strollnum"));

			}

			String updatedroole = "xyz123333";
			String updateSql = "UPDATE student SET strollnum='" + updatedroole + "';";

			int resultes = statement.executeUpdate(updateSql);

			System.out.println(" the updated recors " + resultes);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
