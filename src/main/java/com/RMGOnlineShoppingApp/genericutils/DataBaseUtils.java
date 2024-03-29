package com.RMGOnlineShoppingApp.genericutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtils {

	Connection con;

	/**
	 * This method is used to connect to DataBase
	 * 
	 * @throws SQLException
	 */

	public void connectToDataBase() throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IpathConstants.DataBaseURL, IpathConstants.Username, IpathConstants.Password);
	}
	
	/*
	 *  Create a statement and 
	 *  execute a query
	 */

	public void executeAndGetData(String Query, int colIndex, String expData) throws SQLException 
	{
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery(Query);

		boolean flag = false;

		while (result.next()) {
			String actualData = result.getString(colIndex);
			if (actualData.equalsIgnoreCase(expData)) {
				flag = true;
				break;
			}
			if (flag = true) {
				System.out.println("-----Data is Present----");
			} else {
				System.out.println("-----Data is Not Present----");
			}
		}
	}
	
	/*
	 * Closing Database connection
	 */
	
	public void disconnectDataBase() throws SQLException
	{
		con.close();
	}
}
