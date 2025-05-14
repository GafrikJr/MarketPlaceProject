package org.example.menu.stockManagement.theStockManaging;

import org.example.methods.warehousesMethods.StockMethods;
import org.example.methods.warehousesMethods.WarehouseMethods;
import org.example.model.warehouses.Stock;

import java.util.Scanner;

public class WatchInfo {
    public static void watchInfo() {
        StockMethods.printAllStocks();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id склада: ");
        int warehouseId = scanner.nextInt();
        Stock stock = StockMethods.getStockByWarehouseId(warehouseId);
        WarehouseMethods.printCellsContent(stock.getStockId());

    }
}
