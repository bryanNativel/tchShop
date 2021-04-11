package com.example.springTdBeuh.model;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column()
    private String serialNumber;
    @Column()
    private int price;
    @Column()
    private int unit;
    @Column()
    private int quantityInStock;
    @OneToOne
    private Variety listOfVariety;

    public Product(Long id, String serialNumber, int price, int unit, int quantityInStock, Variety listOfVariety) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.price = price;
        this.unit = unit;
        this.quantityInStock = quantityInStock;
        this.listOfVariety = listOfVariety;
    }
    public Product () {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public Variety getListOfVariety() {
        return listOfVariety;
    }

    public void setListOfVariety(Variety listOfVariety) {
        this.listOfVariety = listOfVariety;
    }
}
