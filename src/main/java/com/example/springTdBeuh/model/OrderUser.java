package com.example.springTdBeuh.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class OrderUser {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column()
    private Date dateOrder;
    @OneToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy="orderUser",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<OrderLine> OrderLine;

    public OrderUser(Long id, Date dateOrder, User user) {
        this.id = id;
        this.dateOrder = dateOrder;
        this.user = user;
    }
    public OrderUser() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<com.example.springTdBeuh.model.OrderLine> getOrderLine() {
        return OrderLine;
    }

    public void setOrderLine(Set<com.example.springTdBeuh.model.OrderLine> orderLine) {
        OrderLine = orderLine;
    }

}
