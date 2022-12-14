<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.*" %>
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
<body>

<%
String id=request.getParameter("id");
if(id == null) id="";
String cmd=request.getParameter("cmd");
if(cmd == null) cmd="";
BoardDto boardDto = (BoardDto)request.getAttribute("boardDto");
%>
<form name="myform">
	<input type="hidden" name="cmd" value="<%=cmd %>"/>
	<input type="hidden" name="id" value="<%=id%>"/>
	
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


    <div class="container" style="margin-top:80px">
        <h2>게시판 쓰기</h2>

        <table class="table table-hover " style="margin-top: 30px;">
            <colgroup>
                <col width="25%">
                <col width="*">
            </colgroup>
        
            <tbody>
              <tr>
                <td>제목</td>
                <td>
                    <div class="mb-3" style="margin-top:13px;">
                        <input type="text" class="form-control" id="title" name="title" 
                        placeholder="제목을 입력하세요" 
                        value="<%=boardDto.getTitle() %>" >
                    </div>
                </td>
              </tr>       
              <tr>
                <td>작성자</td>
                <td>
                    <div class="mb-3" style="margin-top:13px;">
                        <input type="text" class="form-control" id="writer" name="writer" 
                        placeholder="이름을 입력하세요" 
                        value="<%=boardDto.getWriter() %>" >
                    </div>
                </td>
              </tr>      
              <tr>
                <td>내용</td>
                <td>
                    <div class="mb-3" style="margin-top:13px;">
                      <textarea class="form-control" rows="5" id="contents" name="contents"><%=boardDto.getContents() %></textarea>
                    </div>
                </td>
              </tr>          
            </tbody>
          </table>
       
          <div class="container mt-3" style="text-align:right;">
            
            <button type="button" class="btn btn-secondary" onclick="goSave()">저장</button>
            <button type="button" class="btn btn-secondary" onclick="goList()">목록</button>
           
          </div>
          
    </div>
    </form>
</body>

		
   


</form>


</html>

<script>

function goSave()
{
	var frm = document.myform;
	frm.method="post";
	frm.action="/myhome2/board.do";
	frm.cmd.value="save";
	frm.submit();
}

function goList()
{
	var frm = document.myform;
	frm.action="/myhome2/board.do";
	frm.cmd.value="list";
	frm.submit();
}

</script>