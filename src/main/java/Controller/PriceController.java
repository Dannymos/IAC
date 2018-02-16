package Controller;

public class PriceController {

    public float calcTaxPrice(float percentage, float price){

        percentage = percentage /100;

        return price * percentage;
    }
}
