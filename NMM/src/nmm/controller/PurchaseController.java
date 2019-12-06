package nmm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nmm.dto.ModelAndView;
import nmm.dto.PurchaseDTO;
import nmm.dto.UserDTO;
import nmm.service.PurchaseService;
import nmm.service.UserService;

import java.util.List;

public class PurchaseController implements Controller {
    @Override
    public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String command = request.getParameter("command");
        String userId = (String) request.getSession().getAttribute("userID");
        //userNo = UserService.select(userId).getUserNo();
        if (command.equals("selectAllHistory")) {
            return selectHistory(request, response);
        } else if (command.equals("selectAllPurchase")) {
            return selectPurchase(request, response);
        }
        return new ModelAndView();
    }

    private ModelAndView selectHistory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        int userNo = (int) session.getAttribute("userNo");
        List<PurchaseDTO> list = PurchaseService.selectAllHistory(userNo);
        request.setAttribute("list", list);
        return new ModelAndView("product/productHistory.jsp", false);
    }

    private ModelAndView selectPurchase(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        int userNo = (int) session.getAttribute("userNo");
        List<PurchaseDTO> list = PurchaseService.selectAllPurchase(userNo);
        request.setAttribute("list", list);
        return new ModelAndView("product/productPurchase.jsp", false);
    }

   
}

