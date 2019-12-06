package nmm.service;

import java.util.List;

import nmm.dao.QnaDAO;
import nmm.dao.QnaDAOImpl;
import nmm.dto.QnaDTO;

public class QnaService {
	private static QnaDAO dao = new QnaDAOImpl();
	
	public static List<QnaDTO> selectAll(int pageNo) throws Exception {
		return dao.selectAll(pageNo);
	}
	
	public static int insert(int userNo, int productNo, QnaDTO dto) throws Exception {
		return dao.insert(userNo, productNo, dto);
	}

	public static int update(QnaDTO dto) throws Exception {
		return dao.update(dto);
	}

	public static int delete(int qnaNo) throws Exception {
		return dao.delete(qnaNo);
	}

	public static List<QnaDTO> selectByUserId(int pageNo, String userId) throws Exception{
		return dao.selectByUserId(pageNo, userId);
	}

	public static QnaDTO selectByQnaNo(int qnaNo) throws Exception {
		return dao.selectByQnaNo(qnaNo);
	}

	public static List<QnaDTO> selectByState(int pageNo, String responseState) throws Exception {
		return dao.selectByState(pageNo, responseState);
	}
	
}
