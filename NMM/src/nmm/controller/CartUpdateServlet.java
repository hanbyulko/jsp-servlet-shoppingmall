package nmm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nmm.service.CartService;


/**
 * Servlet implementation class CartUpdateServlet
 */
@WebServlet("/cartUpdateServlet")
public class CartUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		int cartNo = Integer.parseInt(request.getParameter("cartNo"));
		System.out.println("나는 업데이트 서블릿 카트넘버:"+cartNo);
		int cartQty = Integer.parseInt(request.getParameter("cartQty"));
		System.out.println("나는 업데이트 서블릿 cartQty:"+cartQty);
		request.getParameter("cartQty");
		
		try {
			int result = CartService.update(cartNo, cartQty);
			System.out.println("나는 업데이트 서블릿 리져트:"+result);
			PrintWriter out = response.getWriter();
			out.println(result);
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}

}
