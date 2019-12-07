package nmm.dao;

import java.util.List;

import nmm.dto.ProductDTO;

public interface ProductDAO {
	List<ProductDTO> selectAll(int pageNo) throws Exception;
	
	List<ProductDTO> selectLatest() throws Exception;
	
	List<ProductDTO> selectByCategory(int pageNo, String category) throws Exception;
	
	ProductDTO selectProduct(int productNo) throws Exception;

	int insert(ProductDTO productDTO) throws Exception;
	
	int update(ProductDTO productDTO) throws Exception;

	int delete(int productNo) throws Exception;

	List<ProductDTO> searchByKeyword(int pageNo, String keyword) throws Exception;

	List<ProductDTO> selectByKeyValue(int pageNo, String keyword, String value) throws Exception;
	
	List<ProductDTO> selectByName(String productName) throws Exception;
	
}
