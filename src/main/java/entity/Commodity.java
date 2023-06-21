package entity;


import lombok.Data;

@Data
public class Commodity {
    String name;
    Integer inventory;
    String productionDate;
    Double price;
    Integer shelfLife;
    Integer purchaseCatch;
    Integer id;
    String characteristic;
    String type;
    Integer cost;


}
