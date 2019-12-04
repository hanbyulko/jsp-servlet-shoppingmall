package nmm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import nmm.dto.ProductDTO;
import nmm.dto.QnaDTO;
import nmm.dto.UserDTO;
import nmm.util.DbUtil;

public class QnaDAOImpl implements QnaDAO {

	@Override
	public List<QnaDTO> selectAll() throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<QnaDTO> list = new ArrayList<>();
		String sql = "select QNA_NO, PRODUCT_NO, QNA_TITLE, QNA_DATE, QNA_RESPONSESTATE from QNA";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				ProductDTO productDTO = new ProductDTO();
				QnaDTO qnaDTO = new QnaDTO();
				qnaDTO.setQnaNo(rs.getInt(1));
				productDTO.setProductNo(rs.getInt(2));
				qnaDTO.setProductDTO(productDTO);
				qnaDTO.setQnaTitle(rs.getString(3));
				qnaDTO.setQnaDate(rs.getString(4));
				qnaDTO.setQnaResponseState(rs.getString(5));
				list.add(qnaDTO);
			}
			System.out.println(list);
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public int insert(int userNo, int productNo, QnaDTO dto) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "insert into qna(QNA_NO, USER_NO, PRODUCT_NO,QNA_TITLE,QNA_CONTENT,QNA_DATE) values(QNA_NO_SEQ.NEXTVAL,?,?,?,?,sysdate)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userNo);
			ps.setInt(2, productNo);
			ps.setString(3, dto.getQnaTitle());
			ps.setString(4, dto.getQnaContent());
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
		
	}

	@Override
	public int update(QnaDTO dto) throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "update qna set QNA_TITLE=?, QNA_CONTENT=? QNA_DATE=sysdate where QNA_NO=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getQnaNo());
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	
	@Override
	public int delete(int qnaNo) throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "delete from qna where QNA_NO=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, qnaNo);
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public List<QnaDTO> selectByUserId(String userId) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<QnaDTO> list = new ArrayList<>();
		String sql = "select QNA_NO, PRODUCT_NAME, QNA_TITLE, QNA_CONTENT, QNA_DATE, QNA_RESPONSESTATE, QNA_RESPONSECONTENT from (SELECT * FROM QNA INNER JOIN PRODUCT ON QNA.PRODUCT_NO = PRODUCT.PRODUCT_NO\r\n" + 
				"INNER JOIN USERDB ON QNA.USER_NO = USERDB.USER_NO) where USER_ID=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			rs = ps.executeQuery();
			while (rs.next()) {
				ProductDTO productDTO = new ProductDTO();
				QnaDTO qnaDTO = new QnaDTO();
				qnaDTO.setQnaNo(rs.getInt(1));
				productDTO.setProductName(rs.getString(2));
				qnaDTO.setProductDTO(productDTO);
				qnaDTO.setQnaTitle(rs.getString(3));
				qnaDTO.setQnaContent(rs.getString(4));
				qnaDTO.setQnaDate(rs.getString(5));
				qnaDTO.setQnaResponseState(rs.getString(6));
				qnaDTO.setQnaResponseContent(rs.getString(7));
				list.add(qnaDTO);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}
	
	

}
