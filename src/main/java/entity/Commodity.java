package entity;


import lombok.Data;

import java.sql.Date;

@Data
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
    Integer cost;


}
