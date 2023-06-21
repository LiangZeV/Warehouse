package warehouse.sevice;

import entity.Commodity;

import java.util.List;

public interface WarehouseService {

    //维护成本价和标准售价
    Boolean updatePrice();
    Boolean updateCost();

    //商品采购
    Boolean saveCommodity();

    //显示商品全部信息
    List<Commodity> listCommodity();

    //模糊查找
    List<Commodity> listSpecifiedCommodity(String key);

    //售卖出库
    Boolean removeCommodity(Integer id);
}
