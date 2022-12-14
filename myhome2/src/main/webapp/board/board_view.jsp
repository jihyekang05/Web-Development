<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.kitri.myhome2.board.*" %>

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
String id = request.getParameter("id");
%>
<body>
	<form name="myform">
		<input type="hidden" name="cmd">
		<input type="hidden" name="id" value="<%=id %>">
		
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
BoardDto boardDto = (BoardDto)request.getAttribute("boardDto");

%>

    <div class="container" style="margin-top:80px">
        <h2>게시판 상세보기</h2>


        <table class="table table-hover " style="margin-top:30px;">
            <tbody>
              <tr class="table-secondary">
                <th>제목</th>
                <td colspan="5"><%=boardDto.getTitle() %></td>
              </tr>
              <tr>
                <th >작성자</th>
                <td><%=boardDto.getWriter() %></td>
                <th >작성일</th>
                <td><%=boardDto.getWdate() %></td>
                <th  >조회수</th>
                <td>12</td> 
              </tr>
              <tr>
                <th colspan="6"  class="table-secondary">내용</th>
              </tr>
              <tr>
                <td colspan="6">
                  <%=boardDto.getContents().replaceAll("\n","<br/>") %>
                </td>
              </tr>
            </tbody>
          </table>

 
         
       
          <div class="container mt-3" style="text-align:right;">
           
            <button type="button" class="btn btn-secondary" onclick="goModify()">수정</button>
            <button type="button" class="btn btn-secondary" onclick="goDelete()">삭제</button>
            <button type="button" class="btn btn-secondary" onclick="goList()">목록</button>
            
          </div>
          
    </div>
    </form>
</body>
</html>

<script>
function goModify()
{
	var frm = document.myform;
	frm.action="/myhome2/board.do";
	frm.cmd.value="modify";
	frm.submit();
}

function goList()
{
	var frm = document.myform;
	frm.action="/myhome2/board.do";
	frm.cmd.value="list";
	frm.submit();
}

function goDelete()
{
	if(confirm("삭제하시겠습니까?"))
	{
		var frm = document.myform;
		frm.action="/myhome2/board.do";
		frm.cmd.value="delete";
		frm.submit();
	}
}
</script>