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

	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int userNo = (int) session.getAttribute("userNo");

		int cartNo = Integer.parseInt(request.getParameter("cartNo"));
		int cartQty = Integer.parseInt(request.getParameter("cartQty"));
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		CartService.insert(cartNo, userNo, productNo, cartQty);
		return new ModelAndView("cart/cart.jsp", false);
	}

	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int userNo = (int) session.getAttribute("userNo");

		int cartNo = Integer.parseInt(request.getParameter("cartNo"));
		int cartQty = Integer.parseInt(request.getParameter("cartQty"));
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		CartService.update(cartNo, userNo, productNo, cartQty);
		return new ModelAndView("cart/cart.jsp", false);
	}

	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int userNo = (int) session.getAttribute("userNo");
		System.out.println(userNo);
		int cartNo = Integer.parseInt(request.getParameter("cartNo"));
		System.out.println(cartNo);
		CartService.delete(cartNo, userNo);
		return new ModelAndView("cart/cart.jsp", false);
	}

}
