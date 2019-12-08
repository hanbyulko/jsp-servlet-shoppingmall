package nmm.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import nmm.dao.UserDAO;
import nmm.dao.UserDAOImpl;
import nmm.dto.UserDTO;

public class UserService {
	private static UserDAO dao = new UserDAOImpl();
	private static HttpSession session = null;

	public static int insert(UserDTO dto) throws Exception {
		UserDAOImpl userdaoimpl = new UserDAOImpl();
		userdaoimpl.insert(dto);

		return 0;
	}

	public static int update(UserDTO dto) throws Exception {
		UserDAOImpl userdaoimpl = new UserDAOImpl();
		int result = userdaoimpl.update(dto);
		return result;
	}

	public static int delete(String id) throws Exception {
		UserDAOImpl userdaoimpl = new UserDAOImpl();
		int result = userdaoimpl.delete(id);
		return result;
	}

	public static UserDTO loginCheck(String userId, String userPwd) throws Exception {
		UserDAOImpl userdaoimpa = new UserDAOImpl();
		UserDTO user = userdaoimpa.loginCheck(userId, userPwd);
		if (user == null) {
			System.out.println("占쏙옙占싱듸옙 占쏙옙占� 占쏙옙占쏙옙!!!!!!!");
			return null;
		} else if (userId.equals(user.getUserId()) & userPwd.equals(user.getUserPwd())) {
			return user;
		} else {
			return null;
		}
	}

	public static boolean idCheck(String id) throws Exception {
		UserDAOImpl userdaoimpa = new UserDAOImpl();
		return userdaoimpa.idCheck(id);

	}

	public static List<UserDTO> selectAll(int pageNo) throws Exception {
		return dao.selectAll(pageNo);
	}

	public static List<UserDTO> selectByKeyword(int pageNo, String keyword, String value) throws Exception{
		return dao.selectByKeyword(pageNo, keyword, value);
	}
	
	public static UserDTO selectByUserNo(int userNo) throws Exception{
		return dao.selectByUserNo(userNo);
	}
}