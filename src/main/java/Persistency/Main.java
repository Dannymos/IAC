package Persistency;

import Controller.PriceController;

public class Main {
    public static void main(String[] args){

       CategoryDAO cdao = new CategoryDAO();

       System.out.println(cdao.getAllCategories());
    }
}
