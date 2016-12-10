package com.gmu.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ViewStatsDao 
{
	public List<StatDetails> getStats() throws ClassNotFoundException, SQLException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@apollo.vse.gmu.edu:1521:ite10g","adasari2","eecooc");
		String sql="select name,email,wins,loss from userdetails where email=daravind54@gmail.com";
		Statement statement=con.createStatement();
		ResultSet resultset=statement.executeQuery(sql);
		List<StatDetails> details=new ArrayList<StatDetails>();
		while(resultset.next())
		{
			StatDetails s=new StatDetails();
			s.setName(resultset.getString("name"));
			s.setEmail(resultset.getString("email"));
			s.setWins(resultset.getInt("wins"));
			s.setLoss(resultset.getInt("loss"));
			details.add(s);
		}
		return details;
	}
}
