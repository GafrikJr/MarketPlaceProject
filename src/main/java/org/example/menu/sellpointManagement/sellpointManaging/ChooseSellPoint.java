package org.example.menu.sellpointManagement.sellpointManaging;

import org.example.menu.stockManagement.theStockManaging.StockManagement;
import org.example.methods.warehousesMethods.SellPointMethods;
import org.example.methods.warehousesMethods.StockMethods;

import java.util.Scanner;

public class ChooseSellPoint {
    public static void chooseSellPoint() {
        Scanner scanner = new Scanner(System.in);
        SellPointMethods.printAllSellPoints();
        System.out.println("Введите id ПВЗ: ");
        int warehouseId = scanner.nextInt();
        SellPointManagement.sellPointManagementMenu(warehouseId);
    }
}
