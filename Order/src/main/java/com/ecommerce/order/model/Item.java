package com.ecommerce.order.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class Item {
    @Id
    private String id;
    private String item_name;
    private String item_qty;

    public Item(){

        this.id= UUID.randomUUID().toString();
    }
}
