<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@page import="java.util.*" %>
<%@page import="com.kitri.myhome2.grade.*" %>

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
<body>
    <nav class="navbar navbar-expand-sm bg-light navbar-light fixed-top">
        <div class="container-fluid">
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link active" href="#">Active</a>
            </li>
           <li class="nav-item">
              <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item">
              <a class="nav-link disabled" href="#">Disabled</a>
            </li>
          </ul>
        </div>
    </nav>
<%
gradeDto gradeDto = (gradeDto)request.getAttribute("gradeDto");

%>

    <div class="container" style="margin-top:80px">
        <h2>게시판 상세보기</h2>


        <table class="table table-hover " style="margin-top:30px;">
            <tbody>
              <tr class="table-secondary">
                <th>제목</th>
                <td colspan="9">성적출력</td>
              </tr>
              <tr>
                <th >작성자</th>
                <td><%=gradeDto.getName() %></td>
                <th >국어</th>
                <td><%=gradeDto.getKor() %></td>
                <th>수학</th>
                <td><%=gradeDto.getMath() %></td>
                <th>영어</th>
                <td><%=gradeDto.getEng() %></td>
                <th>총합</th>
                <td><%=gradeDto.getSum() %></td>
              </tr>
              <tr>
                <th colspan="10"  class="table-secondary">평균</td>
              </tr>
              <tr>
                <td colspan="6">
                  <%=gradeDto.getAvg() %>
                </td>
              </tr>
            </tbody>
          </table>

 
         
       
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