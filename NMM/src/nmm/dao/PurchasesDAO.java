package nmm.dao;

import nmm.dto.PurchaseDTO;

import java.util.List;

public interface PurchasesDAO {
    List<PurchaseDTO> selectAllHistory(int userNo) throws Exception;

    List<PurchaseDTO> selectAllPurchase(int userNo) throws Exception;

}