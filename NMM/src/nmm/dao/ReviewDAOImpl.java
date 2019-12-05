package nmm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import nmm.dto.ProductDTO;
import nmm.dto.ReviewDTO;
import nmm.util.DbUtil;

public class ReviewDAOImpl implements ReviewDAO {

   @Override
   public List<ReviewDTO> selectAll(int productNo) throws Exception {
      Connection con = null;
      PreparedStatement ps = null;
      ResultSet rs = null;
      List<ReviewDTO> list = new ArrayList<>();
      ProductDTO productDTO = null;
      String sql = "SELECT PRODUCT_NO, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_COLOR, PRODUCT_SIZE, REVIEW_NO, REVIEW_TITLE, REVIEW_CONTENT, REVIEW_STAR, REVIEW_DATE FROM VIEW_PRODUCTANDREVIEW WHERE PRODUCT_NO=?";
      
      try {
         con = DbUtil.getConnection();
         ps = con.prepareStatement(sql);
         ps.setInt(1, productNo);
         rs = ps.executeQuery();
         
         
         while(rs.next()) {
        	productNo = rs.getInt(1);
     		String productName = rs.getString(2);
         	int productPrice = rs.getInt(3);
         	String productColor = rs.getString(4);
         	String productSize = rs.getString(5);
         	productDTO = new ProductDTO();
         	productDTO.setProductNo(productNo);
         	productDTO.setProductName(productName);
         	productDTO.setProductPrice(productPrice);
         	productDTO.setProductColor(productColor);
         	productDTO.setProductSize(productSize);
	        int reviewNo = rs.getInt(6);
	            //reviewDTO.setProductDTO(productDTO);
	        String reviewTitle= rs.getString(7);
	        String reviewContent = rs.getString(8);
	        String reviewStar = rs.getString(9);
	        String reviewDate = rs.getString(10);
	            
	        list.add(new ReviewDTO(productDTO, reviewNo, reviewTitle, reviewContent, reviewStar, reviewDate));
         }
 	 	
     }catch (Exception e) {
			e.printStackTrace();
	 }finally {
	         DbUtil.dbClose(rs, ps, con);
     }
      return list;

   }

   @Override
   public int insert(int userNo, int productNo, ReviewDTO dto) throws Exception {
      Connection con = null;
      PreparedStatement ps = null;
      int result = 0;
      String sql = "INSERT INTO REVIEW (PRODUCT_NO, REVIEW_NO, REVIEW_TITLE,REVIEW_CONTENT,REVIEW_STAR, REVIEW_DATE) VALUES(?, REVIEW_NO_SEQ.NEXTVAL,?,?,?,SYSDATE)";
      try {
         con = DbUtil.getConnection();
         ps = con.prepareStatement(sql);
         ps.setInt(1, productNo);
         ps.setString(2, dto.getReviewTitle());
         ps.setString(3, dto.getReviewContent());
         ps.setString(4, dto.getReviewStar());
         result = ps.executeUpdate();
      } finally {
         DbUtil.dbClose(ps, con);
      }
      // System.out.println(result);
      return result;
   }

   @Override
   public int update(ReviewDTO dto) throws Exception {
      Connection con = null;
      PreparedStatement ps = null;
      int result = 0;
      String sql = "UPDATE REVIEW SET REVIEW_TITLE=?, REVIEW_CONTENT=?, REVIEW_STAR=? WHERE REVIEW_NO=?";
      try {
         con = DbUtil.getConnection();
         ps = con.prepareStatement(sql);
         ps.setString(1, dto.getReviewTitle());
         ps.setString(2, dto.getReviewContent());
         ps.setString(3, dto.getReviewStar());
         ps.setInt(4, dto.getReviewNo());
         result = ps.executeUpdate();
         result = ps.executeUpdate();
      } finally {
         DbUtil.dbClose(ps, con);
      }
      return result;
   }

   
   
   @Override
   public int delete(int reviewNo) throws Exception {
      Connection con = null;
      PreparedStatement ps = null;
      String sql = "delete from REVIEW where REVIEW_NO=?";
      int result= 0;
      try {
         con = DbUtil.getConnection();
         ps = con.prepareStatement(sql);
         ps.setInt(1, reviewNo);
         result = ps.executeUpdate();
      } finally {
         DbUtil.dbClose(ps, con);
      }
      return result;
   }

   @Override
   public List<ProductDTO> selectTop() throws Exception {
      Connection con = null;
      PreparedStatement ps = null;
      ResultSet rs = null;
      String sql = "SELECT PRODUCT_NO, COUNT(*) AS CNT FROM REVIEW GROUP BY PRODUCT_NO ORDER BY CNT DESC";
      List<Integer> productList = new ArrayList<>();
      List<ProductDTO> list = new ArrayList<>();
      try {
         con = DbUtil.getConnection();
         ps = con.prepareStatement(sql);
         rs = ps.executeQuery();
         ps.clearParameters();  
         for (int i=0; i<4; i++) {
            rs.next();
            productList.add(rs.getInt("PRODUCT_NO"));
         }
         String sql2 = "SELECT PRODUCT_NO, PRODUCT_NAME, PRODUCT_PRICE FROM PRODUCT WHERE PRODUCT_NO IN(?,?,?,?)";
         ps = con.prepareStatement(sql2);
         ps.setInt(1, productList.get(0));
         ps.setInt(2, productList.get(1));
         ps.setInt(3, productList.get(2));
         ps.setInt(4, productList.get(3));
         rs = ps.executeQuery();
         for (int i=0; i<4; i++) {
            rs.next();
            ProductDTO dto = new ProductDTO();
            dto.setProductNo(rs.getInt(1));
            dto.setProductName(rs.getString(2));
            dto.setProductPrice(rs.getInt(3));
            list.add(dto);
         }
      } finally {
         DbUtil.dbClose(rs, ps, con);
      }
      return list;
   }
}