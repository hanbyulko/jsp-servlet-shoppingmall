package nmm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nmm.dto.ProductDTO;
import nmm.dto.QnaDTO;
import nmm.util.DbUtil;

public class QnaDAOImpl implements QnaDAO {

	@Override
	public List<QnaDTO> selectAll(int pageNo) throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<QnaDTO> list = new ArrayList<>();
		
		Connection con2 = null;
		PreparedStatement ps2 = null;
		ResultSet rs2 = null;
		int pageCnt = 0;
		String cnt = "SELECT COUNT(*) FROM  QNA JOIN PRODUCT USING(PRODUCT_NO)";
		String sql = "SELECT * FROM (SELECT a.*, ROWNUM rnum FROM (select QNA_NO, PRODUCT_NO, QNA_TITLE, QNA_DATE, QNA_RESPONSESTATE, PRODUCT_NAME from QNA JOIN PRODUCT USING(PRODUCT_NO)) a WHERE ROWNUM <= ?)  WHERE rnum >= ?";
		try {
			con2 = DbUtil.getConnection();
			ps2 = con2.prepareStatement(cnt);
			rs2 = ps2.executeQuery();
			while (rs2.next()) {
				pageCnt = rs2.getInt(1);
			}
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, pageNo * 8);
			ps.setInt(2, (pageNo - 1) * 8 + 1);
			rs = ps.executeQuery();
			while (rs.next()) {
				ProductDTO productDTO = new ProductDTO();
				QnaDTO qnaDTO = new QnaDTO();
				qnaDTO.setQnaNo(rs.getInt(1));
				productDTO.setProductNo(rs.getInt(2));
				qnaDTO.setQnaTitle(rs.getString(3));
				qnaDTO.setQnaDate(rs.getString(4));
				qnaDTO.setQnaResponseState(rs.getString(5));
				productDTO.setProductName(rs.getString(6));
				qnaDTO.setProductDTO(productDTO);
				qnaDTO.setPageCnt(pageCnt % 8 == 0 ? pageCnt / 8 : pageCnt / 8 + 1);
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
	public List<QnaDTO> selectByUserId(int pageNo, String userId) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Connection con2 = null;
		PreparedStatement ps2 = null;
		ResultSet rs2 = null;
		String cnt = "SELECT COUNT(*) FROM (SELECT * FROM QNA INNER JOIN PRODUCT ON QNA.PRODUCT_NO = PRODUCT.PRODUCT_NO INNER JOIN USERDB ON QNA.USER_NO = USERDB.USER_NO) where USER_ID=?";
		int pageCnt = 0;
		
		List<QnaDTO> list = new ArrayList<>();
		String sql = "SELECT * FROM (SELECT a.*, ROWNUM rnum FROM (select QNA_NO, PRODUCT_NAME, QNA_TITLE, QNA_CONTENT, QNA_DATE, QNA_RESPONSESTATE, QNA_RESPONSECONTENT from (SELECT * FROM QNA INNER JOIN PRODUCT ON QNA.PRODUCT_NO = PRODUCT.PRODUCT_NO INNER JOIN USERDB ON QNA.USER_NO = USERDB.USER_NO) where USER_ID=?) a WHERE ROWNUM <= ?)  WHERE rnum >= ?";
		try {
			con2 = DbUtil.getConnection();
			ps2 = con2.prepareStatement(cnt);
			ps2.setString(1, userId);
			rs2 = ps2.executeQuery();
			while (rs2.next()) {
				pageCnt = rs2.getInt(1);
			}
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setInt(2, pageNo * 8);
			ps.setInt(3, (pageNo - 1) * 8 + 1);
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
				qnaDTO.setPageCnt(pageCnt % 8 == 0 ? pageCnt / 8 : pageCnt / 8 + 1);
				list.add(qnaDTO);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public QnaDTO selectByQnaNo(int qnaNo) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		QnaDTO dto = new QnaDTO();
		String sql = "select QNA_NO, PRODUCT_NO, QNA_TITLE, QNA_CONTENT, QNA_DATE, QNA_RESPONSECONTENT from qna where QNA_NO=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, qnaNo);
			rs = ps.executeQuery();
			while (rs.next()) {
				ProductDTO productDTO = new ProductDTO();
				dto = new QnaDTO();
				dto.setQnaNo(rs.getInt(1));
				productDTO.setProductNo(rs.getInt(2));
				dto.setProductDTO(productDTO);
				dto.setQnaTitle(rs.getString(3));
				dto.setQnaContent(rs.getString(4));
				dto.setQnaDate(rs.getString(5));
				dto.setQnaResponseContent(rs.getString(6));
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return dto;
	}

	@Override
	public List<QnaDTO> selectByState(int pageNo, String responseState) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<QnaDTO> list = new ArrayList<>();
		
		Connection con2 = null;
		PreparedStatement ps2 = null;
		ResultSet rs2 = null;
		int pageCnt = 0;
		String cnt = "SELECT COUNT(*) FROM QNA WHERE QNA_RESPONSESTATUS=?";
		String sql = "SELECT * FROM (SELECT a.*, ROWNUM rnum FROM (select QNA_NO, PRODUCT_NO, QNA_TITLE, QNA_DATE, QNA_RESPONSESTATE from QNA WHERE QNA_RESPONSESTATUS=?) a WHERE ROWNUM <= ?)  WHERE rnum >= ?";
		try {
			con2 = DbUtil.getConnection();
			ps2 = con2.prepareStatement(cnt);
			ps2.setString(1, responseState);
			con = DbUtil.getConnection();
			rs2 = ps2.executeQuery();
			while (rs2.next()) {
				pageCnt = rs2.getInt(1);
			}
			ps = con.prepareStatement(sql);
			ps.setString(1, responseState);
			ps.setInt(2, pageNo * 8);
			ps.setInt(3, (pageNo - 1) * 8 + 1);
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
				qnaDTO.setPageCnt(pageCnt % 8 == 0 ? pageCnt / 8 : pageCnt / 8 + 1);
				list.add(qnaDTO);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	
	}
	
	

}
