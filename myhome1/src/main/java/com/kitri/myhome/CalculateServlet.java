package com.kitri.myhome;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculateServlet
 */
@WebServlet("/calc.do")
public class CalculateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
  //http://localhost:8080/myhome1/input.do?usename=홍길동&phone=010-0000-0000
    //http://localhost:8080/myhome1/calc.do?x=5&y=7&oper=1
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int x = Integer.parseInt(request.getParameter("x")); 
		int y = Integer.parseInt(request.getParameter("y")); 
		String oper = request.getParameter("oper");
		String result="";
		
		if(oper.equals("1"))
			result=String.format("%d + %d = %d",x,y,x+y);
		else if(oper.equals("2"))
			result=String.format("%d - %d = %d",x,y,x-y);
		else if(oper.equals("3"))
			result=String.format("%d * %d = %d",x,y,x*y);
		else
			result=String.format("%d / %d = %d",x,y,x/y);
			
			
		response.getWriter().println(result);
			
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
