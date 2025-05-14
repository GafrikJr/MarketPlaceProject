package org.example.menu;

import org.example.menu.stockManagement.CloseStock;
import org.example.menu.stockManagement.OpenNewStock;
import org.example.menu.stockManagement.StockMenu;
import org.example.methods.otherMethods.ClearConsole;

import java.util.Scanner;

public class Menu {
    public static void mainMenu() {
        ClearConsole.clearConsole();
        System.out.println("Выберите опцию: " +
                "\n1) Управление складами" +
                "\n2) Управление ПВЗ" +
                "\n3) Информация о бизнесе");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                StockMenu.menu();
                break;
            case 2:
                break;
            case 3:

                break;
        }
    }
}

//1) Управление складами
//2) Управление ПВЗ
//3) Информация о бизнесе
