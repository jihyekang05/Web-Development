package com.kitri.myhome2.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	String userid="user01"; //id
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
			conn = DriverManager.getConnection(url,userid,pwd);
			stmt = conn.createStatement();
			String sql="select * from board";
			sql = sql + " order by id desc"; //최신 글이 앞에 오도록 정렬
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
	
	BoardDto getView(String id)
	{
		Connection conn = null;//연결담당
		Statement stmt=null; //쿼리실행
		ResultSet rs=null; //실행된 결과 가져오는 클래스
		BoardDto rDto = new BoardDto();
		
		try {
			conn = DriverManager.getConnection(url,userid,pwd);
			stmt = conn.createStatement();
			String sql="select * from board where id="+id;
			
			rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				
				rDto.setId(rs.getString("id"));
				rDto.setWriter(rs.getString("writer"));
				rDto.setTitle(rs.getString("title"));
				rDto.setContents(rs.getString("contents"));
				rDto.setWdate(rs.getString("wdate"));
					
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
		
		
		return rDto;
	}
	
	void insert(BoardDto dto)
	{
		Connection conn = null;//연결담당
		PreparedStatement pstmt=null; //쿼리실행
		ResultSet rs=null; //실행된 결과 가져오는 클래스
		BoardDto rDto = new BoardDto();
		
		try {
			conn = DriverManager.getConnection(url,userid,pwd);
			
			String sql="insert into board"
					 +"(id,title, wdate, writer,contents)"
					 +"values(boardSeq.nextVal,?,sysdate,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dto.getTitle());
			pstmt.setString(2,dto.getWriter());
			pstmt.setString(3,dto.getContents());
			
			pstmt.executeQuery();
			//id값 자동증가
			//1.시퀀스를 사용한다 -오라클만 가능
			//2.쿼리를 실행한다 select nvl(max(id),0) + from board;
			
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
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		
		
	}


}
