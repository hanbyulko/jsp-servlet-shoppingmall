package nmm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nmm.dto.CartDTO;
import nmm.dto.ProductDTO;
import nmm.dto.UserDTO;
import nmm.util.DbUtil;

public class CartDAOImpl implements CartDAO {

	@Override
	public List<CartDTO> selectAll(int userCode, int pageNo) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		Connection con2 = null;
		PreparedStatement ps2 = null;
		ResultSet rs2 = null;
		int pageCnt = 0;
		String cnt = "SELECT COUNT(*) FROM CART C INNER JOIN PRODUCT P ON c.product_no = p.product_no LEFT OUTER JOIN USERDB U ON c.user_no = u.user_no where u.user_no = ?";
		String sql = "SELECT * FROM (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM CART C INNER JOIN PRODUCT P ON c.product_no = p.product_no LEFT OUTER JOIN USERDB U ON c.user_no = u.user_no where u.user_no = ?) a WHERE ROWNUM <= ?) WHERE rnum >= ?";
		List<CartDTO> list = new ArrayList<CartDTO>();
		try {
			con2 = DbUtil.getConnection();
			ps2 = con2.prepareStatement(cnt);
			ps2.setInt(1, userCode);
			rs2 = ps2.executeQuery();
			while (rs2.next()) {
				pageCnt = rs2.getInt(1);
			}
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userCode);
			ps.setInt(2, pageNo * 8 + 1);
			ps.setInt(3, (pageNo - 1) * 8 + 1);
			rs = ps.executeQuery();
			while (rs.next()) {
				int cartNo = rs.getInt("CART_NO");
				int productNo = rs.getInt("PRODUCT_NO");
				int cartQty = rs.getInt("CART_QTY");
				String category = rs.getString("PRODUCT_CATEGORY");
				int stock = rs.getInt("PRODUCT_STOCK");
				String productName = rs.getString("PRODUCT_NAME");
				String productColor = rs.getString("PRODUCT_COLOR");
				String productSize = rs.getString("PRODUCT_SIZE");
				int price = rs.getInt("PRODUCT_PRICE");
				String userPwd = rs.getString("USER_PWD");
				String userId = rs.getString("USER_ID");
				String userName = rs.getString("USER_NAME");
				String userBirth = rs.getString("USER_BIRTHDATE");
				String userPhone = Integer.toString(rs.getInt("USER_PHONE"));
				String userAddr = rs.getString("USER_ADDR");
				String userEmail = rs.getString("USER_EMAIL");
				String productResiDate = rs.getString("PRODUCT_RESIDATE");
				UserDTO userDTO = new UserDTO(userCode, userId, userPwd, userName, userBirth, userPhone, userAddr,
						userEmail);
				ProductDTO productDTO = new ProductDTO();
				productDTO.setProductNo(productNo);
				productDTO.setProductCategory(category);
				productDTO.setProductStock(stock);
				productDTO.setProductName(productName);
				productDTO.setProductColor(productColor);
				productDTO.setProductSize(productSize);
				productDTO.setProductPrice(price);
				productDTO.setProductResiDate(productResiDate);
				CartDTO dto = new CartDTO();
				dto.setCartNo(cartNo);
				dto.setUserDTO(userDTO);
				dto.setProductDTO(productDTO);
				dto.setCartQty(cartQty);
				dto.setPageCnt(pageCnt % 8 == 0 ? pageCnt / 8 : pageCnt / 8 + 1);
				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;

	}

	@Override
	public int insert(int cartNo, int userNo, int productNo, int cartQty) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "INSERT INTO CART VALUES(?, ?, ?, ?)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, cartNo);
			ps.setInt(2, userNo);
			ps.setInt(3, productNo);
			ps.setInt(4, cartQty);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int update(int cartNo, int userNo, int productNo, int cartQty) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "UPDATE CART SET cart_qty = ? , product_no = ? WHERE USER_NO = ? AND CART_NO = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, cartQty);
			ps.setInt(2, productNo);
			ps.setInt(3, userNo);
			ps.setInt(4, cartNo);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;

	}

	@Override
	public int delete(int cartNo, int userNo) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "delete from cart where cart_no = ? and user_no = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, cartNo);
			ps.setInt(2, userNo);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

}
