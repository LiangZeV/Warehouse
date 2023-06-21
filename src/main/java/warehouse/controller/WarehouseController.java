package warehouse.controller;

import entity.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import warehouse.dao.WarehouseMapper;

import java.util.List;

@RestController
public class WarehouseController {
    @Autowired
    private WarehouseMapper wm;

    @GetMapping("/getCommodity")
    public List showall(){
        List<Commodity> list = wm.listCommodity();
        return list;
    }

}
