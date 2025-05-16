package org.example.menu.sellpointManagement.sellpointManaging;

import org.example.methods.ordersMethods.OrderMethods;
import org.example.methods.warehousesMethods.WarehouseMethods;
import org.example.model.orders.Order;
import org.example.model.warehouses.Cell;
import org.example.model.warehouses.Warehouse;

import java.util.List;

public class PrintSalesHistory {
    public static void printSalesHistory(int warehouseId) {
        List<Order> orders = OrderMethods.getSellPointOrders(warehouseId);
        if (!orders.isEmpty()) {
            for (Order order : orders) {
                order.printInfo();
            }
        }
        else {
            System.out.println("Еще не совершались продажи у данного ПВЗ");
        }

    }
}
