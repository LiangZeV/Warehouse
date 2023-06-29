package warehouse.dao;



import warehouse.entity.Commodity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zev
 */
@Mapper
public interface WarehouseMapper {

    /**
     * 展示所有的商品
     * @return 商品的信息列表
     */
    @Select(value = "SELECT * FROM `commodity_info` ORDER BY `name` DESC")
    List<Commodity> listCommodity();


    /**
     * 展示关键词的商品
     * @param key 关键词
     * @return 商品的信息列表
     */
    @Select(value = "SELECT * FROM `commodity_info` WHERE `name` LIKE concat('%',#{key},'%') ORDER BY `production_date`")
    List<Commodity> listSpecifiedCommodity(String key);

    /**
     * 添加新商品
     * @param commodity 添加的商品信息
     */
    @Insert(value = "INSERT INTO `commodity_info` VALUE (#{name}" +
            ",#{inventory},#{productionDate},#{price},#{shelfLife}" +
            ",#{purchaseLot},#{id},#{characteristic},#{type},#{cost})")
    void saveCommodity(Commodity commodity);

    /**
     * 移除商品信息
     * @param id 移除的商品id
     */
    @Delete(value = "DELETE FROM `commodity_info` WHERE `id` = #{id}")
    void removeCommodity(Integer id);

    /**
     * 维护成本价和标准售价
     * @param id 维护id
     * @param price 维护标准售价
     */
    @Update(value = "UPDATE `commodity_info` SET `price` = #{price} WHERE `id` = #{id}")
    void updatePrice(Integer id,Double price);

    /**
     * 维护售价
     * @param id 维护id
     * @param cost 维护成本价
     */
    @Update(value = "UPDATE `commodity_info` SET `cost` = #{cost} WHERE `id` = #{id}")
    void updateCost(Integer id,Double cost);

    /**
     * 维护分类标签
     * @param id 维护id
     * @param type 维护标签值
     */
    @Update(value = "UPDATE `commodity_info` SET `type` = #{type} WHERE `id` = #{id}")
    void updateType(Integer id,String type);
}
