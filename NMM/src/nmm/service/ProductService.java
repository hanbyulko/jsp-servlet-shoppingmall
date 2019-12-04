package nmm.service;

import java.util.List;

import nmm.dao.ProductDAO;
import nmm.dao.ProductDAOImpl;
import nmm.dto.ProductDTO;

public class ProductService {
	private static ProductDAO productDAO  = new ProductDAOImpl();
	
	public static List<List<ProductDTO>> selectAll() throws Exception{
		List<List<ProductDTO>> list = productDAO.selectAll();
		return list;
	}
	
	public static List<ProductDTO> selectLatest() throws Exception{
		List<ProductDTO> list = productDAO.selectLatest();
		return list;
	}
	
	public static List<ProductDTO> selectJacket() throws Exception{
		List<ProductDTO> list = productDAO.selectJacket();
		return list;
	}
	public static List<ProductDTO> selectCoat() throws Exception{
		List<ProductDTO> list = productDAO.selectCoat();
		return list;
	}
	public static List<ProductDTO> selectPadding() throws Exception{
		List<ProductDTO> list = productDAO.selectPadding();
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
	
	
	
}
