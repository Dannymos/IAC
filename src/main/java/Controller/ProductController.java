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

        boolean added = dao.addProduct(product);
         int id = dao.getLatestProduct().getId();
         pcdao.addProductToCategory(id,44);
         return added;
    }
    public boolean updateCategoryOfProduct(int product,int category){
       return pcdao.addProductToCategory(product,category);
    }

    public boolean deleteProduct(int id) {
        return dao.deleteProduct(id);
    }

    public ArrayList<Product> getAllProductsFromCategory(int category){

        ArrayList<Product> products = new ArrayList<Product>();
        ArrayList<ProdCats> prodcats = pcdao.getAllProdCatsByCategory(category);
        System.out.println(prodcats);
        for(ProdCats i : prodcats){
            products.add(dao.getProduct(i.getProduct()));
        }
        return products;
    }
    public ArrayList<Product> getAllProductsOnOffer(){
        ArrayList<Product> products = dao.getAllProducts();
        ArrayList<Product> results = new ArrayList<Product>();

        for(Product i: products){

            if (i.getOffer() != null)
                results.add(i);

        }
        System.out.println(results);
        return results;
    }

}