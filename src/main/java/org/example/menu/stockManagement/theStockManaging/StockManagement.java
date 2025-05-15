package org.example.menu.stockManagement.theStockManaging;

import org.example.menu.Menu;

import java.util.Scanner;

public class StockManagement {
    public static void stockManagementMenu(int warehouseId) {
        System.out.println("Выберите:" +
                "\n1) Нанять сотрудника" +
                "\n2) Уволить сотрудника" +
                "\n3) Посмотреть информацию о складе" +
                "\n4) Закупить товар" +
                "\n5) Вернуться назад");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                HireEmployee.hireEmployee(warehouseId);
                break;
            case 2:
                FireEmployee.fireEmployee(warehouseId);
                break;
            case 3:
                WatchInfo.watchInfo(warehouseId);
                break;
            case 4:

                break;
            case 5:
                Menu.mainMenu();
                break;
        }
    }
}
