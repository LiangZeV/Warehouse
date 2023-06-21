package warehouse.dao;

import entity.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WarehouseMapper {

    /**
     * 查寻全部的商品
     * @liangzv
     */
    @Select(value = "SELECT `name`,SUM(`inventory`) AS `inventory`,`price`,`shelf_life`,`characteristic` FROM `commodity_info` WHERE `name` IN ( SELECT `name` FROM `commodity_info` GROUP BY `name` ) GROUP BY `name`")
    List<Commodity> listCommodity();


}
