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
	public void getStats(String email) throws ClassNotFoundException, SQLException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@apollo.vse.gmu.edu:1521:ite10g","adasari2","eecooc");
		String sql="select name,email,wins,loss from userdetails";
		Statement statement=con.createStatement();
		ResultSet resultset=statement.executeQuery(sql);
		List<StatDetails> details=new ArrayList<StatDetails>();
		while(resultset.next())
		{
			
		}
	}
}
