package nmm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import nmm.dto.ProductDTO;
import nmm.util.DbUtil;

public class ProductDAOImpl implements ProductDAO {
	List<List<ProductDTO>> list = new ArrayList<List<ProductDTO>>();

	@Override
	public List<List<ProductDTO>> selectAll() throws Exception {
		List<ProductDTO> listLatest = this.selectLatest();
		List<ProductDTO> listPopular = this.selectPopular();

		list.add(listLatest);
		list.add(listPopular);
		return list;
	}

	public List<ProductDTO> selectLatest() throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductDTO> listLatest = new ArrayList<ProductDTO>();
		String sql = "SELECT PRODUCT_NO,PRODUCT_NAME,PRODUCT_PRICE FROM VIEW_LATESTPRODUCT";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int productNo = rs.getInt(1);
				String productName = rs.getString(2);
				int productPrice = rs.getInt(3);

				listLatest.add(new ProductDTO(productNo, productName, productPrice));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return listLatest;
	}

	@Override
	public List<ProductDTO> selectPopular() throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductDTO> listPopular = new ArrayList<ProductDTO>();
		String sql = "";
//		try {
//			con = DbUtil.getConnection();
//			ps = con.prepareStatement(sql);
//			rs = ps.executeQuery();
//			while(rs.next()) {
//				String productImg = rs.getString(1);
//				String productName = rs.getString(2);
//				String productPrice = rs.getString(3);
//				
//				listPopular.add(new ProductDTO(productImg, productName, productPrice));
//			}
//		}catch (Exception e) {
//			// TODO: handle exception
//		}finally {
//			DbUtil.dbClose(rs, ps, con);
//		}
		return listPopular;
	}

	@Override
	public List<ProductDTO> selectJacket() throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		String sql = "SELECT PRODUCT_NO,PRODUCT_NAME,PRODUCT_PRICE FROM PRODUCT WHERE PRODUCT_CATEGORY='ÀÚÄÏ'";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int productNo = rs.getInt(1);
				String productName = rs.getString(2);
				int productPrice = rs.getInt(3);

				list.add(new ProductDTO(productNo, productName, productPrice));
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public List<ProductDTO> selectCoat() throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		String sql = "SELECT PRODUCT_NO,PRODUCT_NAME,PRODUCT_PRICE FROM PRODUCT WHERE PRODUCT_CATEGORY='ÄÚÆ®'";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int productNo = rs.getInt(1);
				String productName = rs.getString(2);
				int productPrice = rs.getInt(3);

				list.add(new ProductDTO(productNo, productName, productPrice));
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public List<ProductDTO> selectPadding() throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		String sql = "SELECT PRODUCT_NO,PRODUCT_NAME,PRODUCT_PRICE FROM PRODUCT WHERE PRODUCT_CATEGORY='ÆÐµù'";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int productNo = rs.getInt(1);
				String productName = rs.getString(2);
				int productPrice = rs.getInt(3);

				list.add(new ProductDTO(productNo, productName, productPrice));
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public ProductDTO selectProduct(int productNo) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ProductDTO product = null;
		String sql = "";
//		try {
//			con = DbUtil.getConnection();
//			ps = con.prepareStatement(sql);
//			rs = ps.executeQuery();
//			while(rs.next()) {
//				String productImg = rs.getString(1);
//				String productName = rs.getString(2);
//				String productPrice = rs.getString(3);
//				
//				listLatest.add(new ProductDTO(productImg, productName, productPrice));
//			}
//		}finally {
//			DbUtil.dbClose(rs, ps, con);
//		}
//		product = new ProductDTO(productNo, "ï¿½ï¿½Æ®", 1, "ï¿½Ñºï¿½ï¿½ï¿½ï¿½ï¿½Æ®", "ï¿½ï¿½Æ®ï¿½Ì¹ï¿½ï¿½ï¿½", "ï¿½ï¿½ï¿½ï¿½", "95", "1500");
//		
		return product;
	}

	@Override
	public int insert(ProductDTO productDTO) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		String sql = "insert into PRODUCT values(PRODUCT_NO_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, sysdate)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, productDTO.getProductCategory());
			ps.setInt(2, productDTO.getProductStock());
			ps.setString(3, productDTO.getProductName());
			ps.setString(4, productDTO.getProductColor());
			ps.setString(5, productDTO.getProductSize());
			ps.setInt(6, productDTO.getProductPrice());
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int update(ProductDTO productDTO) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "update PRODUCT set PRODUCT_CATEGORY=?, PRODUCT_STOCK=?, PRODUCT_NAME=?, PRODUCT_COLOR=?, PRODUCT_SIZE=?, PRODUCT_PRICE=?,"
				+ "PRODUCT_RESIDATE=sysdate";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int delete(int productNo) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "delete from PRODUCT where PRODUCT_NO=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, productNo);
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}
}