package nmm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nmm.service.PurchaseService;

/**
 * Servlet implementation class ServletForAPI
 */
@WebServlet("/servletForAPI")
public class ServletForAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("º≠∫Ì∏¥ »£√‚");
		HttpSession session = request.getSession();
		int userNo = (int)session.getAttribute("userNo");
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		int purchaseQty = Integer.parseInt(request.getParameter("purchaseQty"));
		System.out.println(userNo + "| " + productNo + " | " + purchaseQty);
		try {
			PurchaseService.insert(userNo, productNo, purchaseQty);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
