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
                "left outer join PRODUCT P on pur.PRODUCT_NO = P.PRODUCT_NO where u.USER_NO=?;";
        List<PurchaseDTO> list = new ArrayList<>();
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, userNo);
            rs  = ps.executeQuery();

            while(rs.next()){
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
                String category = rs.getString("PRODUCT_CATEGORY");
                int stock = rs.getInt("PRODUCT_STOCK");
                String productName = rs.getString("PRODUCT_NAME");
                String productColor = rs.getString("PRODUCT_COLOR");
                String productSize = rs.getString("PRODUCT_SIZE");
                int price = rs.getInt("PRODUCT_PRICE");
                String productResiDate = rs.getString("PRODUCT_RESI_DATE");


                UserDTO userDTO = new UserDTO(userNo, userName, userId, userPwd, userAddr, userPhone, userEmail, userBirth);
                ProductDTO productDTO = new ProductDTO();
                productDTO.setProductNo(productNo);
                productDTO.setProductCategory(category);
                productDTO.setProductStock(stock);
                productDTO.setProductName(productName);
                productDTO.setProductColor(productColor);
                productDTO.setProductSize(productSize);
                productDTO.setProductPrice(price);
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

    @Override
    public List<PurchaseDTO> selectAllHistory(int userNo) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from PURCHASEDB pur inner join USERDB u on pur.USER_NO = u.USER_NO " +
                "left outer join PRODUCT P on pur.PRODUCT_NO = P.PRODUCT_NO where u.USER_NO=?;";
        List<PurchaseDTO> list = new ArrayList<>();
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, userNo);
            rs  = ps.executeQuery();

            while(rs.next()){
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
                String category = rs.getString("PRODUCT_CATEGORY");
                int stock = rs.getInt("PRODUCT_STOCK");
                String productName = rs.getString("PRODUCT_NAME");
                String productColor = rs.getString("PRODUCT_COLOR");
                String productSize = rs.getString("PRODUCT_SIZE");
                int price = rs.getInt("PRODUCT_PRICE");
                String productResiDate = rs.getString("PRODUCT_RESI_DATE");


                UserDTO userDTO = new UserDTO(userNo, userName, userId, userPwd, userAddr, userPhone, userEmail, userBirth);
                ProductDTO productDTO = new ProductDTO();
                productDTO.setProductNo(productNo);
                productDTO.setProductCategory(category);
                productDTO.setProductStock(stock);
                productDTO.setProductName(productName);
                productDTO.setProductColor(productColor);
                productDTO.setProductSize(productSize);
                productDTO.setProductPrice(price);
                productDTO.setProductResiDate(productResiDate);
                list.add(new PurchaseDTO(purNo,userDTO,productDTO,purQty,purDate,purStat));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.dbClose(rs, ps, con);
        }

        return list;
    }
}