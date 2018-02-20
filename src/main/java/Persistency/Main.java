package Persistency;

import Controller.CategoryController;
import Controller.PriceController;
import Model.Category;

public class Main {
    public static void main(String[] args){

       CategoryController cdao = new CategoryController();

      System.out.println(cdao.getMainCategories());

    }
}
