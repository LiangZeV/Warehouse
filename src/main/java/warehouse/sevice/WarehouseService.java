package warehouse.sevice;

import warehouse.entity.Commodity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zev
 */
@Service
public interface WarehouseService {

    /**
     * 维护成本价和标准售价
     * @param id 维护id
     * @param price 维护标准售价
     * @return 成功true，失败false
     */
    Boolean updatePrice(Integer id, double price);

    /**
     * 维护售价
     * @param id 维护id
     * @param cost 维护成本价
     * @return 成功true，失败false
     */
    Boolean updateCost(Integer id, double cost);

    /**
     * 维护分类标签
     * @param id 维护id
     * @param type 维护标签值
     * @return 成功true，失败false
     */
    Boolean updateType(Integer id, String type);

    /**
     * 添加新商品
     * @param commodity 添加的商品信息
     * @return 成功true，失败false
     */
    Boolean saveCommodity(Commodity commodity);

    /**
     * 展示所有的商品
     * @return 商品的信息列表
     */
    List<Commodity> listCommodity();

    /**
     * 展示关键词的商品
     * @param key 关键词
     * @return 商品的信息列表
     */
    List<Commodity> listSpecifiedCommodity(String key);

    /**
     * 移除商品信息
     * @param id 移除的商品id
     * @return 成功true，失败false
     */
    Boolean removeCommodity(Integer id);

}
