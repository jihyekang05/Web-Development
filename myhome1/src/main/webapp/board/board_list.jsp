<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.sql.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</head>
<%
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}
	catch(ClassNotFoundException e)
	{
		System.out.println("드라이버 없음");
	}
	Connection conn = null; //연결담당
	Statement stmt = null; //쿼리실행
	ResultSet rs = null; //실행된 결과 가져오는 클래스
	
	
	
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	String userid ="user01";
	String pwd = "1234";
	
	conn = DriverManager.getConnection(url, userid, pwd);
	stmt = conn.createStatement();
%>








<body>
    <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="javascript:void(0)">Logo</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="mynavbar">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link" href="javascript:void(0)">Link</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="javascript:void(0)">Link</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="javascript:void(0)">Link</a>
        </li>
      </ul>
      <div class="d-flex">
        <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link" href="javascript:void(0)">Link</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="javascript:void(0)">Link</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="javascript:void(0)">Link</a>
        </li>
      </ul>
      </div>
    </div>
  </div>
</nav>


    <div class="container" style="margin-top:80px">
        <h2>게시판 목록</h2>

        <div class="input-group mb-3" style="margin-top:20px;">
            <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown">
                선택하세요
            </button>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="#">제목</a></li>
              <li><a class="dropdown-item" href="#">내용</a></li>
              <li><a class="dropdown-item" href="#">제목+내용</a></li>
            </ul>
            <input type="text" class="form-control" placeholder="Search">
            <button class="btn btn-secondary" type="submit">Go</button>
             <table class="table table-hover">
            	<colgroup>
            		<col width="8%">
            		<col width="*">
            		<col width="12%">
            		<col width="12%">
            	</colgroup>
            	<thead class="table-secondary">
            	 <tr>
            	 	<th>번호</th>
            	 	<th>제목</th>
            	 	<th>작성자</th>
            	 	<th>작성일</th>
            	 </tr>
                </thead>
          </div>

        <table class="table table-hover ">
            <thead class="table-secondary">
              <tr>
                <th>Firstname</th>
                <th>Lastname</th>
                <th>Email</th>
              </tr>
            </thead>
            <tbody>
           
                
            		
            </table>
<% 
	String sql = "select * from board";
	rs = stmt.executeQuery(sql);
	while(rs.next())
	{
		System.out.println(rs.getString("id")+" "+

		rs.getString("title")+ " " + rs.getString("writer"));
%>
            
              <tr>
              
              	<td><%=rs.getString("id") %></td>
              	<td><%=rs.getString("title") %></td>
              	<td><%=rs.getString("writer") %></td>
              	<td><%=rs.getString("wdate") %></td>
              </tr>

            </tbody>
<% 
	}
	
	rs.close();
	stmt.close();
	conn.close();
	

%>
          </table>

 
          <ul class="pagination  justify-content-center">
            <li class="page-item disabled"><a class="page-link" href="#">first</a></li>
            <li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item"><a class="page-link" href="#">4</a></li>
            <li class="page-item"><a class="page-link" href="#">5</a></li>
            <li class="page-item"><a class="page-link" href="#">Next</a></li>
            <li class="page-item"><a class="page-link" href="#">last</a></li>
          </ul>
       
          <div class="container mt-3" style="text-align:right;">
            <a href="#" class="btn btn-secondary">Link Button</a>
            <button type="button" class="btn btn-secondary">Button</button>
            <input type="button" class="btn btn-secondary" value="Input Button">
            <input type="submit" class="btn btn-secondary" value="Submit Button">
            <input type="reset" class="btn btn-secondary" value="Reset Button">
          </div>
          
    </div>
</body>
</html>