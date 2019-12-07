package nmm.service;

import java.util.List;

import nmm.dao.ProductDAO;
import nmm.dao.ProductDAOImpl;
import nmm.dto.ProductDTO;

public class ProductService {
	private static ProductDAO productDAO  = new ProductDAOImpl();
	
	public static List<ProductDTO> selectAll(int pageNo) throws Exception{
		List<ProductDTO> list = productDAO.selectAll(pageNo);
		return list;
	}
	
	public static List<ProductDTO> selectLatest() throws Exception{
		List<ProductDTO> list = productDAO.selectLatest();
		return list;
	}
	
	public static List<ProductDTO> selectByCategory(int pageNo, String category) throws Exception{
		List<ProductDTO> list = productDAO.selectByCategory(pageNo, category);
		return list;
	}
	public static ProductDTO selectProduct(int productNo) throws Exception{
		ProductDTO product = productDAO.selectProduct(productNo);
		return product;
	}

	public static void insert(ProductDTO productDTO) throws Exception {
		productDAO.insert(productDTO);
	}

	public static void delete(int productNo) throws Exception {
		productDAO.delete(productNo);
	}

	public static void update(ProductDTO dto) throws Exception {
		productDAO.update(dto);
	}

	public static List<ProductDTO> searchByKeyword(int pageNo, String keyword) throws Exception {
		return productDAO.searchByKeyword(pageNo, keyword);
	}

	public static List<ProductDTO> selectByKeyValue(int pageNo, String keyword, String value) throws Exception{
		return productDAO.selectByKeyValue(pageNo, keyword, value);
	}
	
	public static List<ProductDTO> selectByName(String productName) throws Exception{
		return productDAO.selectByName(productName);
	}
}
