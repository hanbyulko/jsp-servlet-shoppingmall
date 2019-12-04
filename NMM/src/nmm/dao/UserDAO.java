package nmm.dao;

import nmm.dto.UserDTO;

public interface UserDAO {
	int insert(UserDTO dto) throws Exception;

	int update(UserDTO dto) throws Exception;

	int delete(String userId) throws Exception;

	UserDTO loginCheck(String userId, String userPwd) throws Exception;
}
