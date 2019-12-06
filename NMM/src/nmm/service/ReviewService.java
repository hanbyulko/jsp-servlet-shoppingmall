package nmm.service;

import java.util.List;

import nmm.dao.ReviewDAO;
import nmm.dao.ReviewDAOImpl;
import nmm.dto.ProductDTO;
import nmm.dto.ReviewDTO;

public class ReviewService {

   private static ReviewDAO dao = new ReviewDAOImpl();

   public static List<ReviewDTO> selectAll(int pageNo) throws Exception {
	      return dao.selectAll(pageNo);
	   }
   
   public static List<ReviewDTO> selectUser(int pageNo, int productNo) throws Exception {
      return dao.selectUser(pageNo, productNo);
   }

   public static int insert(int userNo, int productNo, ReviewDTO dto) throws Exception {
      return dao.insert(userNo, productNo, dto);
   }

   public static int update(ReviewDTO dto) throws Exception {
      return dao.update(dto);
   }

   public static int delete(int reviewNo) throws Exception {
      return dao.delete(reviewNo);
   }

   public static List<ProductDTO> selectTop() throws Exception {
      List<ProductDTO> list = dao.selectTop();
      return list;
   }
}