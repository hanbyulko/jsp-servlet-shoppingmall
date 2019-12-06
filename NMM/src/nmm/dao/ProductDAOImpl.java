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
	public List<ProductDTO> selectAll(int pageNo) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		Connection con2 = null;
		PreparedStatement ps2 = null;
		ResultSet rs2 = null;
		int pageCnt = 0;
		String cnt = "SELECT COUNT(*) FROM PRODUCT ORDER BY PRODUCT_NO ASC";
		String sql = "SELECT * FROM (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM product ORDER BY PRODUCT_NO ASC) a WHERE ROWNUM <= ?)  WHERE rnum >= ?";
		try {
			con2 = DbUtil.getConnection();
			ps2 = con2.prepareStatement(cnt);
			rs2 = ps2.executeQuery();
			while (rs2.next()) {
				pageCnt = rs2.getInt(1);
			}
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, pageNo * 8 + 1);
			ps.setInt(2, (pageNo - 1) * 8 + 1);
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
				product.setPageCnt(pageCnt % 8 == 0 ? pageCnt / 8 : pageCnt / 8 + 1);
				list.add(product);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
			DbUtil.dbClose(rs2, ps2, con2);
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
				ProductDTO dto = new ProductDTO();
				dto.setProductNo(productNo);
				dto.setProductName(productName);
				dto.setProductPrice(productPrice);
				listLatest.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return listLatest;
	}

	@Override
	public List<ProductDTO> selectByCategory(int pageNo, String category) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con2 = null;
		PreparedStatement ps2 = null;
		ResultSet rs2 = null;
		int pageCnt = 0;
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		String cnt = "SELECT COUNT(*) FROM PRODUCT WHERE PRODUCT_CATEGORY=? AND ROWID IN (SELECT MAX(ROWID) FROM PRODUCT GROUP BY PRODUCT_NAME)";
		String sql = "SELECT * FROM (SELECT a.*, ROWNUM rnum FROM (SELECT PRODUCT_NO, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_CATEGORY FROM PRODUCT WHERE PRODUCT_CATEGORY=? AND ROWID IN (SELECT MAX(ROWID) FROM PRODUCT GROUP BY PRODUCT_NAME)) a WHERE ROWNUM <= ?)  WHERE rnum >= ?";
		try {
			con2 = DbUtil.getConnection();
			ps2 = con2.prepareStatement(cnt);
			ps2.setString(1, category);
			rs2 = ps2.executeQuery();
			while (rs2.next()) {
				pageCnt = rs2.getInt(1);
			}
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, category);
			ps.setInt(2, pageNo * 8);
			ps.setInt(3, (pageNo - 1) * 8 + 1);
			rs = ps.executeQuery();
			while (rs.next()) {
				int productNo = rs.getInt(1);
				String productName = rs.getString(2);
				int productPrice = rs.getInt(3);
				String productCategory = rs.getString(4);
				ProductDTO dto = new ProductDTO();
				dto.setProductNo(productNo);
				dto.setProductName(productName);
				dto.setProductPrice(productPrice);
				dto.setProductCategory(productCategory);
				dto.setPageCnt(pageCnt % 8 == 0 ? pageCnt / 8 : pageCnt / 8 + 1);
				list.add(dto);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
			DbUtil.dbClose(rs2, ps2, con2);
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
	public List<ProductDTO> searchByKeyword(int pageNo, String keyword) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con2 = null;
		PreparedStatement ps2 = null;
		ResultSet rs2 = null;
		int pageCnt = 0;
		String cnt = "SELECT COUNT(*) FROM PRODUCT WHERE (UPPER(PRODUCT_NAME) LIKE UPPER(?) OR PRODUCT_CATEGORY LIKE ?) AND ROWID IN (SELECT MAX(ROWID) FROM PRODUCT GROUP BY PRODUCT_NAME)";
		String sql = "SELECT * FROM (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM PRODUCT WHERE (UPPER(PRODUCT_NAME) LIKE UPPER(?) OR PRODUCT_CATEGORY LIKE ?) AND ROWID IN (SELECT MAX(ROWID) FROM PRODUCT GROUP BY PRODUCT_NAME)) a WHERE ROWNUM <= ?)  WHERE rnum >= ?";
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		try {
			con2 = DbUtil.getConnection();
			ps2 = con2.prepareStatement(cnt);
			ps2.setString(1, "%" + keyword + "%");
			ps2.setString(2, "%" + keyword + "%");
			rs2 = ps2.executeQuery();
			while (rs2.next()) {
				pageCnt = rs2.getInt(1);
			}
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + keyword + "%");
			ps.setString(2, "%" + keyword + "%");
			ps.setInt(3, pageNo * 8);
			ps.setInt(4, (pageNo - 1) * 8 + 1);
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
				product.setPageCnt(pageCnt % 8 == 0 ? pageCnt / 8 : pageCnt / 8 + 1);
				list.add(product);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
			DbUtil.dbClose(rs2, ps2, con2);
		}
		return list;

	}

	@Override
	public List<ProductDTO> selectByKeyValue(int pageNo, String keyword, String value) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		Connection con2 = null;
		PreparedStatement ps2 = null;
		ResultSet rs2 = null;
		int pageCnt = 0;
		String cnt = "SELECT COUNT(*) FROM PRODUCT where ";
		String sql = "SELECT * FROM (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM product ORDER BY PRODUCT_NO ASC";
		if (keyword.equals("PRODUCT_CATEGORY")) {
			cnt+="PRODUCT_PRODUCT_CATEGORY";
			sql+="PRODUCT_PRODUCT_CATEGORY";
		}
		if (keyword.equals("PRODUCT_STOCK")) {
			cnt+="PRODUCT_PRODUCT_STOCK";
			sql+="PRODUCT_PRODUCT_STOCK";
		}
		if (keyword.equals("PRODUCT_NAME")) {
			cnt+="PRODUCT_PRODUCT_NAME";
			sql+="PRODUCT_PRODUCT_NAME";
		}
		cnt+= "LIKE ?";
		sql+= "LIKE ?) a WHERE ROWNUM <= ?)  WHERE rnum >= ?";
		try {
			con2 = DbUtil.getConnection();
			ps2 = con2.prepareStatement(cnt);
			ps2.setString(1, value);
			rs2 = ps2.executeQuery();
			while (rs2.next()) {
				pageCnt = rs2.getInt(1);
			}
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, value);
			ps.setInt(2, pageNo * 8 + 1);
			ps.setInt(3, (pageNo - 1) * 8 + 1);
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
				product.setPageCnt(pageCnt % 8 == 0 ? pageCnt / 8 : pageCnt / 8 + 1);
				list.add(product);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
			DbUtil.dbClose(rs2, ps2, con2);
		}
		return list;
	}
	
	public List<ProductDTO> selectByName(String productName) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		String sql = "SELECT PRODUCT_STOCK, PRODUCT_COLOR, PRODUCT_SIZE, PRODUCT_NO FROM PRODUCT WHERE PRODUCT_NAME = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, productName);
			rs = ps.executeQuery();
			while (rs.next()) {
				ProductDTO productDTO = new ProductDTO();
				productDTO.setProductStock(rs.getInt(1));
				productDTO.setProductColor(rs.getString(2));
				productDTO.setProductSize(rs.getString(3));
				productDTO.setProductNo(rs.getInt(4));
				list.add(productDTO);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}
}