package com.gmu.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		ResultSet resultSet=preparedStatement.executeQuery();
		Integer wins=null;
		while(resultSet.next())
		{
			 
			 wins=resultSet.getInt("wins");
			 //System.out.println(password);
		}
		wins++;
		sql="update userdetails set wins=? where email=?";
		preparedStatement=con.prepareStatement(sql);
		preparedStatement.setInt(1, wins);
		preparedStatement.setString(1, email);
		preparedStatement .executeUpdate();
		return null;
	}
}
