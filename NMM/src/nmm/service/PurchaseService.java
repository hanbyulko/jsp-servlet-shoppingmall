package nmm.service;

import nmm.dao.PurchasesDAO;
import nmm.dao.PurchasesDAOImpl;
import nmm.dto.PurchaseDTO;

import java.util.List;

public class PurchaseService {
    private static PurchasesDAO dao = new PurchasesDAOImpl();

    public static List<PurchaseDTO> selectAll(int userNo) throws Exception{
        return dao.selectAll(userNo);
    }

}
