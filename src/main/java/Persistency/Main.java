package Persistency;

import Controller.CategoryController;
import Controller.PriceController;
import Controller.ProductController;
import Model.Category;

public class Main {
    public static void main(String[] args){

        ProductController pc = new ProductController();

        System.out.println(pc.getAllProductsFromCategory(11));

    }
}
