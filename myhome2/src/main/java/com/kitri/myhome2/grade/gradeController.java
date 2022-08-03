package com.kitri.myhome2.grade;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.myhome2.board.BoardDao;
import com.kitri.myhome2.board.BoardDto;
/**
 * Servlet implementation class BoardController
 */


//성적게시판    
@WebServlet("/grade.do")
public class gradeController extends HttpServlet {
  private static final long serialVersionUID = 1L;
         
      /**
       * @see HttpServlet#HttpServlet()
       */
  public gradeController() {
      super();
          // TODO Auto-generated constructor stub
  }
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	  
	  request.setCharacterEncoding("utf-8");
	  response.setCharacterEncoding("utf-8");
	  
	  String cmd = request.getParameter("cmd");
		if( cmd == null || cmd.equals(""))
			cmd = "list"; //cmd파라미터 없을 때 처리하기
		if(cmd.equals("list"))
		{
			doList(request,response);
		}
		else if(cmd.equals("view"))
		{
			//http://localhost:8080/myhome2/grade.do?cmd=view
			doView(request,response);
		}
	}
  
  void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		gradeDao dao = new gradeDao();
		List<gradeDto> list = dao.getList(null);
		
		request.setAttribute("list",list);
		//request객체에 데이터를 저장 후 jsp로 보낸다
		RequestDispatcher rd
		= request.getRequestDispatcher("/grade/board_list_grade.jsp");
		rd.forward(request, response);
		//webapp/board/board_list.jsp로 토스한다
	}
  /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}
  
  void doView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		gradeDao dao = new gradeDao();
		String id=request.getParameter("id");
		gradeDto gradeDto = dao.getView(id);
		
		request.setAttribute("gradeDto",gradeDto);
		//데이터를 저장 후 jsp로 보낸다
		RequestDispatcher rd
		= request.getRequestDispatcher("/grade/board_view_grade.jsp");
		rd.forward(request, response);
		//webapp/board/board_list.jsp로 토스한다
	}

  
  

	
  }
  


