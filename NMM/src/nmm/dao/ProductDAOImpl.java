package nmm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nmm.dto.ProductDTO;
import nmm.util.DbUtil;

public class ProductDAOImpl implements ProductDAO {
	@Override
	public List<ProductDTO> selectAll() throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		String sql = "SELECT * FROM PRODUCT";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				ProductDTO product = new ProductDTO();
				product.setProductNo(rs.getInt(1));
				product.setProductCategory(rs.getString(2));
				product.setProductStock(rs.getInt(3));
				product.setProductName(rs.getString(4));
				product.setProductColor(rs.getString(5));
				product.setProductSize(rs.getString(6));
				product.setProductPrice(rs.getInt(7));
				product.setProductResiDate(rs.getString(8));
				list.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
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
	public List<ProductDTO> selectJacket() throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		String sql = "SELECT PRODUCT_NO,PRODUCT_NAME,PRODUCT_PRICE FROM PRODUCT WHERE PRODUCT_CATEGORY='자켓'";
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
		String sql = "SELECT PRODUCT_NO,PRODUCT_NAME,PRODUCT_PRICE FROM PRODUCT WHERE PRODUCT_CATEGORY='코트'";
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
		String sql = "SELECT PRODUCT_NO,PRODUCT_NAME,PRODUCT_PRICE FROM PRODUCT WHERE PRODUCT_CATEGORY='패딩'";
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
		ProductDTO product = new ProductDTO();
		String sql = "select * from PRODUCT WHERE PRODUCT_NO=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, productNo);
			rs = ps.executeQuery();
			while (rs.next()) {
				product.setProductNo(rs.getInt(1));
				product.setProductCategory(rs.getString(2));
				product.setProductStock(rs.getInt(3));
				product.setProductName(rs.getString(4));
				product.setProductColor(rs.getString(5));
				product.setProductSize(rs.getString(6));
				product.setProductPrice(rs.getInt(7));
				product.setProductResiDate(rs.getString(8));
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
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
				+ "PRODUCT_RESIDATE=sysdate WHERE PRODUCT_NO=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, productDTO.getProductNo());
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

	@Override
	public List<ProductDTO> searchByKeyword(String keyword) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM PRODUCT WHERE UPPER(PRODUCT_NAME) LIKE UPPER(?) OR PRODUCT_CATEGORY LIKE ?";
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + keyword+ "%");
			ps.setString(2, "%" + keyword+ "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				ProductDTO product = new ProductDTO();
				product.setProductNo(rs.getInt(1));
				product.setProductCategory(rs.getString(2));
				product.setProductStock(rs.getInt(3));
				product.setProductName(rs.getString(4));
				product.setProductColor(rs.getString(5));
				product.setProductSize(rs.getString(6));
				product.setProductPrice(rs.getInt(7));
				product.setProductResiDate(rs.getString(8));
				list.add(product);
			}
		} finally {
			DbUtil.dbClose(rs , ps, con);
		}
		return list;
		
		
	}
	
	
}