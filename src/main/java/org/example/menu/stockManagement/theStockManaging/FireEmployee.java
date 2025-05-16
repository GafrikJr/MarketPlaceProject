package org.example.menu.stockManagement.theStockManaging;

import org.example.methods.otherMethods.ClearConsole;
import org.example.methods.userMethods.EmployeeMethods;
import org.example.methods.warehousesMethods.WarehouseMethods;

import java.util.Scanner;

public class FireEmployee {
    public static void fireEmployee(int warehouseId) {
        ClearConsole.clearConsole();
        Scanner scanner = new Scanner(System.in);
        WarehouseMethods.printStaff(warehouseId);
        System.out.println("\nВведите id рабочего, которого хотите уволить:");
        int employeeId = scanner.nextInt();
        EmployeeMethods.fireEmployeeById(employeeId);

        ClearConsole.clearConsole();
        System.out.println("Если хотите уволить еще сотрудника - нажмите 1" +
                "\nЕсли хотите вернуться назад - нажмите 2");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                fireEmployee(warehouseId);
                break;
            case 2:
                StockManagement.stockManagementMenu(warehouseId);
                break;
        }
    }
}
