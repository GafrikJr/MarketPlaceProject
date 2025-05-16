package org.example.methods.ordersMethods;

import org.example.model.orders.Order;
import org.example.model.orders.OrderList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OrderListMethods {
    private static final File ORDER_LIST_TXT = new File("C://Users/Тимур/Documents/GitHub/MarketPlaceProject/Order_Lists.txt");

    public static OrderList getOrderListById(int id) {
        OrderList orderList = null;
        String[] columns = new String[3];
        try {
            Scanner scanner = new Scanner(ORDER_LIST_TXT);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                columns = scanner.nextLine().split("  ");
                if (Integer.parseInt(columns[0]) == id) {
                    orderList = new OrderList(Integer.parseInt(columns[0]), Integer.parseInt(columns[1]), Integer.parseInt(columns[2]));
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return orderList;
    }
}
