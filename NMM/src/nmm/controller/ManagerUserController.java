package nmm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nmm.dto.ManagerUserDTO;
import nmm.dto.ModelAndView;
import nmm.service.ManagerUserService;
import nmm.service.UserService;

public class ManagerUserController implements Controller{

	@Override
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("/servlet?controller=product&command=product", true);
	}

	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		return new ModelAndView("/servlet?controller=managerUser&command=select", false);
	}

	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("들어오니?");
		String userId = request.getParameter("name");
		System.out.println(userId);
		
		int result = UserService.delete(userId);
			
		return new ModelAndView("/manager/userManagement.jsp", false);
	}

	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ManagerUserService.update(new ManagerUserDTO(Integer.parseInt(request.getParameter("mgtUserNo")),
				request.getParameter("mgtUserId"), request.getParameter("mgtUserPwd")
		));
		return new ModelAndView("/servlet?controller=managerUser&command=select", false);
	}

	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ManagerUserService.insert(new ManagerUserDTO(request.getParameter("mgtUserId"), request.getParameter("mgtUserPwd")
		));
		return new ModelAndView("/servlet?controller=managerUser&command=select", false);
	}

	public ModelAndView select(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setAttribute("list",ManagerUserService.selectAll());
		return new ModelAndView("manager/managerUserHandle.jsp", false);
	}

	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String mgtUserId = request.getParameter("mgtUserId");
		String mgtUserPw = request.getParameter("mgtUserPwd");
		boolean check =ManagerUserService.login(mgtUserId, mgtUserPw);
		if(check==true) {
			request.getSession().setAttribute("mgtUserId", mgtUserId);
			return new ModelAndView("servlet?controller=product+review&command=productList", true);
		}else if(check==false) {
			System.out.println("false");
			return new ModelAndView("manager/managerLogin.jsp", true);
		}else {
			return new ModelAndView("manager/managerLogin.jsp", true);
		}
		
	}
}
