package Controller;

import Model.ProdCats;
import Model.Product;
import Model.Offer;

import Persistency.ProdCatDAO;
import Persistency.ProductDAO;

import java.util.ArrayList;

public class ProductController {

    private ProductDAO dao = new ProductDAO();
    private ProdCatDAO pcdao = new ProdCatDAO();
    public ProductController() {

    }

    public Product getProduct(int id) {
        return dao.getProduct(id);
    }

    public ArrayList<Product> getAllProducts() {
        return dao.getAllProducts();
    }

    public boolean editProduct(Product product) {
        return dao.editProduct(product);
    }

    public boolean addProduct(Product product) {
       return dao.addProduct(product);
    }

    public boolean deleteProduct(int id) {
        return dao.deleteProduct(id);
    }

    public ArrayList<Product> getAllProductsFromCategory(int category){

        ArrayList<Product> products = new ArrayList<Product>();
        ArrayList<ProdCats> prodcats = pcdao.getAllProdCatsByCategory(category);

        for(ProdCats i : prodcats){
            products.add(dao.getProduct(i.getId()));
        }
        return products;
    }
}