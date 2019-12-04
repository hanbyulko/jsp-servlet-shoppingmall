package nmm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nmm.dto.ModelAndView;

public interface Controller {
	
	ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
