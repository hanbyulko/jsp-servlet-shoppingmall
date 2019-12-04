package nmm.dao;

import java.util.List;

import nmm.dto.QnaDTO;

public interface QnaDAO {
	List<QnaDTO> selectAll() throws Exception;
	
	int update(QnaDTO dto) throws Exception;
	
	int delete(int qnaNo) throws Exception;

	int insert(int userNo, int productNo, QnaDTO dto) throws Exception;

	List<QnaDTO> selectByUserId(String userId) throws Exception;
}
