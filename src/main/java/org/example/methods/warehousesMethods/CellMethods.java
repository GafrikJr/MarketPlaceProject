package org.example.methods.warehousesMethods;

import org.example.methods.otherMethods.HibernateMethods;
import org.example.model.warehouses.Cell;
import org.example.model.warehouses.Product;

import java.util.ArrayList;
import java.util.List;

public class CellMethods {
    public static void createCell(Cell cell) {
        HibernateMethods.createEntry(cell, Cell.class);
    }

    public static void createCells(int warehouseId, int capacity) {
        for (int i = 0; i < capacity; i++) {
            Cell cell = new Cell(warehouseId);
            createCell(cell);
        }
    }

    public static void closeCells(int warehouse_id) {
        List<Cell> closedCells = getClosedCells(warehouse_id);
        for (Cell cell : closedCells) {
            HibernateMethods.deleteObjectById(cell.getId(), Cell.class);
        }
    }

    public static List<Cell> getWarehouseCells(int warehouseId) {
        List<Cell> cells = HibernateMethods.getObjectsByRequest(Cell.class, "FROM Cell");
        List<Cell> warehouseCells = new ArrayList<>();
        for (Cell cell : cells) {
            if (cell.getWarehouseId() == warehouseId) {
                warehouseCells.add(cell);
            }
        }
        return warehouseCells;
    }

    private static List<Cell> getClosedCells(int warehouse_id) {
        String request = "FROM Cell where warehouseId = " + warehouse_id;
        List<Cell> closedCells = HibernateMethods.getObjectsByRequest(Cell.class, request);
        return closedCells;
    }
}
