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
      List<CartDTO> list = CartService.selectAll(userNo);
      request.setAttribute("list", list);
      return new ModelAndView("cart/cart.jsp", false);
   }

   public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
      HttpSession session = request.getSession();
      int userNo = (int) session.getAttribute("userNo");

      int cartQty = Integer.parseInt(request.getParameter("cartQty"));
      int productNo = Integer.parseInt(request.getParameter("productNo"));
      int result = CartService.insert(userNo, productNo, cartQty);

      return new ModelAndView("cart/cart.jsp", false);
   }

}