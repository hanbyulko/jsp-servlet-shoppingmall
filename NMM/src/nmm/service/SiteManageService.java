package nmm.service;

import java.util.List;

import nmm.dao.SiteManageDAO;
import nmm.dao.SiteManageDAOImpl;
import nmm.dto.SiteManageDTO;

public class SiteManageService {
	private static SiteManageDAO siteManageDAO  = new SiteManageDAOImpl();
	
	public static List<SiteManageDTO> selectSiteManage(){
		System.out.println("값나오니?");
		List<SiteManageDTO> list = siteManageDAO.selectSiteManage();
		System.out.println(list);
		return list;
	}
}
