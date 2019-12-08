package nmm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nmm.dto.CartDTO;
import nmm.dto.ModelAndView;
import nmm.dto.ProductDTO;
import nmm.dto.PurchaseDTO;
import nmm.dto.UserDTO;
import nmm.service.ProductService;
import nmm.service.PurchaseService;
import nmm.service.UserService;

public class PurchaseController implements Controller {
    @Override
    public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

    public ModelAndView insertPurchaseDBForDetail(HttpServletRequest request, HttpServletResponse response) throws Exception{
    	HttpSession session = request.getSession();
    	int userNo = (int) session.getAttribute("userNo");
    	int productNo = Integer.parseInt(request.getParameter("productNo"));
        int cartQty = Integer.parseInt(request.getParameter("cartQty"));
        request.setAttribute("cartQty", cartQty);
        
        PurchaseService.insert(userNo, productNo, cartQty);
        
        UserDTO userDTO = UserService.selectByUserNo(userNo);
        request.setAttribute("userDTO", userDTO);
        ProductDTO productDTO = ProductService.selectProduct(productNo);
        request.setAttribute("productDTO", productDTO);
        
        return new ModelAndView("user/purchase/productPurchase.jsp", false);
    }
    
    public ModelAndView insertPurchaseDBForCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        int userNo = (int) session.getAttribute("userNo");
        int i = Integer.parseInt(request.getParameter("cntNum"));

        int productNo;
        int cartQty;
        ///////////////////////
//        payment(request,response);

        for (int cnt = 0; cnt < i; cnt++) {
            System.out.println("i 값 : "+cnt);
            productNo=Integer.parseInt(request.getParameter("productNo["+cnt+"]"));
            cartQty=Integer.parseInt(request.getParameter("cartQty["+cnt+"]"));
            PurchaseService.insert(userNo, productNo, cartQty);

        }
        ////////////////////////////////////////////////////////////
        String name="";
        String email = "";
        String phone = "";
        String addr = "";
        String productName="";
        List<PurchaseDTO> list = PurchaseService.selectAllPurchase(userNo);
        PurchaseDTO dto;
        CartDTO cdto = new CartDTO();

        for (int cnt = 0; cnt < list.size(); cnt++) {
            dto = list.get(cnt);
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

}


