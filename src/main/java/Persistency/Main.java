package Persistency;

import Controller.CategoryController;
import Controller.OrderController;
import Controller.PriceController;
import Controller.ProductController;
import Model.Category;
import Model.Product;
import static Model.Product.ProductBuilder.aProduct;

public class Main {
    public static void main(String[] args){

        OrderController oc = new OrderController();
        CategoryController cc = new CategoryController();
        ProductController pc = new ProductController();
        System.out.println(cc.getAllSubCategoriesList());
        Product product = aProduct()
                .setExplanation("book")
                .setId(3)
                .setImage("https://kristinhannah.com/wp-content/uploads/2017/07/the-great-alone-kristin-hannah-hi-res.jpg")
                .setName("The Great Alone: A Novel")
                .setPrice(6.8)
                .build();
        System.out.println(pc.editProduct(product));
    }
}
