package nmm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nmm.dto.ManagerUserDTO;
import nmm.dto.ProductDTO;
import nmm.dto.QnaDTO;
import nmm.dto.UserDTO;
import nmm.util.DbUtil;

public class ManagerUserDAOImpl implements ManagerUserDAO {

	@Override
	public ManagerUserDTO login(String mgtUserId, String mgtUserPw) throws SQLException{
	      Connection con = null;
	      PreparedStatement ps = null;
	      ManagerUserDTO user2 = null;
	      String sql = "select MGT_USER_PWD, MGT_USER_ID from MGT_USER where upper(MGT_USER_ID) = upper(?)";
	      ResultSet rs2 =null;
	      try {
	         con = DbUtil.getConnection();
	         ps = con.prepareStatement(sql);
	         ps.setString(1, mgtUserId);
	         rs2 = ps.executeQuery();  
	         while(rs2.next()) {
	        	 user2 = new ManagerUserDTO(rs2.getString(1),rs2.getString(2));
	        	 return user2;
	         }
	      }catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		} finally {
	         DbUtil.dbClose(rs2, ps, con);
	      }
	      return null;
	   }

	@Override
	public List<ManagerUserDTO> selectAll() throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from MGT_USER";
		List<ManagerUserDTO> list = new ArrayList<ManagerUserDTO>();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ManagerUserDTO(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public String selectById(String mgtUserId) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select MGT_USER_PW from MGT_USER WHERE MGT_USER_ID=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, mgtUserId);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getString(1);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return null;
	}

	@Override
	public int insert(ManagerUserDTO dto) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "insert into MGT_USER values(?,?)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getMgtUserId());
			ps.setString(2, dto.getMgtUserPwd());
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int update(ManagerUserDTO dto) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "update MGT_USER set MGT_USER_ID=?, MGT_USER_PW=? WHERE MGT_USER_NO=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getMgtUserNo());
			ps.setString(2, dto.getMgtUserId());
			ps.setString(3, dto.getMgtUserPwd());
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int delete(int mgtUserNo) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "delete from MGT_USER where MGT_USER_NO=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, mgtUserNo);
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

}
