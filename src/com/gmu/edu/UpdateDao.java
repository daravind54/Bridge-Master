package com.gmu.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDao
{
	public String updateWinLoss(String email) throws ClassNotFoundException, SQLException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@apollo.vse.gmu.edu:1521:ite10g","adasari2","eecooc");
		String sql="select wins from userdetails where email=?";
		PreparedStatement preparedStatement=con.prepareStatement(sql);
		preparedStatement.setString(1, email);
		return null;
	}
}
