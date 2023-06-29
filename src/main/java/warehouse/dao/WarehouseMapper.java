package warehouse.dao;



import entity.Commodity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 12488
 */
@Mapper
public interface WarehouseMapper {

    @Select(value = "SELECT * FROM `commodity_info` ORDER BY `name` DESC")
    List<Commodity> listCommodity();

    //模糊查找商品
    @Select(value = "SELECT * FROM `commodity_info` WHERE `name` LIKE concat('%',#{key},'%') ORDER BY `production_date`")
    List<Commodity> listSpecifiedCommodity(String key);

    //添加商品
    @Insert(value = "INSERT INTO `commodity_info` VALUE (#{name}" +
            ",#{inventory},#{productionDate},#{price},#{shelfLife}" +
            ",#{purchaseLot},#{id},#{characteristic},#{type},#{cost})")
    void saveCommodity(Commodity commodity);

    //删除商品
    @Delete(value = "DELETE FROM `commodity_info` WHERE `id` = #{id}}")
    void removeCommodity(Integer id);

    //修改标准售价
    @Update(value = "UPDATE `commodity_info` SET `price` = #{price} WHERE `id` = #{id}")
    void updatePrice(Integer id,Double price);

    //修改成本价
    @Update(value = "UPDATE `commodity_info` SET `cost` = #{cost} WHERE `id` = #{id}")
    void updateCost(Integer id,Double cost);

    //修改成本价
    @Update(value = "UPDATE `commodity_info` SET `type` = #{type} WHERE `id` = #{id}")
    void updateType(Integer id,String type);
}
