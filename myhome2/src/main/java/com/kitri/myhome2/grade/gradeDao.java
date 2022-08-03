package com.kitri.myhome2.grade;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.myhome2.board.BoardDto;

public class gradeDao {
	
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	String userid="user01"; //id
	String pwd="1234"; //passwd
	
		public gradeDao()
		{
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		List<gradeDto> getList(gradeDto dto)
		{
			List<gradeDto> list = new ArrayList<gradeDto>();
			Connection conn = null;
			Statement stmt=null;
			ResultSet rs=null;
					
		try {
			conn = DriverManager.getConnection(url,userid,pwd);
			stmt = conn.createStatement();
			String sql="select * from grade";
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				gradeDto gDto = new gradeDto();
				gDto.setId(rs.getInt("id"));
				gDto.setName(rs.getString("name"));
				gDto.setKor(rs.getInt("kor"));
				gDto.setMath(rs.getInt("math"));
				gDto.setEng(rs.getInt("eng"));
				gDto.setSum(rs.getInt("grade_sum"));
				gDto.setAvg(rs.getInt("grade_avg"));
				
				list.add(gDto);
				
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

	gradeDto getView(String id)
	{
		Connection conn = null;//연결담당
		Statement stmt=null; //쿼리실행
		ResultSet rs=null; //실행된 결과 가져오는 클래스
		gradeDto gDto = new gradeDto();
		
		try {
			conn = DriverManager.getConnection(url,userid,pwd);
			stmt = conn.createStatement();
			String sql="select * from grade where id = "+id;
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				gDto.setId(rs.getInt("id"));
				gDto.setName(rs.getString("name"));
				gDto.setKor(rs.getInt("kor"));
				gDto.setMath(rs.getInt("math"));
				gDto.setEng(rs.getInt("eng"));
				gDto.setSum(rs.getInt("grade_sum"));
				gDto.setAvg(rs.getInt("grade_avg"));
				
				
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
		
		
		return gDto;
	}


}
	
		



