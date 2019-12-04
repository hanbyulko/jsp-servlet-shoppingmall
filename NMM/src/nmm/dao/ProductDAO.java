package nmm.dao;

import java.util.List;

import nmm.dto.ProductDTO;

public interface ProductDAO {
	List<List<ProductDTO>> selectAll() throws Exception;
	
	List<ProductDTO> selectLatest() throws Exception;
	
	List<ProductDTO> selectPopular() throws Exception;
	
	List<ProductDTO> selectJacket() throws Exception;
	
	List<ProductDTO> selectCoat() throws Exception;
	
	List<ProductDTO> selectPadding() throws Exception;
	
	ProductDTO selectProduct(int productNo) throws Exception;

	int insert(ProductDTO productDTO) throws Exception;
	
	int update(ProductDTO productDTO) throws Exception;

	int delete(int productNo) throws Exception;
}
