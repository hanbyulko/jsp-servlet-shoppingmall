package nmm.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import nmm.dto.ModelAndView;
import nmm.dto.ProductDTO;
import nmm.dto.SiteManageDTO;
import nmm.service.SiteManageService;

public class SiteManageController implements Controller {

	@Override
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("manager/accounting.jsp", false);
	}

	public ModelAndView accounting(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<SiteManageDTO> list = SiteManageService.selectSiteManage();
		request.setAttribute("list", list);
		return new ModelAndView("manager/accounting.jsp", false);
	}
	
	public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response) {
		List<ProductDTO> list = SiteManageService.selectAll();
		request.setAttribute("list", list);
		return new ModelAndView("manager/productManagement.jsp", false);
	}

}
