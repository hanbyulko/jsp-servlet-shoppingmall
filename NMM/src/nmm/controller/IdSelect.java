package nmm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nmm.service.UserService;

/**
 * Servlet implementation class IdSelect
 */
@WebServlet("/idSelect")
public class IdSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml; charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
		String id = request.getParameter("id");
		System.out.println(id);
		if(id.isEmpty()) {
			System.out.println("1111");
		}
		boolean result = UserService.idCheck(id);
		if(result==true) {
			out.print("중복입니다");
		}else {
			out.print("사용가능합니다");
		}
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
