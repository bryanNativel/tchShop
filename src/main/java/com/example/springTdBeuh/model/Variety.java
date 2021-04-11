package com.example.springTdBeuh.model;

import javax.persistence.*;

@Entity
public class Variety {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column()
    private String name;
    @Column()
    private String THCRate;

    public Variety(Long id, String name, String thcRate) {
        this.id = id;
        this.name = name;
        THCRate = thcRate;
    }

    public Variety(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTHCRate() {
        return THCRate;
    }

    public void setTHCRate(String THCRate) {
        this.THCRate = THCRate;
    }


}
