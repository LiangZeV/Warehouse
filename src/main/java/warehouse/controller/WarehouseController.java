package warehouse.controller;

import warehouse.entity.Commodity;
import warehouse.entity.ResiltInfo;
import warehouse.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import warehouse.sevice.WarehouseService;

/**
 * @author zev
 */
@RestController
public class WarehouseController {
    @Autowired(required = false)
    private WarehouseService ws;

    /**
     * 展示所有的数据
     * */
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

    /**
     * 模糊查找
     * */
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

    /**
     * 增加商品
     * */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result addCost(@RequestBody Commodity commodity){
        Result result = new Result();
        try {
            ws.saveCommodity(commodity);
            result.setMsg("添加成功");
            result.setCode(ResiltInfo.SUCCESS_CODE);
        } catch (Exception e) {
            result.setCode(ResiltInfo.LOST_CODE);
            result.setMsg("服务器异常，请重试。");
        }
        return result;
    }
    /**
     * 维护标准售价
     * */
    @RequestMapping(value = "/updatePrice",method = RequestMethod.PUT)
    public Result updatePrice(@RequestBody Commodity commodity){
        Result result = new Result();
        try {
            Integer id = commodity.getId();
            Double price = commodity.getPrice();
            ws.updatePrice(id,price);
            result.setMsg("修改成功");
            result.setCode(ResiltInfo.SUCCESS_CODE);
        } catch (Exception e) {
            result.setCode(ResiltInfo.LOST_CODE);
            result.setMsg("服务器异常，请重试。");
        }
        return result;
    }
    /**
     * 维护标签
     * */
    @RequestMapping(value = "/updateType",method = RequestMethod.PUT)
    public Result updateType(@RequestBody Commodity commodity){
        Result result = new Result();
        try {
            Integer id = commodity.getId();
            String type = commodity.getType();
            ws.updateType(id,type);
            result.setMsg("修改成功");
            result.setCode(ResiltInfo.SUCCESS_CODE);
        } catch (Exception e) {
            result.setCode(ResiltInfo.LOST_CODE);
            result.setMsg("服务器异常，请重试。");
        }
        return result;
    }
    /**
     * 维护成本价
     * */
    @RequestMapping(value = "/updateCost",method = RequestMethod.PUT)
    public Result updateCost(@RequestBody Commodity commodity){
        Result result = new Result();
        try {
            Integer id = commodity.getId();
            Double cost = commodity.getCost();
            ws.updateCost(id,cost);
            result.setMsg("修改成功");
            result.setCode(ResiltInfo.SUCCESS_CODE);
        } catch (Exception e) {
            result.setCode(ResiltInfo.LOST_CODE);
            result.setMsg("服务器异常，请重试。");
        }
        return result;
    }

    /**
     * 删除商品
     * */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public Result removeCommodity(@PathVariable int id) {
        Result result = new Result();
        try {
            ws.removeCommodity(id);
            result.setMsg("删除成功");
            result.setCode(ResiltInfo.SUCCESS_CODE);
        } catch (Exception e) {
            result.setCode(ResiltInfo.LOST_CODE);
            result.setMsg("服务器异常，请重试。");
        }
        return result;
    }

}
