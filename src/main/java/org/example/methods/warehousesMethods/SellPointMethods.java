package org.example.methods.warehousesMethods;

import org.example.methods.otherMethods.HibernateMethods;
import org.example.methods.otherMethods.RandomHuman;
import org.example.methods.userMethods.EmployeeMethods;
import org.example.model.users.Employee;
import org.example.model.warehouses.Cell;
import org.example.model.warehouses.SellPoint;
import org.example.model.warehouses.Warehouse;
import java.util.ArrayList;
import java.util.List;

public class SellPointMethods {

    public static SellPoint getSellPointById(int warehouseId) {
        return HibernateMethods.getObjectById(warehouseId, SellPoint.class);
    }

    public static void closeSellPointById(int warehouse_id) {
        HibernateMethods.deleteObjectById(warehouse_id, SellPoint.class);
        WarehouseMethods.deleteWarehouseById(warehouse_id, Warehouse.class);
    }

    public static void openSellPoint(Warehouse warehouse) {
        WarehouseMethods.openWarehouse(warehouse); // создали запись хранилища в БД
        SellPoint sellPoint = new SellPoint(
                warehouse.getId(),
                warehouse.getSalaryBudget(),
                warehouse.getCapacity()
        );
        HibernateMethods.createEntry(sellPoint, SellPoint.class);
        int managerId = EmployeeMethods.hireStaff(warehouse.getId(), 3, "seller");
        CellMethods.createCells(warehouse.getId(), warehouse.getCapacity());

        HibernateMethods.updateEntity(  // устанавливаем хранилищу managerId нанятого менеджера
                warehouse.getId(),
                Warehouse.class,
                _warehouse -> _warehouse.setManagerId(managerId)
        );

        HibernateMethods.updateEntity(
                sellPoint.getId(),
                SellPoint.class,
                _sellPoint -> _sellPoint.setManagerId(managerId)
        );


    }

    private static List<Employee> hireStaff(int warehouse_id) {
        List<Employee> staff = new ArrayList<>();
        String managerFullName = RandomHuman.randomHuman();
        String sellerFullName = RandomHuman.randomHuman();
        Employee manager = new Employee(warehouse_id, "manager");
        Employee seller = new Employee(warehouse_id, "seller");
        staff.add(manager);
        staff.add(seller);
        return staff;
    }

    private static List<Cell> openCells(int warehouse_id, int capacity) {
        List<Cell> cells = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            Cell cell = new Cell(warehouse_id);
            cells.add(cell);
        }
        return cells;
    }
}
