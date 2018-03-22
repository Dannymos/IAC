package Persistency;

import Controller.CategoryController;
import Controller.OrderController;
import Controller.PriceController;
import Controller.ProductController;
import Model.Category;
import Model.Order;
import Model.Product;
import static Model.Product.ProductBuilder.aProduct;
import static Model.Order.OrderBuilder.anOrder;
public class Main {
    public static void main(String[] args){

       UserDAO udao = new UserDAO();

       System.out.println(udao.registerUser("testt@testt.nl","testt"));
    }
}
