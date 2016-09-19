package com.journaldev.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {

	private Connection connection;
	
	public DBConnectionManager(String dbURL) throws ClassNotFoundException, SQLException{
		Class.forName("org.sqlite.JDBC");
		this.connection = DriverManager.getConnection(dbURL);
		System.out.println(this.connection);
	}
	
	public Connection getConnection(){
		return this.connection;
	}
}