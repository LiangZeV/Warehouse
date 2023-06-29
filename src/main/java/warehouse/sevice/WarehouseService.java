package warehouse.sevice;

import entity.Commodity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WarehouseService {

    //维护成本价和标准售价
    Boolean updatePrice(Integer id, double price);

    Boolean updateCost(Integer id, double Cost);

    Boolean updateType(Integer id, String type);

    //商品采购
    Boolean saveCommodity(Commodity commodity);

    //显示商品全部信息
    List<Commodity> listCommodity();

    //模糊查找
    List<Commodity> listSpecifiedCommodity(String key);

    //售卖出库
    Boolean removeCommodity(Integer id);

}
