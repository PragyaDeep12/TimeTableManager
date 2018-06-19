package com.pragya.timetable.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	public static final String MySQLDRIVER_CLASS = "com.mysql.jdbc.Driver"; 
    public static final String MySQLURL = "jdbc:mysql://localhost/jee";
    public static final String MySQLUSER = "root";
    public static final String MySQLPASSWORD = "12345";
    public static Connection connect(){
    	Connection con= null;
    	try {
			Class.forName(MySQLDRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    			
    	try {
			con=DriverManager.getConnection(MySQLURL,MySQLUSER,MySQLPASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    			return con;
    }
    public static void closeConnection(Connection con)
    {
    	try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
