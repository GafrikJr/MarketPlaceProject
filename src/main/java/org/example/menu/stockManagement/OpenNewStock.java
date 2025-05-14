package org.example.menu.stockManagement;

import org.example.methods.warehousesMethods.StockMethods;
import org.example.model.warehouses.Warehouse;

import java.util.Scanner;

public class OpenNewStock {
    public static void openNewStock() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите зарплатный бюджет склада: ");
        int salaryBudget = scanner.nextInt();
        System.out.println("Введите вместимость склада: ");
        int capacity = scanner.nextInt();
        Warehouse warehouse = new Warehouse(salaryBudget, capacity);
        StockMethods.openStock(warehouse);
    }
}
