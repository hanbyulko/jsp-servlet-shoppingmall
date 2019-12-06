package nmm.dao;

import java.util.List;

import nmm.dto.CartDTO;

public interface CartDAO {
   
   List<CartDTO> selectAll(int userCode);
   
   int insert(int userNo, int productNo, int cartQty) throws Exception;
   
   int update(int cartNo, int cartQty) throws Exception;
   
   int delete(int cartNo) throws Exception;

}