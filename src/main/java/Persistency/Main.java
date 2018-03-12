package Persistency;

import Controller.CategoryController;
import Controller.PriceController;
import Model.Category;

public class Main {
    public static void main(String[] args){

       BaseDAO bdao = new BaseDAO();

       bdao.getlocalConnection();

    }
}
