package org.example.model.orders;

public class Order {
    private int id;
    private int orderListId;
    private int productId;
    private int cellId;
    private int cost;

    public Order(int id, int orderListId, int productId, int cellId, int cost) {
        this.id = id;
        this.orderListId = orderListId;
        this.productId = productId;
        this.cellId = cellId;
        this.cost = cost;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderListId() {
        return orderListId;
    }

    public void setOrderListId(int orderListId) {
        this.orderListId = orderListId;
    }

    public int getCellId() {
        return cellId;
    }

    public void setCellId(int cellId) {
        this.cellId = cellId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
