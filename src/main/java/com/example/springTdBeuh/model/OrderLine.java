package com.example.springTdBeuh.model;

import javax.persistence.*;

@Entity
public class OrderLine {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private int quantity;

    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.MERGE)
    @JoinColumn(name="orderUserId")
    private OrderUser orderUser;

    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.MERGE)
    @JoinColumn(name="product_id")
    private Product product;


    public OrderLine(Long id, OrderUser orderUser, Product product, int quantity) {
        this.id = id;
        this.orderUser = orderUser;
        this.product = product;
        this.quantity = quantity;
    }

    public OrderLine() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderUser getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(OrderUser orderUser) {
        this.orderUser = orderUser;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
