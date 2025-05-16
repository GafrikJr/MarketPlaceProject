package org.example.menu.stockManagement.theStockManaging;

import org.example.methods.otherMethods.ClearConsole;
import org.example.methods.warehousesMethods.StockMethods;
import org.example.methods.warehousesMethods.WarehouseMethods;
import org.example.model.warehouses.Stock;

import java.util.Scanner;

public class WatchInfo {
    public static void watchInfo(int warehouseId) {
        ClearConsole.clearConsole();
        WarehouseMethods.printStaff(warehouseId);
        WarehouseMethods.printCellsContent(warehouseId);

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nЧтобы вернуться назад - нажмите 1");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                StockManagement.stockManagementMenu(warehouseId);
                break;
        }

    }
}
