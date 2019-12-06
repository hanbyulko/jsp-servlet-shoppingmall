package nmm.service;

import java.util.List;

import nmm.dao.ManagerUserDAO;
import nmm.dao.ManagerUserDAOImpl;
import nmm.dto.ManagerUserDTO;

public class ManagerUserService {
private static ManagerUserDAO dao = new ManagerUserDAOImpl();
	
	public static boolean login(String mgtUserId, String mgtUserPw) throws Exception{
		ManagerUserDAOImpl managerUserDAOImpl = new ManagerUserDAOImpl();
		ManagerUserDTO managerUserDTO = managerUserDAOImpl.login(mgtUserId, mgtUserPw);
		if (managerUserDTO==null) {
			return false;
		}
		if(mgtUserId.equals(managerUserDTO.getMgtUserId())||mgtUserPw.equals(managerUserDTO.getMgtUserPwd())) {
			return true;
		}
		return false;
	}
	
	public static List<ManagerUserDTO> selectAll() throws Exception {
		return dao.selectAll();
	}
	
	public static String selectById(String mgtUserId) throws Exception {
		return dao.selectById(mgtUserId);
	}
	
	public static int insert(ManagerUserDTO dto) throws Exception {
		return dao.insert(dto);
	}
	
	public static int update(ManagerUserDTO dto) throws Exception {
		return dao.update(dto);
	}
	
	public static int delete(int mgtUserNo) throws Exception {
		return dao.delete(mgtUserNo);
	}
}
