package nmm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import nmm.dto.ProductDTO;
import nmm.dto.SiteManageDTO;
import nmm.util.DbUtil;

public class SiteManageDAOImpl implements SiteManageDAO {

	@Override
	public List<SiteManageDTO> selectSiteManage() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<SiteManageDTO> list = new ArrayList<SiteManageDTO>();
		String sql = "SELECT MGT_DATE, MGT_LOGIN_NO, MGT_PROFIT FROM MGT";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String mgtDate = rs.getString(1);
				int mgtLoginNo = rs.getInt(2);
				int mgtProfit = rs.getInt(3);
				
				list.add(new SiteManageDTO(mgtDate, mgtLoginNo, mgtProfit));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		
		return list;
	}
	
	public List<ProductDTO> selectAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		String sql = "SELECT PRODUCT_NO, PRODUCT_NAME, PRODUCT_STOCK, PRODUCT_PRICE FROM PRODUCT";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductDTO productDTO = new ProductDTO();
				productDTO.setProductNo(rs.getInt(1));
				productDTO.setProductName(rs.getString(2));
				productDTO.setProductStock(rs.getInt(3));
				productDTO.setProductPrice(rs.getInt(4));
				
				list.add(productDTO);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		
		return list;
	}

}
