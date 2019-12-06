package nmm.dao;

import nmm.dto.ProductDTO;
import nmm.dto.PurchaseDTO;
import nmm.dto.UserDTO;
import nmm.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PurchasesDAOImpl implements PurchasesDAO {
    @Override
    public List<PurchaseDTO> selectAllPurchase(int userNo) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from PURCHASEDB pur inner join USERDB u on pur.USER_NO = u.USER_NO " +
                "left outer join PRODUCT P on pur.PRODUCT_NO = P.PRODUCT_NO where u.USER_NO=?";
        List<PurchaseDTO> list = new ArrayList<>();
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, userNo);
            rs  = ps.executeQuery();

            while(rs.next()){
            	ProductDTO productDTO = new ProductDTO();
                int purNo = rs.getInt("PURCHASE_NO");
                int productNo = rs.getInt("PRODUCT_NO");
                int purQty = rs.getInt("PURCHASE_QTY");
                String purDate = rs.getString("PURCHASE_DATE");
                String purStat = rs.getString("PURCHASE_STATUS");
                String userId = rs.getString("USER_ID");
                String userPwd = rs.getString("USER_PWD");
                String userName = rs.getString("USER_NAME");
                String userBirth = rs.getString("USER_BIRTHDATE");
                String userPhone = Integer.toString(rs.getInt("USER_PHONE"));
                String userAddr = rs.getString("USER_ADDR");
                String userEmail = rs.getString("USER_EMAIL");
                String productCategory = rs.getString("PRODUCT_CATEGORY");
                int productStock = rs.getInt("PRODUCT_STOCK");
                String productName = rs.getString("PRODUCT_NAME");
                String productColor = rs.getString("PRODUCT_COLOR");
                String productSize = rs.getString("PRODUCT_SIZE");
                int productPrice = rs.getInt("PRODUCT_PRICE");
                String productResiDate = rs.getString("PRODUCT_RESIDATE");


                UserDTO userDTO = new UserDTO(userId, userPwd, userName, userAddr, userPhone, userEmail, userBirth);
                productDTO.setProductNo(productNo);
                productDTO.setProductCategory(productCategory);
                productDTO.setProductStock(productStock);
                productDTO.setProductName(productName);
                productDTO.setProductColor(productColor);
                productDTO.setProductSize(productSize);
                productDTO.setProductPrice(productPrice);
                productDTO.setProductResiDate(productResiDate);
                list.add(new PurchaseDTO(purNo,userDTO,productDTO,purQty,purDate,purStat));
//
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.dbClose(rs, ps, con);
        }

        return list;
    }
    //�����ϸ� 1 �ƴϸ� 0
    @Override
    public int insert(int userNo, int productNo, int qty) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;
        String sql = "INSERT INTO PURCHASEDB VALUES(PURCHASE_NO_SEQ.NEXTVAL,?, ?, ?,sysdate,'����غ���')";
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, userNo);
            ps.setInt(2, productNo);
            ps.setInt(3, qty);

            result  = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.dbClose(ps, con);
        }
        return result;
    }

    @Override
    public List<PurchaseDTO> selectAllHistory(int userNo) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from PURCHASEDB pur inner join USERDB u on pur.USER_NO = u.USER_NO " +
                "left outer join PRODUCT P on pur.PRODUCT_NO = P.PRODUCT_NO where u.USER_NO=?";
        List<PurchaseDTO> list = new ArrayList<>();
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, userNo);
            rs  = ps.executeQuery();

            while(rs.next()){
            	ProductDTO productDTO = new ProductDTO();
            	
                int purNo = rs.getInt("PURCHASE_NO");
                int productNo = rs.getInt("PRODUCT_NO");
                int purQty = rs.getInt("PURCHASE_QTY");
                String purDate = rs.getString("PURCHASE_DATE");
                String purStat = rs.getString("PURCHASE_STATUS");
                String userId = rs.getString("USER_ID");
                String userPwd = rs.getString("USER_PWD");
                String userName = rs.getString("USER_NAME");
                String userBirth = rs.getString("USER_BIRTHDATE");
                String userPhone = Integer.toString(rs.getInt("USER_PHONE"));
                String userAddr = rs.getString("USER_ADDR");
                String userEmail = rs.getString("USER_EMAIL");
                String productCategory = rs.getString("PRODUCT_CATEGORY");
                int productStock = rs.getInt("PRODUCT_STOCK");
                String productName = rs.getString("PRODUCT_NAME");
                String productColor = rs.getString("PRODUCT_COLOR");
                String productSize = rs.getString("PRODUCT_SIZE");
                int productPrice = rs.getInt("PRODUCT_PRICE");
                String productResiDate = rs.getString("PRODUCT_RESIDATE");

                UserDTO userDTO = new UserDTO(userId, userPwd, userName, userAddr, userPhone, userEmail, userBirth);
                productDTO.setProductNo(productNo);
                productDTO.setProductCategory(productCategory);
                productDTO.setProductStock(productStock);
                productDTO.setProductName(productName);
                productDTO.setProductColor(productColor);
                productDTO.setProductSize(productSize);
                productDTO.setProductPrice(productPrice);
                productDTO.setProductResiDate(productResiDate);
                
                list.add(new PurchaseDTO(purNo,userDTO,productDTO,purQty,purDate,purStat));
//
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.dbClose(rs, ps, con);
        }

        return list;
    }
}
