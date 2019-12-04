package nmm.service;

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
      if(user==null) {
         System.out.println("아이디 비번 오류!!!!!!!");
         return null;
      }
      return user;
   }

   public static boolean idCheck(String id) throws Exception {
      UserDAOImpl userdaoimpa = new UserDAOImpl();
      userdaoimpa.idCheck(id);
      return false;
   }
}