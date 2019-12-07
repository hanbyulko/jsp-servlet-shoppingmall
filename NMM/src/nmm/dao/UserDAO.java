package nmm.dao;

import java.util.List;

import nmm.dto.ProductDTO;
import nmm.dto.UserDTO;

public interface UserDAO {
	int insert(UserDTO dto) throws Exception;

	int update(UserDTO dto) throws Exception;

	int delete(String userId) throws Exception;

	UserDTO loginCheck(String userId, String userPwd) throws Exception;

	List<UserDTO> selectAll(int pageNo) throws Exception;

	List<UserDTO> selectByKeyword(int pageNo, String keyword, String value) throws Exception;

	UserDTO selectByUserNo(int userNo) throws Exception;
}
