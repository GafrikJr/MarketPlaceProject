package org.example.model.warehouses;

import jakarta.persistence.*;

@Entity
@Table(name = "Cell")
public class Cell {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "warehouse_id")
    private int warehouseId;

    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_count")
    private int productCount;

    @Column(name = "cost")
    private int cost;

    public Cell() {};

    public Cell(int warehouseId) {
        this.warehouseId = warehouseId;
        this.productId = 0;
        this.productCount = 0;
        this.cost = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void printContent() {
        // тут надо в productMethods написать метод для получения названия содержимого по productId
    }
}
