package warehouse.controller;

import entity.ResiltInfo;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import warehouse.sevice.WarehouseService;

@RestController
public class WarehouseController {
    @Autowired(required = false)
    private WarehouseService ws;

    //展示所有的数据
    @RequestMapping(value = "/commodity",method = RequestMethod.GET)
    public Result showAll() {
        Result result = new Result();
        try {
            result.setObj(ws.listCommodity());
            result.setMsg("查询成功");
            result.setCode(ResiltInfo.SUCCESS_CODE);
        } catch (Exception e) {
            result.setCode(ResiltInfo.LOST_CODE);
            result.setMsg("服务器异常，请重试。");
        }
        result.setObj(ws.listCommodity());
        result.setMsg("查询成功");
        result.setCode(ResiltInfo.SUCCESS_CODE);
        return result;
    }

    /**模糊查找*/
    @RequestMapping(value = "/commodity/{key}",method = RequestMethod.GET)
    public Result showSpecified(@PathVariable String key) {
        Result result = new Result();
        try {
            result.setObj(ws.listSpecifiedCommodity(key));
            result.setMsg("查询成功");
            result.setCode(ResiltInfo.SUCCESS_CODE);
        } catch (Exception e) {
            result.setCode(ResiltInfo.LOST_CODE);
            result.setMsg("服务器异常，请重试。");
        }
        return result;
    }

    //增加商品

    //维护成本价格

    //维护标准售价

    //删除商品

}
