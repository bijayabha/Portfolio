package main.java;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		connection();

	}
	
	public static Connection connection()
	{
		System.out.println("here");
	    Connection con=null;
	    try
	    {
	        Properties prop=new Properties();
	        FileInputStream in = new FileInputStream("src/main/resources/app.properties"); 
	        prop.load(in);
	        in.close();

	        String drivers = prop.getProperty("jdbc.driverClassName");
	        String connectionURL = prop.getProperty("jdbc.url");
	        String username = prop.getProperty("jdbc.username");
	        String password = prop.getProperty("jdbc.password");

	        Class.forName(drivers);
	        con=DriverManager.getConnection(connectionURL,username,password);

	            System.out.println("Connection Successful");
	            return con;     
	    }
	    catch(Exception e)
	    {
	        System.out.println("error !!");
	    }
	    return null;

	}
}
