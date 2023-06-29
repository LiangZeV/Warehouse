package warehouse.entity;


import java.sql.Date;



/**
 * @author zev
 */
public class Commodity {
    String name;
    Integer inventory;
    Date productionDate;
    Double price;
    Integer shelfLife;
    Integer purchaseLot;
    Integer id;
    String characteristic;
    String type;
    Double cost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(Integer shelfLife) {
        this.shelfLife = shelfLife;
    }

    public Integer getPurchaseLot() {
        return purchaseLot;
    }

    public void setPurchaseLot(Integer purchaseLot) {
        this.purchaseLot = purchaseLot;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "name='" + name + '\'' +
                ", inventory=" + inventory +
                ", productionDate=" + productionDate +
                ", price=" + price +
                ", shelfLife=" + shelfLife +
                ", purchaseLot=" + purchaseLot +
                ", id=" + id +
                ", characteristic='" + characteristic + '\'' +
                ", type='" + type + '\'' +
                ", cost=" + cost +
                '}';
    }
}
