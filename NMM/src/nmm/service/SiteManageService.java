package nmm.service;

import java.util.List;

import nmm.dao.SiteManageDAO;
import nmm.dao.SiteManageDAOImpl;
import nmm.dto.ProductDTO;
import nmm.dto.SiteManageDTO;

public class SiteManageService {
	private static SiteManageDAO siteManageDAO  = new SiteManageDAOImpl();
	
	public static List<SiteManageDTO> selectSiteManage(){
		List<SiteManageDTO> list = siteManageDAO.selectSiteManage();
		System.out.println(list);
		return list;
	}
	
	public static List<ProductDTO> selectAll(){
		List<ProductDTO> list = siteManageDAO.selectAll();
		return list;
	}
}
