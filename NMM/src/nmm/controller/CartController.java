package nmm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nmm.dto.CartDTO;
import nmm.dto.ModelAndView;
import nmm.service.CartService;

public class CartController implements Controller {

	@Override
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = (String) request.getSession().getAttribute("userId");
		return new ModelAndView("cart/cart.jsp", false);
	}

	public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int userNo = (int) session.getAttribute("userNo");
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		List<CartDTO> list = CartService.selectAll(userNo, pageNo);
		request.setAttribute("pageCnt", list.get(list.size()-1>0?list.size()-1:list.size()).getPageCnt());
		request.setAttribute("list", list);
		return new ModelAndView("cart/cart.jsp", false);
	}
	/*
	 * public ModelAndView selectPurchase(HttpServletRequest request,
	 * HttpServletResponse response) throws Exception { HttpSession session =
	 * request.getSession(); int userNo = (int) session.getAttribute("userNo");
	 * 
	 * List<CartDTO> cartNos = CartService.selectPurchase(cartNos); JSONArray list =
	 * JSONArray.fromObject(list);
	 * response.setContentType("text/html;charset=UTF-8");
	 * 
	 * PrintWriter out = response.getWriter(); out.println(list);
	 * 
	 * request.setAttribute("list", cartNos); return new
	 * ModelAndView("cart/cart.jsp", false);
	 * 
	 * 
	 * //list를 json형태로 변환 -> ~.jar 필요.
	 * 
	 * 
	 * 
	 * }
	 */

	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int userNo = (int) session.getAttribute("userNo");

		int cartQty = Integer.parseInt(request.getParameter("cartQty"));
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		CartService.insert(userNo, productNo, cartQty);
		return new ModelAndView("cart/cart.jsp", false);
	}




}
