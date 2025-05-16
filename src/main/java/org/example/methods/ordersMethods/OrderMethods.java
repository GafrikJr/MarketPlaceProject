package org.example.methods.ordersMethods;

import org.example.model.orders.Order;
import org.example.model.orders.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OrderMethods {
    private static final File ORDER_TXT = new File("C://Users/Тимур/Documents/GitHub/MarketPlaceProject/Orders.txt");

    public static Order getOrderById(int id) {
        Order order = null;
        String[] columns = new String[5];
        try {
            Scanner scanner = new Scanner(ORDER_TXT);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                columns = scanner.nextLine().split("  ");
                if (Integer.parseInt(columns[0]) == id) {
                    order = new Order(Integer.parseInt(columns[0]), Integer.parseInt(columns[1]), Integer.parseInt(columns[2]), Integer.parseInt(columns[3]), Integer.parseInt(columns[4]));
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return order;
    }
}
