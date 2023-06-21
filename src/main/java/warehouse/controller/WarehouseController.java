package warehouse.controller;

import entity.Commodity;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import warehouse.dao.WarehouseMapper;

import java.util.List;

@RestController
public class WarehouseController {
    @Autowired
    private WarehouseMapper wm;

    //展示所有的数据
    @GetMapping("/getCommodity")
    public Result showAll() {
        Result result = new Result();
        try {
            List<Commodity> list = wm.listCommodity();
        } catch (Exception e) {

        }
        return result;
    }

    //模糊查找
    @GetMapping()
    public Result showSpecified() {
        return null;
    }

    //增加商品

    //维护成本价格

    //维护标准售价

    //删除商品

}
