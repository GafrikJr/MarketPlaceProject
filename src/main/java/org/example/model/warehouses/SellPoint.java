package org.example.model.warehouses;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sell_point")
public class SellPoint {

    @Id
    @Column(name = "warehouse_id")
    private int warehouseId;

    @Column(name = "manager_id")
    private int managerId;

    @Column(name = "salary_budget")
    private int salaryBudget;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "profit")
    private int profit;

    public SellPoint() {};

    public SellPoint(int warehouseId, int salaryBudget, int capacity) {
        this.warehouseId = warehouseId;
        this.managerId = 0;
        this.salaryBudget = salaryBudget;
        this.capacity = capacity;
        this.profit = 0;
    }

    public int getId() {
        return warehouseId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }
}
