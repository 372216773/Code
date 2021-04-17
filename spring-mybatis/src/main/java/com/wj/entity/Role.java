package com.wj.entity;

public class Role {
    private Integer id;
    private String name;
    private String describe;

    @Override
    public String toString() {
        return "role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", describe='" + describe + '\'' +
                '}';
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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
