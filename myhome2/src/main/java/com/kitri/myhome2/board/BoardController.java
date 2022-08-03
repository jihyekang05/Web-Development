package com.kitri.myhome2.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/board.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			//http://localhost:8080/myhome2/board.do?cmd=view&id=1
			doView(request,response);
		}
		else if(cmd.equals("write"))
			doWrite(request,response);
		else if(cmd.equals("save"))
			doSave(request,response);
		else if(cmd.equals("modify"))
			doModify(request,response);
	}
	
	void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		BoardDao dao = new BoardDao();
		List<BoardDto> list = dao.getList(null);
		
		request.setAttribute("list",list);
		//request객체에 데이터를 저장 후 jsp로 보낸다
		RequestDispatcher rd
		= request.getRequestDispatcher("/board/board_list.jsp");
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

		BoardDao dao = new BoardDao();
		String id=request.getParameter("id");
		BoardDto boardDto = dao.getView(id);
		
		request.setAttribute("boardDto",boardDto);
		//데이터를 저장 후 jsp로 보낸다
		RequestDispatcher rd
		= request.getRequestDispatcher("/board/board_view.jsp");
		rd.forward(request, response);
		//webapp/board/board_list.jsp로 토스한다
	}
	
	void doWrite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		BoardDto boardDto = new BoardDto();
		request.setAttribute("boardDto", boardDto);
		/*
		BoardDao dao = new BoardDao();
		String id=request.getParameter("id");
		BoardDto boardDto = dao.getView(id);
		
		
		request.setAttribute("boardDto",boardDto);
		//데이터를 저장 후 jsp로 보낸다
		 * 
		 */
		RequestDispatcher rd
		= request.getRequestDispatcher("/board/board_write.jsp");
		rd.forward(request, response);
		
	}
	
	void doSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		BoardDao dao = new BoardDao();
		BoardDto boardDto = new BoardDto();
		boardDto.setTitle(request.getParameter("title"));
		boardDto.setWriter(request.getParameter("writer"));
		boardDto.setContents(request.getParameter("contents"));
		dao.insert(boardDto);
		//forward -> 앞에서 받아온 정보를 가진채로 전달
		//sendRedirect -> 모든 정보를 삭제시키고 다른 url로 이동한다
		response.sendRedirect("/myhome2/board.do?cmd=list");
		
	}
	
	void doModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		BoardDao dao = new BoardDao();
		String id=request.getParameter("id");
		BoardDto boardDto = dao.getView(id);
		
		request.setAttribute("boardDto", boardDto);
		/*
		BoardDao dao = new BoardDao();
		String id=request.getParameter("id");
		BoardDto boardDto = dao.getView(id);
		
		
		request.setAttribute("boardDto",boardDto);
		//데이터를 저장 후 jsp로 보낸다
		 * 
		 */
		RequestDispatcher rd
		= request.getRequestDispatcher("/board/board_write.jsp");
		rd.forward(request, response);
		
	}
	
	
	
	
	

}
