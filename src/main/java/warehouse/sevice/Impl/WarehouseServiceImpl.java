package warehouse.sevice.Impl;

import entity.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import warehouse.dao.WarehouseMapper;
import warehouse.sevice.WarehouseService;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;


@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    private WarehouseMapper wm;

    Boolean k = false;


    @Override
    public Boolean updatePrice(Integer id, double price) {
        try {
            wm.updatePrice(id,price);
            k = true;
        } catch (Exception e) {
            throw e;
        }
        return k;
    }

    @Override
    public Boolean updateCost(Integer id, double cost) {
        try {
            wm.updateCost(id,cost);
            k = true;
        } catch (Exception e) {
            throw e;
        }
        return k;
    }

    @Override
    public Boolean saveCommodity(Commodity commodity) {
        try {
            wm.saveCommodity(commodity);
            k = true;
        } catch (Exception e) {
            throw e;
        }
        return k;
    }

    @Override
    public List<Commodity> listCommodity() {
        List<Commodity> commodities;
        try {
            commodities = SortOutCommodities(wm.listCommodity());
        } catch (Exception e) {
            commodities = null;
            throw e;
        }
        return commodities;
    }

    @Override
    public List<Commodity> listSpecifiedCommodity(String key) {
        List<Commodity> commodities;
        try {
            commodities = SortOutCommodities(wm.listSpecifiedCommodity(key));
        } catch (Exception e) {
            commodities = null;
            throw e;
        }
        return commodities;
    }

    @Override
    public Boolean removeCommodity(Integer id) {
        try {
            wm.removeCommodity(id);
            k = true;
        } catch (Exception e) {
            throw e;
        }
        return k;
    }



    /**
     * 计算当天和生产日期
     */
    private int finalPrice(Date date) {
        Date today = new Date(System.currentTimeMillis());
        return (int) ((today.getTime() - date.getTime()) / (1000 * 3600 * 24));
    }

    /**
     * 整理数组中的实际价格
     */
    private List<Commodity> SortOutCommodities(List<Commodity> commodities) {
        for (int i = 0; i < commodities.size(); i++) {
            Commodity commodity = commodities.get(i);
            switch (commodity.getCharacteristic()) {
                case "普通商品":
                    int day = finalPrice(commodity.getProductionDate());
                    int shelfLife = commodity.getShelfLife();
                    if (shelfLife - day >= 3) {
                        commodity.setPrice(commodity.getPrice() * 0.5);
                        commodities.set(i,commodity);
                    }
                    break;

                case "充值商品":
                    break;

                case "增值商品":
                    int year1 = Calendar.getInstance().get(Calendar.YEAR);
                    int year2 = Integer.parseInt(commodity.getProductionDate().toString().substring(0, 4));
                    commodity.setPrice(Math.pow(1.1, year1 - year2) * commodity.getPrice());
                    commodities.set(i,commodity);
                    break;
            }
        }

        return commodities;
    }
}


