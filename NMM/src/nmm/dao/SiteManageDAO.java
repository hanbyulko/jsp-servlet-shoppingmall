package nmm.dao;

import java.util.List;

import nmm.dto.ProductDTO;
import nmm.dto.SiteManageDTO;

public interface SiteManageDAO {
	List<SiteManageDTO> selectSiteManage();
	
	List<ProductDTO> selectAll();
}
