package nmm.service;

import java.util.List;

import nmm.dao.CartDAO;
import nmm.dao.CartDAOImpl;
import nmm.dto.CartDTO;

public class CartService {
	private static CartDAO dao = new CartDAOImpl();
	
	
	public static List<CartDTO> selectAll(int userNo, int pageNo) throws Exception{
		return dao.selectAll(userNo, pageNo);
	}
	
	public static int insert(int cartNo, int userNo, int productNo, int cartQty) throws Exception {
		int result = dao.insert(cartNo, userNo, productNo, cartQty);
		return result;
	}
	
	public static int update(int cartNo, int userNo, int productNo, int cartQty) throws Exception {
		int result = dao.update(cartNo, cartQty, productNo, cartQty);
		return result;
	}
	
	public static int delete(int cartNo, int userNo) throws Exception {
		int result = dao.delete(cartNo, userNo);
		return result;
	}
}
