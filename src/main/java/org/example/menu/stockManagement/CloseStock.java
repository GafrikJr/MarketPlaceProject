package org.example.menu.stockManagement;

import org.example.methods.warehousesMethods.StockMethods;
import org.example.model.warehouses.Stock;

import java.util.List;
import java.util.Scanner;

public class CloseStock {
    public static void closeStock() {
        Scanner scanner = new Scanner(System.in);
        StockMethods.printAllStocks();
        System.out.println("Напишите id склада, который хотите закрыть:");
        int warehouseId = scanner.nextInt();
        StockMethods.closeStockById(warehouseId);
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
