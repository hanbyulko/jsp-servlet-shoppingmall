package nmm.service;

import nmm.dao.PurchasesDAO;
import nmm.dao.PurchasesDAOImpl;
import nmm.dto.PurchaseDTO;

import java.util.List;

public class PurchaseService {
    private static PurchasesDAO dao = new PurchasesDAOImpl();

    public static List<PurchaseDTO> selectAllHistory(int userNo) throws Exception{
        return dao.selectAllHistory(userNo);
    }

    public static List<PurchaseDTO> selectAllPurchase(int userNo) throws Exception{
        return dao.selectAllPurchase(userNo);
    }
    public static int insert(int userNo, int productNo, int qty) throws Exception {
        return dao.insert(userNo, productNo, qty);
    }

}
