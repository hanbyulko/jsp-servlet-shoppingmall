package nmm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import nmm.dto.UserDTO;
import nmm.util.DbUtil;

public class UserDAOImpl implements UserDAO {

   @Override
   public int insert(UserDTO dto) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;
        System.out.println(dto);
        int result=0;
        try {
         con = DbUtil.getConnection();
         ps = con.prepareStatement("INSERT INTO USERDB VALUES(USER_NO_SEQ.NEXTVAL,?,?,?,?,?,?,?)");
         ps.setString(1, dto.getUserPwd());
         ps.setString(2, dto.getUserId());
         ps.setString(3, dto.getUserName());
         ps.setString(4, dto.getUserBirth());
         ps.setString(5, dto.getUserPhone());
         ps.setString(6, dto.getUserAddr());
         ps.setString(7, dto.getUserEmail());
         result = ps.executeUpdate();
         
        } catch (SQLException e) {
         e.printStackTrace();
        } finally {
         DbUtil.dbClose( ps, con);
        }
        return result;
   }

   @Override
   public int update(UserDTO dto) throws Exception {
      Connection con= null;
      PreparedStatement ps = null;
      String sql="UPDATE USERDB SET USER_PWD=? , USER_NAME=? , USER_ADDR=? , USER_PHONE=? , USER_EMAIL=? WHERE USER_ID=?";
      System.out.println(dto);
      try {
         con = DbUtil.getConnection();
         ps = con.prepareStatement(sql);
         
         ps.setString(1, dto.getUserPwd());
         ps.setString(2, dto.getUserName());
         ps.setString(3, dto.getUserAddr());
         ps.setString(4, dto.getUserPhone());
         ps.setString(5, dto.getUserEmail());
         ps.setString(6, dto.getUserId());
      }catch (SQLException e) {
         e.printStackTrace();
      }finally {
      }
      return ps.executeUpdate();
   }

   @Override
   public int delete(String userId)throws Exception  {
      Connection con= null;
      PreparedStatement ps = null;
      String sql = "DELETE USERDB WHERE upper(USER_ID)=upper(?)";
      int result = 0;
      try {
         con = DbUtil.getConnection();
         ps = con.prepareStatement(sql);
         ps.setString(1, userId.trim());
         result=ps.executeUpdate();
         
      }catch (SQLException e) {
         e.printStackTrace();
      }finally {
         DbUtil.dbClose(ps, con);
      }
      System.out.println(result);
      return result;
   }

   @Override
   public UserDTO loginCheck(String userId, String userPwd)throws SQLException  {
      Connection con = null;
      PreparedStatement ps = null;
      String sql = "select USER_NO,USER_ID,USER_PWD from USERDB where upper(user_id) = upper(?) ";
      ResultSet rs =null;
      try {
         con = DbUtil.getConnection();
         ps = con.prepareStatement(sql);
         ps.setString(1, userId);
         UserDTO user1 = null;
         rs = ps.executeQuery();  //  ����Ŭ�� app������ ����
         while(rs.next()) {
            user1 = new UserDTO(rs.getInt(1),rs.getString(2),rs.getString(3));
         }
         return user1;
      }finally {
         DbUtil.dbClose(rs, ps, con);
      }
   }

   public boolean idCheck(String id) throws SQLException {
      Connection con = null;
      PreparedStatement ps = null;
      String sql = "select USER_ID from USERDB where upper(user_id) = upper(?) ";
      ResultSet rs =null;
      boolean user = false;
      System.out.println(user);
      try {
         con = DbUtil.getConnection();
         ps = con.prepareStatement(sql);
         ps.setString(1, id);
         rs = ps.executeQuery();  //  ����Ŭ�� app������ ����
         while(rs.next()) {
        	 user=true;
         }
         return user;
      }finally {
         DbUtil.dbClose(rs, ps, con);
      }

   }

}