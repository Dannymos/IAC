package Controller;

import Model.Product;
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

    public boolean addProduct(int id, Product product) {
        dao.addProduct(id, product);
    }

    public boolean deleteProduct(int id) {
        return dao.deleteProduct(id);
    }
}
