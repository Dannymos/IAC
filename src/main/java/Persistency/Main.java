package Persistency;

import Controller.CategoryController;
import Controller.PriceController;
import Controller.ProductController;
import Model.Category;

public class Main {
    public static void main(String[] args){

        OrderDAO dao = new OrderDAO();
        OrderruleDAO odao = new OrderruleDAO();

        System.out.println(dao.getOrderByID(1));


    }
}
