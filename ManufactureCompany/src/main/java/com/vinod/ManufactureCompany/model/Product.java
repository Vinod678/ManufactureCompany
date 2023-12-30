package com.vinod.ManufactureCompany.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prodId;
    private String prodName;
    private String prodCost;

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdCost() {
        return prodCost;
    }

    public void setProdCost(String prodCost) {
        this.prodCost = prodCost;
    }
    @Override
    public String toString() {
        return "{" +
                "prodId=" + prodId +
                ", prodName='" + prodName + '\'' +
                ", prodCost='" + prodCost + '\'' +
                '}';
    }
}
