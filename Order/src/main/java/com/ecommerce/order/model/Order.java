package com.ecommerce.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class Order {

    @Id
    private String id;
    private String order_type;
    private String status;
    private Date createdDate;
    private Date lastModifiedDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Item> itemSet;
    private Double subtotal;
    private Double tax;
    private Double shipping_charges;
    private Double total;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<PaymentSplit> paymentSplit;
    @OneToOne(cascade = CascadeType.ALL)
    private DeliveryMethod deliveryMethod;


    public Order(){
        this.id= UUID.randomUUID().toString();
    }
}
