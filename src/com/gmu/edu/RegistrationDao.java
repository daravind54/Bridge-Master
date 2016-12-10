package com.gmu.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.gmu.util.BCrypt;

public class RegistrationDao 
{
	private static int workload = 12;
	
	public static String hashPassword(String password_plaintext) {
		String salt = BCrypt.gensalt(workload);
		System.out.println("salt is "+salt);
		String hashed_password = BCrypt.hashpw(password_plaintext, salt);
		System.out.println("hpw is "+hashed_password);
		return(hashed_password);
	}
	
	public static boolean checkPassword(String password_plaintext, String stored_hash) {
		boolean password_verified = false;

		if(null == stored_hash || !stored_hash.startsWith("$2a$"))
			throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

		password_verified = BCrypt.checkpw(password_plaintext, stored_hash);

		return(password_verified);
	}

	public void registerUser(Registration registration) throws ClassNotFoundException, SQLException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@apollo.vse.gmu.edu:1521:ite10g","bkumari","coaree");
		String sql="insert into userdetails(name, city, email, password) values (?, ?, ?, ?)";
		PreparedStatement preparedStatement=con.prepareStatement(sql);
		preparedStatement.setString(1, registration.getName());
		preparedStatement.setString(2, registration.getCity());
		preparedStatement.setString(3, registration.getEmail());
		String computed_hash = hashPassword(registration.getPassword());
		preparedStatement.setString(4, computed_hash);
		System.out.println("computed_hash is "+computed_hash);
		preparedStatement.executeUpdate();
		System.out.println("Record is inserted into Database");
	}
}
