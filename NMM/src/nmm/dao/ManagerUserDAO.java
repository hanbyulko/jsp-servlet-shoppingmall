package nmm.dao;

import java.util.List;

import nmm.dto.ManagerUserDTO;

public interface ManagerUserDAO {
	ManagerUserDTO login(String mgtUserId, String mgtUserPw) throws Exception;
	
	List<ManagerUserDTO> selectAll() throws Exception;
	
	String selectById(String mgtUserId) throws Exception;
	
	int insert(ManagerUserDTO dto) throws Exception;
	int update(ManagerUserDTO dto) throws Exception;
	int delete(int mgtUserNo) throws Exception;
}
