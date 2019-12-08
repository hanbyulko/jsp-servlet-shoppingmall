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
      public List<CartDTO> selectAll(int userCode) {
         System.out.println(userCode);
           Connection con = null;
           PreparedStatement ps = null;
           ResultSet rs = null;
           String sql = "SELECT * FROM CART C INNER JOIN PRODUCT P ON c.product_no = p.product_no " + 
                 "LEFT OUTER JOIN USERDB U ON c.user_no = u.user_no where u.user_no = ?";
           List<CartDTO> list = new ArrayList<CartDTO>();
           try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, userCode);
            rs  = ps.executeQuery();
           
            while(rs.next()){
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
               int userPhone = rs.getInt("USER_PHONE");
               String userAddr = rs.getString("USER_ADDR");
               String userEmail = rs.getString("USER_EMAIL");
               String productResiDate = rs.getString("PRODUCT_RESIDATE");
               UserDTO userDTO = new UserDTO();
               		userDTO.setUserNo(userCode);
               		userDTO.setUserId(userId);
               		userDTO.setUserPwd(userPwd);
               		userDTO.setUserName(userName);
               		userDTO.setUserPhone(userPhone);
               		userDTO.setUserBirth(userBirth);
               		userDTO.setUserEmail(userEmail);
               		userDTO.setUserAddr(userAddr);
               		userDTO.setUserEmail(userEmail);
               ProductDTO productDTO = new ProductDTO();
                  productDTO.setProductNo(productNo);
                  productDTO.setProductCategory(category);
                  productDTO.setProductStock(stock);
                  productDTO.setProductName(productName);
                  productDTO.setProductColor(productColor);
                  productDTO.setProductSize(productSize);
                  productDTO.setProductPrice(price);
                  productDTO.setProductResiDate(productResiDate);
               list.add(new CartDTO(cartNo, userDTO, productDTO, cartQty));
            }

           } catch (SQLException e) {
            e.printStackTrace();
           } finally {
            DbUtil.dbClose(rs, ps, con);
           }
           return list;
           
      }


   @Override
   public int insert(int userNo, int productNo, int cartQty) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;
        String sql = "INSERT INTO CART VALUES(CART_SEQ.NEXTVAL, ?, ?, ?)";
        
        try {
         con = DbUtil.getConnection();
         ps = con.prepareStatement(sql);
         ps.setInt(1, userNo);
         ps.setInt(2, productNo);
         ps.setInt(3, cartQty);
         result  = ps.executeUpdate();
        } catch (SQLException e) {
         e.printStackTrace();
        } finally {
         DbUtil.dbClose(ps, con);
        }
        return result;
   }

   @Override
   public int update(int cartNo, int cartQty) throws Exception{
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;
        String sql = "UPDATE CART SET cart_qty = ? WHERE CART_NO = ?";
        try {
         con = DbUtil.getConnection();
         ps = con.prepareStatement(sql);
         ps.setInt(1, cartQty);
         ps.setInt(2, cartNo);
         result  = ps.executeUpdate();
        } catch (SQLException e) {
         e.printStackTrace();
        } finally {
         DbUtil.dbClose(ps, con);
        }
        return result;

   }

   @Override
   public int delete(int cartNo) throws Exception{
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;
        String sql = "delete from cart where cart_no = ?";
        try {
         con = DbUtil.getConnection();
         ps = con.prepareStatement(sql);
         ps.setInt(1, cartNo);
         result  = ps.executeUpdate();
        } catch (SQLException e) {
         e.printStackTrace();
        } finally {
         DbUtil.dbClose(ps, con);
        }
        return result;
   }
   
   

}