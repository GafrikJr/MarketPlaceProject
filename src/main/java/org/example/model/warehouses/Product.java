package org.example.model.warehouses;

public class Product {
    private int id;
    private String name;
    private int buyCost;
    private int sellCost;

    public Product(String name, int buyCost, int sellCost) {
        this.name = name;
        this.buyCost = buyCost;
        this.sellCost = sellCost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBuyCost() {
        return buyCost;
    }

    public void setBuyCost(int buyCost) {
        this.buyCost = buyCost;
    }

    public int getSellCost() {
        return sellCost;
    }

    public void setSellCost(int sellCost) {
        this.sellCost = sellCost;
    }
}
