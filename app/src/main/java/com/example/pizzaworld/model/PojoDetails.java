package com.example.pizzaworld.model;

import com.example.pizzaworld.R;

import java.io.Serializable;
import java.util.ArrayList;

public class PojoDetails implements Serializable {
    private String id;
    private String pizzaname,price,quantuu,des,status,totalprice,address,userId;
    public PojoDetails(String pizzaname, String price, String quantuu, String des, String status,String totalprice,String address, String userId) {
        this.pizzaname=pizzaname;
        this.price=price;
        this.quantuu=quantuu;
        this.des=des;
        this.status=status;
        this.userId=userId;
        this.totalprice=totalprice;
        this.address=address;
    }

    public PojoDetails(String status,String address,String totalprice) {
        this.status=status;
        this.address=address;
        this.totalprice=totalprice;

    }

    public PojoDetails() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPizzaname() {
        return pizzaname;
    }

    public void setPizzaname(String pizzaname) {
        this.pizzaname = pizzaname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantuu() {
        return quantuu;
    }

    public void setQuantuu(String quantuu) {
        this.quantuu = quantuu;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
