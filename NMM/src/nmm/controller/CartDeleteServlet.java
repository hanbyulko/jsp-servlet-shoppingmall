package nmm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nmm.dto.ModelAndView;
import nmm.service.CartService;

/**
 * Servlet implementation class CartDeleteServlet
 */
@WebServlet("/cartDeleteServlet")
public class CartDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
			System.out.println("나는 삭제 서블릿시작");
			PrintWriter out = response.getWriter();
			
			int cartNo = Integer.parseInt(request.getParameter("cartNo"));
			System.out.println("나는 삭제 서블릿 카트넘버:"+cartNo);
			
			try {
			int result = CartService.delete(cartNo);
			System.out.println("나는 ㅅ삭제 서블릿 리져트:"+result);
			out.println(result);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	
	}


