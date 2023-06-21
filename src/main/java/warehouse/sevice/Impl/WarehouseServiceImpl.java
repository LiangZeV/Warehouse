package warehouse.sevice.Impl;

import entity.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import warehouse.dao.WarehouseMapper;
import warehouse.sevice.WarehouseService;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    private WarehouseMapper wm;

    @Override
    public Boolean updatePrice() {
        return null;
    }

    @Override
    public Boolean updateCost() {
        return null;
    }

    @Override
    public Boolean saveCommodity() {
        return null;
    }

    @Override
    public List<Commodity> listCommodity() {
        return null;
    }

    @Override
    public List<Commodity> listSpecifiedCommodity(String key) {
        return null;
    }

    @Override
    public Boolean removeCommodity(Integer id) {
        return null;
    }

    private Commodity FinalPrice(){
        return null;
    }
}
