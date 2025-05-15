package org.example.methods.warehousesMethods;

import org.example.methods.otherMethods.HibernateMethods;
import org.example.model.users.Employee;
import org.example.model.warehouses.Cell;
import org.example.model.warehouses.Warehouse;
import java.util.List;

public class WarehouseMethods {

    public static Warehouse getWarehouseById(int id) {
        return HibernateMethods.getObjectById(id, Warehouse.class);
    }

    public static List<Warehouse> getWarehousesByRequest(Class<Warehouse> warehouseClass, String request) {
        return HibernateMethods.getObjectsByRequest(warehouseClass, request);
    }

    public static void deleteWarehouseById(int id, Class<Warehouse> warehouseClass) {
        HibernateMethods.deleteObjectById(id, warehouseClass);
    }

    public static void openWarehouse(Warehouse warehouse) {
        HibernateMethods.createEntry(warehouse, Warehouse.class);
    }

    public static void printCellsContent(int warehouseId) {
        List<Cell> cells = CellMethods.getWarehouseCells(warehouseId);
        for (Cell cell : cells) {
            cell.printContent(); // надо написать этот метод
        }
    }

    public static void printStaff(int warehouseId) {
        String request = "FROM Employee where placeOfWorkId = " + warehouseId;
        List<Employee> staff = HibernateMethods.getObjectsByRequest(Employee.class, request);
        System.out.println("Рабочий персонал:");
        for (Employee employee : staff) {
            System.out.println(employee.toString());
        }
    }
}
