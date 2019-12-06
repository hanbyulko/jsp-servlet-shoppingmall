package nmm.dao;

import java.util.List;

import nmm.dto.QnaDTO;

public interface QnaDAO {
	int update(QnaDTO dto) throws Exception;
	
	int delete(int qnaNo) throws Exception;

	int insert(int userNo, int productNo, QnaDTO dto) throws Exception;

	QnaDTO selectByQnaNo(int qnaNo) throws Exception;

	List<QnaDTO> selectAll(int pageNo) throws Exception;

	List<QnaDTO> selectByUserId(int pageNo, String userId) throws Exception;

	List<QnaDTO> selectByState(int pageNo, String responseState)  throws Exception;
}
