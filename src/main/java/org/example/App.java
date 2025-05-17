package org.example;

import org.example.menu.Menu;
import org.example.methods.ordersMethods.BuyerMethods;
import org.example.methods.ordersMethods.OrderMethods;
import org.example.methods.ordersMethods.RandomOrder;
import org.example.methods.otherMethods.HideLoggs;
import org.example.model.orders.Order;
import org.example.model.users.Buyer;

public class App {
    public static void main(String[] args) {
        HideLoggs.hideLoggs();
        Menu.mainMenu();
//        RandomOrder.makeOrderList(45, 46);
    }
}
