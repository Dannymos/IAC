package Controller;

import Model.Product;
import Model.Offer;

import Persistency.ProductDAO;

import java.util.ArrayList;

public class ProductController {

    private ProductDAO dao = new ProductDAO();

    public ProductController() {

    }

    public Product getProduct(int id) {
        return dao.getProduct(id);
    }

    public ArrayList<Product> getAllProducts() {
        return dao.getAllProducts();
    }

    public boolean editProduct(int id, Product product) {
        return dao.editProduct(id, product);
    }

    public boolean addProduct(Product product) {
       return dao.addProduct(product);
    }

    public boolean deleteProduct(int id) {
        return dao.deleteProduct(id);
    }
}