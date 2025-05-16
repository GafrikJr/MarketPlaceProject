package org.example.methods.ordersMethods;

import org.example.methods.otherMethods.HibernateMethods;
import org.example.methods.warehousesMethods.CellMethods;
import org.example.methods.warehousesMethods.WarehouseMethods;
import org.example.model.orders.Order;
import org.example.model.orders.OrderList;
import org.example.model.users.Buyer;
import org.example.model.warehouses.Cell;

import java.util.List;
import java.util.Random;

public class RandomOrder {
    public static void makeOrderList(int stockId, int sellPointId) {
        Random random = new Random();
        Buyer buyer = BuyerMethods.getBuyerById(random.nextInt(6) + 1);
        OrderList orderList = new OrderList(OrderListMethods.getLastId(), buyer.getId(), 0);
        List<Cell> stockCells = WarehouseMethods.getWarehouseCells(stockId);

        // тут мы создаем маленькое кол-во заказов из содержимого ячеек склада
        for (int i = 0; i < 3; i++) {
            for (Cell stockCell : stockCells) {
                if (stockCell.getProductId() != 0) { // значит в ячейке что-то лежит
                    Cell sellPointCell = CellMethods.getRandomVoidCell(sellPointId); // ячейка куда отправляем товар
                    Order order = new Order( // заказ, где cellId = id рандомной пустой ячейки в ПВЗ
                            OrderMethods.getLastId(),
                            orderList.getId(),
                            stockCell.getProductId(),
                            stockCell.getProductCount(),
                            sellPointCell.getId(),
                            ProductMethods.getProductById(stockCell.getProductId()).getSellCost());
                    OrderMethods.makeEntry(order); // делаем запись в txt
                    orderList.setTotalCost(orderList.getTotalCost() + order.getCost()); // обновляем стоимость order list'а
                    HibernateMethods.updateEntity(stockCell.getId(), Cell.class, _cell -> _cell.setProductId(0));
                    HibernateMethods.updateEntity(stockCell.getId(), Cell.class, _cell -> _cell.setProductCount(0)); // удалили товар из склада
                }
            }
        }
        OrderListMethods.makeEntry(orderList);
    }

    private static Cell transferProductToSellPoint(Cell stockCell, int sellPointId) {
        List<Cell> sellPointCells = WarehouseMethods.getWarehouseCells(sellPointId);
        Cell newCell = null;
        for (Cell sellPointCell : sellPointCells) {
            if (sellPointCell.getProductId() == 0) {
                newCell = sellPointCell;
                HibernateMethods.updateEntity(sellPointCell.getId(), Cell.class, _sellPointCell -> _sellPointCell.setProductId(stockCell.getProductId()));
                HibernateMethods.updateEntity(sellPointCell.getId(), Cell.class, _sellPointCell -> _sellPointCell.setProductCount(stockCell.getProductCount()));
                HibernateMethods.updateEntity(stockCell.getId(), Cell.class, _stockCell -> _stockCell.setProductId(0));
                HibernateMethods.updateEntity(stockCell.getId(), Cell.class, _stockCell -> _stockCell.setProductCount(0));
            }
        }
        return newCell;
    }
}
