package Persistency;

import Controller.CategoryController;
import Controller.OrderController;
import Controller.PriceController;
import Controller.ProductController;
import Model.Category;
import services.CategoryService;

public class Main {
    public static void main(String[] args){

        OrderController oc = new OrderController();
        CategoryController cc = new CategoryController();
        CategoryService cs = new CategoryService();
        System.out.println(cs.getMainCategories().getEntity());
//        System.out.println(oc.addProductToOrder(1,2,4));


    }
}
