package com.kitri.myhome;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	//함수를 만들어서 url과 연결작업을 한다
	
	@RequestMapping("/test.do")
	String test()
	{
		System.out.println("test");
		
		
		return "/test"; //jsp랑 연동을 한다.
		//webapp/WEB-INF/views 폴더에서 test.jsp를 찾는다
	}
	
	//http://localhost:9000/myhome/test2.do?name="홍길동"&age=20
	@RequestMapping("/test2.do")
	String test2(String name, int age, Model model)
	{
		System.out.println(name);
		System.out.println(age);
		
		//request.setAttribute와 동일함
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		
		return "/test2";

	}
	
	//calc.do?x=5&y=7&oper=1
	@RequestMapping("/calc.do")
	String calc(int x, int y, int oper, Model model)
	{
		System.out.println(x);
		int res=0;
		if(oper==1)
			res=x+y;
		else if(oper==2)
			res=x-y;
		else if(oper==3)
			res=x*y;
		else if(oper==4)
			res=x/y;
		
		model.addAttribute("x",x);
		model.addAttribute("y",y);
		model.addAttribute("res",res);
		

		return "/calc";
	}
	
	
}
