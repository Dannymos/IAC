package Persistency;

import Controller.CategoryController;
import Controller.OrderController;
import Controller.PriceController;
import Controller.ProductController;
import Model.Category;

public class Main {
    public static void main(String[] args){

        OrderController oc = new OrderController();

        System.out.println(oc.addProductToOrder(1,2,4));


    }
}
