package nmm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nmm.dto.ModelAndView;
import nmm.dto.UserDTO;
import nmm.service.UserService;

public class UserController implements Controller {
	@Override
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("servlet?controller=product+review&command=productList", false);
	}
	
	
	public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		List<UserDTO> list = UserService.selectAll(pageNo);
		SendPageInfo.sendInfo(request, response);
		request.setAttribute("list", list);
		
		return new ModelAndView("manager/userSelect", false);
	}
	
	public ModelAndView selectByKeyword(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		String keyword= request.getParameter("keyword");
		String value = request.getParameter("value");
		List<UserDTO> list = UserService.selectByKeyword(pageNo, keyword, value);
		SendPageInfo.sendInfo(request, response);
		request.setAttribute("list", list);
		return new ModelAndView("manager/userSelect", false);
	}
	
	
	
	public ModelAndView logOut(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.setAttribute("userId", null);
		session.setAttribute("userNo", null);
		return new ModelAndView("servlet?controller=product+review&command=productList", false);
	}

	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		System.out.println(userId+"/"+userPwd);
		UserDTO user = UserService.loginCheck(userId, userPwd);
		if (user != null) {
			session.setAttribute("userId", user.getUserId());
			session.setAttribute("userNo", user.getUserNo());
		}
		return new ModelAndView("servlet?controller=product+review&command=productList", false);
	}

	public ModelAndView signUp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String userAddr = request.getParameter("userAddr");
		int userPhone = Integer.parseInt(request.getParameter("userPhone"));
		String userEmail = request.getParameter("userEmail");
		String userBirth = request.getParameter("userBirth");
		UserDTO dto = new UserDTO(userId, userPwd,userName,  userBirth, userAddr, userPhone, userEmail);
		UserService.insert(dto);

		return new ModelAndView("servlet?controller=product+review&command=productList", false);
	}

	public ModelAndView upDate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String userAddr = request.getParameter("userAddr");
		int userPhone = Integer.parseInt(request.getParameter("userPhone"));
		String userEmail = request.getParameter("userEmail");
		UserDTO dto = new UserDTO(userId, userPwd, userName, userPhone, userAddr, userEmail);
		UserService.update(dto);
		return new ModelAndView("servlet?controller=product+review&command=productList", false);
	}

	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		UserService.delete(userId);
		return new ModelAndView("servlet?controller=product+review&command=productList", false);
	}
	
	public ModelAndView selectByUserNo(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		int userNo = (int)session.getAttribute("userNo");
		UserDTO userDTO = UserService.selectByUserNo(userNo);
		request.setAttribute("userDTO", userDTO);
		
		return new ModelAndView("user/productPurchase.jsp",false);
	}
}
