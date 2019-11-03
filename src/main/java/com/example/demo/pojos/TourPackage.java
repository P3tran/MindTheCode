package com.example.demo.pojos;

import javax.persistence.*;

@Entity
public class TourPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "description")
    private String desc;
    private int price;
    private String dest;

    public TourPackage() { }

    public TourPackage(String desc, int price, String dest) {
        this.desc = desc;
        this.price = price;
        this.dest = dest;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }
}
