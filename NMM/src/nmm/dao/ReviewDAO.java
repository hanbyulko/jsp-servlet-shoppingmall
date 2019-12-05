package nmm.dao;

import java.util.List;

import nmm.dto.ProductDTO;
import nmm.dto.ReviewDTO;

public interface ReviewDAO {
	
	List<ReviewDTO> selectUser(int pageNo, int productNo) throws Exception;
	List<ReviewDTO> selectAll(int pageNo) throws Exception;
	
	int insert(int userNo, int productNo, ReviewDTO dto) throws Exception;
	   
	int update(ReviewDTO dto) throws Exception;

	List<ProductDTO> selectTop() throws Exception;
	   
	int delete(int reviewNo) throws Exception;
	
	}