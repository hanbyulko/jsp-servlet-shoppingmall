package nmm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import nmm.dto.ProductDTO;
import nmm.dto.ReviewDTO;
import nmm.util.DbUtil;

public class ReviewDAOImpl implements ReviewDAO {

	@Override
	public List<ReviewDTO> selectAll(int pageNo) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int pageCnt = 0;
		Connection con2 = null;
		PreparedStatement ps2 = null;
		ResultSet rs2 = null;
		List<ReviewDTO> list = new ArrayList<>();

		String cnt = "SELECT COUNT(*) FROM REVIEW";
		String sql = "SELECT * FROM (SELECT a.*, ROWNUM rnum FROM (SELECT REVIEW_NO, REVIEW_TITLE, REVIEW_CONTENT, REVIEW_STAR, REVIEW_DATE FROM REVIEW) a WHERE ROWNUM <= ?)  WHERE rnum >= ?";
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
				ReviewDTO reviewDTO = new ReviewDTO();
				reviewDTO.setReviewNo(rs.getInt(1));
				reviewDTO.setReviewTitle(rs.getString(2));
				reviewDTO.setReviewContent(rs.getString(3));
				reviewDTO.setReviewStar(rs.getString(4));
				reviewDTO.setReviewDate(rs.getString(5));
				reviewDTO.setPageCnt(pageCnt % 8 == 0 ? pageCnt / 8 : pageCnt / 8 + 1);
				list.add(reviewDTO);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public List<ReviewDTO> selectUser(int pageNo, int productNo) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int pageCnt = 0;
		Connection con2 = null;
		PreparedStatement ps2 = null;
		ResultSet rs2 = null;
		List<ReviewDTO> list = new ArrayList<>();

		String cnt = "SELECT COUNT(*) FROM VIEW_PRODUCTANDREVIEW WHERE PRODUCT_NO=?";
		String sql = "SELECT * FROM (SELECT a.*, ROWNUM rnum FROM (SELECT PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_COLOR, PRODUCT_SIZE, REVIEW_NO, REVIEW_TITLE, REVIEW_CONTENT, REVIEW_STAR, REVIEW_DATE FROM VIEW_PRODUCTANDREVIEW WHERE PRODUCT_NO=?) a WHERE ROWNUM <= ?)  WHERE rnum >= ?";
		try {
			con2 = DbUtil.getConnection();
			ps2 = con2.prepareStatement(cnt);
			ps2.setInt(1, productNo);
			rs2 = ps2.executeQuery();
			while (rs2.next()) {
				pageCnt = rs2.getInt(1);
			}
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, productNo);
			ps.setInt(2, pageNo * 8 + 1);
			ps.setInt(3, (pageNo - 1) * 8 + 1);
			rs = ps.executeQuery();
			while (rs.next()) {
				ReviewDTO reviewDTO = new ReviewDTO();
				ProductDTO productDTO = new ProductDTO();
				productDTO.setProductName(rs.getString(1));
				productDTO.setProductPrice(rs.getInt(2));
				productDTO.setProductColor(rs.getString(3));
				productDTO.setProductSize(rs.getString(4));
				reviewDTO.setReviewNo(rs.getInt(5));
				reviewDTO.setReviewTitle(rs.getString(6));
				reviewDTO.setReviewContent(rs.getString(7));
				reviewDTO.setReviewStar(rs.getString(8));
				reviewDTO.setReviewDate(rs.getString(9));
				reviewDTO.setProductDTO(productDTO);
				reviewDTO.setPageCnt(pageCnt % 8 == 0 ? pageCnt / 8 : pageCnt / 8 + 1);
				list.add(reviewDTO);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);

		}
		return list;

	}

	@Override
	public int insert(int userNo, int productNo, ReviewDTO dto) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "INSERT INTO REVIEW (PRODUCT_NO, REVIEW_NO, REVIEW_TITLE,REVIEW_CONTENT,REVIEW_STAR, REVIEW_DATE) VALUES(?, REVIEW_NO_SEQ.NEXTVAL,?,?,?,SYSDATE)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, productNo);
			ps.setString(2, dto.getReviewTitle());
			ps.setString(3, dto.getReviewContent());
			ps.setString(4, dto.getReviewStar());
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		// System.out.println(result);
		return result;
	}

	@Override
	public int update(ReviewDTO dto) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "UPDATE REVIEW SET REVIEW_TITLE=?, REVIEW_CONTENT=?, REVIEW_STAR=? WHERE REVIEW_NO=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getReviewTitle());
			ps.setString(2, dto.getReviewContent());
			ps.setString(3, dto.getReviewStar());
			ps.setInt(4, dto.getReviewNo());
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int delete(int reviewNo) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "delete from REVIEW where REVIEW_NO=?";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, reviewNo);
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public List<ProductDTO> selectTop() throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT PRODUCT_NO, COUNT(*) AS CNT FROM REVIEW GROUP BY PRODUCT_NO ORDER BY CNT DESC";
		List<Integer> productList = new ArrayList<>();
		List<ProductDTO> list = new ArrayList<>();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			ps.clearParameters();
			for (int i = 0; i < 4; i++) {
				rs.next();
				productList.add(rs.getInt("PRODUCT_NO"));
			}
			String sql2 = "SELECT PRODUCT_NO, PRODUCT_NAME, PRODUCT_PRICE FROM PRODUCT WHERE PRODUCT_NO IN(?,?,?,?)";
			ps = con.prepareStatement(sql2);
			ps.setInt(1, productList.get(0));
			ps.setInt(2, productList.get(1));
			ps.setInt(3, productList.get(2));
			ps.setInt(4, productList.get(3));
			rs = ps.executeQuery();
			for (int i = 0; i < 4; i++) {
				rs.next();
				ProductDTO dto = new ProductDTO();
				dto.setProductNo(rs.getInt(1));
				dto.setProductName(rs.getString(2));
				dto.setProductPrice(rs.getInt(3));
				list.add(dto);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}
}