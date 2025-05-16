package org.example.menu.stockManagement.theStockManaging;

import org.example.methods.otherMethods.HibernateMethods;
import org.example.methods.userMethods.EmployeeMethods;
import org.example.methods.warehousesMethods.WarehouseMethods;
import org.example.model.users.Employee;
import org.example.model.warehouses.Stock;
import org.example.model.warehouses.Warehouse;

import java.util.Scanner;

public class ChangeManager {
    public static void changeManager(int warehouseId) {
        Warehouse warehouse = WarehouseMethods.getWarehouseById(warehouseId);
        Employee newManager = new Employee(warehouseId, "manager");
        EmployeeMethods.hireEmployee(newManager);
        HibernateMethods.updateEntity(warehouseId, Warehouse.class, _warehouse -> _warehouse.setManagerId(newManager.getId()));
        HibernateMethods.updateEntity(warehouseId, Stock.class, _stock -> _stock.setManagerId(newManager.getId()));
        int managerId = warehouse.getManagerId();
        EmployeeMethods.fireEmployeeById(managerId);
        System.out.println("Теперь ваш новый менеджер: " + newManager.getFullName());

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
