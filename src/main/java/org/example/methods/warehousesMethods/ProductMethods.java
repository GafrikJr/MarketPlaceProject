package org.example.methods.warehousesMethods;

import org.example.methods.otherMethods.HibernateMethods;
import org.example.model.warehouses.Cell;
import org.example.model.warehouses.Product;

import java.util.List;

public class ProductMethods {
    public static Product getProductById(int productId) {
        Product product = HibernateMethods.getObjectById(productId, Product.class);
        return product;
    }
}
