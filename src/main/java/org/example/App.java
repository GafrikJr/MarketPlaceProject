package org.example;

import org.example.menu.Menu;
import org.example.methods.otherMethods.ClearConsole;
import org.example.methods.otherMethods.HibernateMethods;
import org.example.methods.otherMethods.HideLoggs;
import org.example.methods.userMethods.EmployeeMethods;
import org.example.methods.warehousesMethods.SellPointMethods;
import org.example.methods.warehousesMethods.StockMethods;
import org.example.model.users.Employee;
import org.example.model.warehouses.SellPoint;
import org.example.model.warehouses.Stock;
import org.example.model.warehouses.Warehouse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Menu.mainMenu();
    }
}
