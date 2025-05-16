package org.example.menu.generalManagementMethods;

import org.example.menu.stockManagement.theStockManaging.StockManagement;
import org.example.methods.otherMethods.ClearConsole;
import org.example.methods.userMethods.EmployeeMethods;
import org.example.model.users.Employee;

import java.util.Scanner;

public class HireEmployee {
    public static void hireEmployee(int warehouseId, String post) {
        ClearConsole.clearConsole();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите кол-во работников для наёма");
        int hiringCount = scanner.nextInt();
        ClearConsole.clearConsole();
        for (int i = 0; i < hiringCount; i++) {
            Employee employee = new Employee(warehouseId, post);
            EmployeeMethods.hireEmployee(employee);
            System.out.println("Вы наняли " + employee.getFullName());
        }
    }
}
