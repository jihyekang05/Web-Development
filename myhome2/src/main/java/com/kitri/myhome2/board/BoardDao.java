package com.kitri.myhome2.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	String id="user01"; //id
	String pwd="1234"; //passwd
	
	public BoardDao()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	List<BoardDto> getList(BoardDto dto)
	{
		List<BoardDto> list = new ArrayList<BoardDto>();
		Connection conn = null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			conn = DriverManager.getConnection(url,id,pwd);
			stmt = conn.createStatement();
			String sql="select * from board";
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				BoardDto rDto = new BoardDto();
				rDto.setId(rs.getString("id"));
				rDto.setWriter(rs.getString("writer"));
				rDto.setTitle(rs.getString("title"));
				rDto.setContents(rs.getString("contents"));
				rDto.setWdate(rs.getString("wdate"));
				
				list.add(rDto);
			}
		} 
		catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		
		return list;
	}

}
