package com.dadacar.entity;

public class Car {
    private Integer id;//车辆ID
    private String name;//车辆名称
    private Integer price;//车辆单价
    private Integer zkl;//载客量
    private Integer zhl;//载货量


    public Car() {}

    public Car(Integer id, String name, Integer price, Integer zkl, Integer zhl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.zkl = zkl;
        this.zhl = zhl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getZkl() {
        return zkl;
    }

    public void setZkl(Integer zkl) {
        this.zkl = zkl;
    }

    public Integer getZhl() {
        return zhl;
    }

    public void setZhl(Integer zhl) {
        this.zhl = zhl;
    }
}
