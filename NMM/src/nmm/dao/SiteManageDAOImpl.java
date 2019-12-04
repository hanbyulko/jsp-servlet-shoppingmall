package nmm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import nmm.dto.SiteManageDTO;
import nmm.util.DbUtil;

public class SiteManageDAOImpl implements SiteManageDAO {

	@Override
	public List<SiteManageDTO> selectSiteManage() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<SiteManageDTO> list = new ArrayList<SiteManageDTO>();
		String sql = "";
//		try {
//			con = DbUtil.getConnection();
//			ps = con.prepareStatement(sql);
//			rs = ps.executeQuery();
//			while(rs.next()) {
//				String mgtDate = rs.getString(1);
//				int mgtLoginNo = rs.getInt(2);
//				int mgtProfit = rs.getInt(3);
//				
//				list.add(new SiteManageDTO(mgtDate, mgtLoginNo, mgtProfit));
//			}
//		}catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			DbUtil.dbClose(rs, ps, con);
//		}
		
		list.add(new SiteManageDTO("2019-12-1", 50, 150000));
		list.add(new SiteManageDTO("2019-12-2", 80, 200000));
		list.add(new SiteManageDTO("2019-12-3", 10, 100000));
		return list;
	}

}
