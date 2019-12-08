package nmm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nmm.dto.UserDTO;
import nmm.util.DbUtil;

public class UserDAOImpl implements UserDAO {

	@Override
	public int insert(UserDTO dto) throws SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		System.out.println(dto);
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("INSERT INTO USERDB VALUES(USER_NO_SEQ.NEXTVAL,?,?,?,?,?,?,?)");
			ps.setString(1, dto.getUserPwd());
			ps.setString(2, dto.getUserId());
			ps.setString(3, dto.getUserName());
			ps.setString(4, dto.getUserBirth());
			ps.setInt(5, dto.getUserPhone());
			ps.setString(6, dto.getUserAddr());
			ps.setString(7, dto.getUserEmail());
			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int update(UserDTO dto) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "UPDATE USERDB SET USER_PWD=? , USER_NAME=? , USER_ADDR=? , USER_PHONE=? , USER_EMAIL=? WHERE upper(USER_ID)=upper(?)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, dto.getUserPwd());
			ps.setString(2, dto.getUserName());
			ps.setString(3, dto.getUserAddr());
			ps.setInt(4, dto.getUserPhone());
			ps.setString(5, dto.getUserEmail());
			ps.setString(6, dto.getUserId());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return ps.executeUpdate();
	}

	@Override
	public int delete(String userId) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "DELETE USERDB WHERE upper(USER_ID)=upper(?)";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId.trim());
			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		System.out.println(result);
		return result;
	}

	@Override
	public UserDTO loginCheck(String userId, String userPwd) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "select USER_NO,USER_ID,USER_PWD from USERDB where upper(user_id) = upper(?) ";
		ResultSet rs = null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			UserDTO user1 = null;
			rs = ps.executeQuery(); // ����Ŭ�� app������ ����
			while (rs.next()) {
				user1 = new UserDTO(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			return user1;
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
	}

	public boolean idCheck(String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "select USER_ID from USERDB where upper(user_id) = upper(?) ";
		ResultSet rs = null;
		boolean user = false;
		System.out.println(user);
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery(); // ����Ŭ�� app������ ����
			while (rs.next()) {
				user = true;
			}
			return user;
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}

	}
	@Override
	public List<UserDTO> selectAll(int pageNo) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<UserDTO> list = new ArrayList<UserDTO>();
		Connection con2 = null;
		PreparedStatement ps2 = null;
		ResultSet rs2 = null;
		int pageCnt = 0;
		String cnt = "SELECT COUNT(*) FROM USERDB";
		String sql = "SELECT * FROM (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM USERDB) a WHERE ROWNUM <= ?)  WHERE rnum >= ?";
		try {
			con2 = DbUtil.getConnection();
			ps2 = con2.prepareStatement(cnt);
			rs2 = ps2.executeQuery();
			while (rs2.next()) {
				pageCnt = rs2.getInt(1);
			}
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, pageNo * 8 + 1);
			ps.setInt(2, (pageNo - 1) * 8 + 1);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserDTO dto = new UserDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8));
				dto.setPageCnt(pageCnt % 8 == 0 ? pageCnt / 8 : pageCnt / 8 + 1);
				list.add(dto);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
			DbUtil.dbClose(rs2, ps2, con2);
		}
		return list;
	}

	@Override
	public List<UserDTO> selectByKeyword(int pageNo, String keyword, String value) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<UserDTO> list = new ArrayList<UserDTO>();
		Connection con2 = null;
		PreparedStatement ps2 = null;
		ResultSet rs2 = null;
		int pageCnt = 0;
		String cnt = "SELECT COUNT(*) FROM USERDB where ";
		String sql = "SELECT * FROM (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM USERDB WHERE ";
		if (keyword.equals("userId")) {
			cnt+="USER_ID";
		sql+="USER_ID";
		}
		if (keyword.equals("userName")) { 
			cnt+="USER_NAME";
		sql+="USER_NAME";
		}
		if (keyword.equals("userBirth")) {
			cnt+="USER_BIRTH";
		sql+="USER_BIRTH";
		}
		if (keyword.equals("userPhone")) { 
			cnt+="USER_PHONE";
		sql+="USER_PHONE";
		}
		if (keyword.equals("userAddr")) { 
			cnt+="USER_Addr";
		sql+="USER_Addr";
		}
		if (keyword.equals("userEmail")) {
			cnt+="USER_Email";
		sql+="USER_Email";
		}
		cnt+= "LIKE ?"; 
		sql+= "LIKE ?)a WHERE ROWNUM <= ?)  WHERE rnum >= ?";
		
		try {
			con2 = DbUtil.getConnection();
			ps2 = con2.prepareStatement(cnt);
			if (keyword.equals("userNo"))
				ps2.setInt(1, Integer.parseInt(value));
			
			ps2.setString(1,value);
			rs2 = ps2.executeQuery();
			while (rs2.next()) {
				pageCnt = rs2.getInt(1);
			}
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			if (keyword.equals("userNo"))
				ps.setInt(1, Integer.parseInt(value));
			ps.setString(1, value);
			ps.setInt(2, pageNo * 8 + 1);
			ps.setInt(3, (pageNo - 1) * 8 + 1);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserDTO dto = new UserDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8));
				dto.setPageCnt(pageCnt % 8 == 0 ? pageCnt / 8 : pageCnt / 8 + 1);
				list.add(dto);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
			DbUtil.dbClose(rs2, ps2, con2);
		}
		return list;
	}

	public UserDTO selectByUserNo(int userNo) throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "SELECT USER_NAME, USER_PHONE, USER_EMAIL, USER_ADDR FROM USERDB WHERE USER_NO=?";
		ResultSet rs = null;
		UserDTO user1 = new UserDTO();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userNo);
			rs = ps.executeQuery(); 
			if (rs.next()) {
				user1.setUserName(rs.getString(1));
				user1.setUserPhone(rs.getString(2));
				user1.setUserEmail(rs.getString(3));
				user1.setUserAddr(rs.getString(4));
			}
			return user1;
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
	}
}