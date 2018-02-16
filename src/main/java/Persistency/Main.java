package Persistency;

import Controller.PriceController;

public class Main {
    public static void main(String[] args){

        PriceController prc = new PriceController();

        System.out.println(prc.calcTaxPrice(20,200));
    }
}
