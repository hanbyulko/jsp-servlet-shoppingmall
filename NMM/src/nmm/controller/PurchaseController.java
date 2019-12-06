package nmm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nmm.dto.CartDTO;
import nmm.dto.ModelAndView;
import nmm.dto.PurchaseDTO;
import nmm.dto.UserDTO;
import nmm.service.PurchaseService;
import nmm.service.UserService;

import java.util.List;

public class PurchaseController implements Controller {
    @Override
    public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {

//        String command = request.getParameter("command");
        //String userId = (String) request.getSession().getAttribute("userID");
        //userNo = UserService.select(userId).getUserNo();
//        if (command.equals("selectAllHistory")) {
//            return selectHistory(request, response);
//        } else if (command.equals("selectAllPurchase")) {
//            return selectPurchase(request, response);
//        }
        return null;
    }

   public ModelAndView selectHistory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        int userNo = (int) session.getAttribute("userNo");

        List<PurchaseDTO> list = PurchaseService.selectAllHistory(userNo);
        request.setAttribute("list", list);
        return new ModelAndView("user/purchase/purchaseHistory.jsp", false);
    }

//    public ModelAndView selectPurchase(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        // 구매할 물품 보여주는 결제 전 페이지
//        //결제 실패하면 다시 이쪽으로 와야할듯
//        HttpSession session = request.getSession();
//        int userNo = (int) session.getAttribute("userNo");
//        List<PurchaseDTO> list = PurchaseService.selectAllPurchase(userNo);
//        request.setAttribute("list", list);
//        return new ModelAndView("user/purchase/productPurchase.jsp", false);
//    }
    public ModelAndView payment(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name="";
        String email = "";
        String phone = "";
        String addr = "";
        String productName="";
        HttpSession session = request.getSession();
        int userNo = (int) session.getAttribute("userNo");
        List<PurchaseDTO> list = PurchaseService.selectAllPurchase(userNo);
        PurchaseDTO dto;
        CartDTO cdto = new CartDTO();

        for (int i = 0; i < list.size(); i++) {
            dto = list.get(i);
            name=dto.getUserDTO().getUserName();
            email=dto.getUserDTO().getUserEmail();
            phone=dto.getUserDTO().getUserPhone();
            addr=dto.getUserDTO().getUserAddr();
            productName=dto.getProductDTO().getProductName();

        }
        request.setAttribute("name",name);
        request.setAttribute("email",email);
        request.setAttribute("phone",phone);
        request.setAttribute("address",addr);
        request.setAttribute("productName",productName);

        return new ModelAndView("user/purchase/api.jsp", false);
    }
    public ModelAndView insertPurchaseDB(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        int userNo = (int) session.getAttribute("userNo");

        int productNo = Integer.parseInt(request.getParameter("productNo"));
        int cartQty = Integer.parseInt(request.getParameter("cartQty"));

        PurchaseService.insert(userNo, productNo, cartQty);



        return new ModelAndView("user/purchase/api.jsp", false);
    }

   
}


