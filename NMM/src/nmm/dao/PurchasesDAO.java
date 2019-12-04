package nmm.dao;

import nmm.dto.PurchaseDTO;

import java.util.List;

public interface PurchasesDAO {
    List<PurchaseDTO> selectAll(int userNo) throws Exception;
}
