package Persistency;

import Controller.PriceController;
import Model.Category;

public class Main {
    public static void main(String[] args){

       CategoryDAO cdao = new CategoryDAO();

       for( Category i: cdao.getSubCategories(1)){

           System.out.println(i.toJson());
       }

    }
}
