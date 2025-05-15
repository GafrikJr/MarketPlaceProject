package org.example.menu.stockManagement.theStockManaging;

import org.example.methods.warehousesMethods.StockMethods;

import java.util.Scanner;

public class ChooseStock {
    public static void chooseStock() {
        Scanner scanner = new Scanner(System.in);
        StockMethods.printAllStocks();
        System.out.println("Введите id склада: ");
        int warehouseId = scanner.nextInt();
        StockManagement.stockManagementMenu(warehouseId);
    }
}
