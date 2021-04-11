package com.example.springTdBeuh.model;
import javax.persistence.*;

@Entity
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column()
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderUser orderUser;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public OrderLine(Long id, int quantity) {
        this.id = id;
        this.quantity = quantity;

    }

    public OrderLine() {}

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

    public OrderUser getOrder() {
        return orderUser;
    }

    public void setOrder(OrderUser orderUser) {
        this.orderUser = orderUser;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


}
