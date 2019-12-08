package nmm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SendPageInfo {
	
	static void sendInfo(HttpServletRequest request, HttpServletResponse response){
		request.setAttribute("keyword", request.getParameter("keyword"));
		request.setAttribute("pageNo", request.getParameter("pageNo"));
		request.setAttribute("controller", request.getParameter("controller"));
		request.setAttribute("command", request.getParameter("command"));
	}
}
