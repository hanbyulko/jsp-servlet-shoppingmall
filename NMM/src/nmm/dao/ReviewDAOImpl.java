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
      //String sql = "SELECT USER_ID, PRODUCT_NO, REVIEW_NO, REVIEW_TITLE, REVIEW_CONTENT, REVIEW_STAR, REVIEW_DATE FROM REVIEWJOIN WHERE PRODUCT_NO=?";
      String sql = "SELECT REVIEW_NO, REVIEW_TITLE, REVIEW_CONTENT, REVIEW_STAR, REVIEW_DATE FROM REVIEW WHERE PRODUCT_NO=?";
      try {
         con = DbUtil.getConnection();
         ps = con.prepareStatement(sql);
         ps.setInt(1, productNo);
         rs = ps.executeQuery();
         while (rs.next()) {
            /*
             * ReviewDTO reviewDTO = new ReviewDTO(rs.getString(1), rs.getInt(2),
             * rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
             */
            //ProductDTO productDTO = new ProductDTO();
            ReviewDTO reviewDTO = new ReviewDTO();
            reviewDTO.setReviewNo(rs.getInt(1));
            //reviewDTO.setProductDTO(productDTO);
            reviewDTO.setReviewTitle(rs.getString(2));
            reviewDTO.setReviewContent(rs.getString(3));
            reviewDTO.setReviewStar(rs.getString(4));
            reviewDTO.setReviewDate(rs.getString(5));
            list.add(reviewDTO);
         }
         //System.out.println(list);
      } finally {
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
            list.add(new ProductDTO(rs.getInt(1), rs.getString(2), rs.getInt(3)));
         }
      } finally {
         DbUtil.dbClose(rs, ps, con);
      }
      return list;
   }
}