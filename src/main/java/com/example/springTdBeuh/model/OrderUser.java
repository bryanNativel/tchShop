package com.example.springTdBeuh.model;

import org.springframework.format.datetime.standard.DateTimeContext;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
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


    public OrderUser(Long id, Date dateOrder, User user) {
        this.id = id;
        this.dateOrder = dateOrder;
        this.user = user;

    }

    public OrderUser() {}

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



}
