package Persistency;

import Model.ProdCats;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static Model.ProdCats.ProdCatsBuilder.aProdCats;

public class ProdCatDAO extends BaseDAO{

    private ArrayList<ProdCats> getProdCats(String query){
        ArrayList<ProdCats> results = new ArrayList<ProdCats>();
        try(Connection con = super.getConnection()){

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){

                int productid = rs.getInt("product_id");
                int categoryid = rs.getInt("category_id");
                int id = rs.getInt("category_product_id");

                ProdCats prodcat = aProdCats()
                        .setCategory(categoryid)
                        .setProduct(productid)
                        .setId(id)
                        .build();

                results.add(prodcat);
            }

        }

        catch(Exception e){
            e.printStackTrace();
        }
        return results;

    }

    public ArrayList<ProdCats> getAllProdCats(){
        return getProdCats("select * from category_product");
    }
    public ArrayList<ProdCats> getAllProdCatsByCategory(int category){
        return getProdCats("select * from category_product where category_id = "+category);
    }
    public ArrayList<ProdCats> getAllProdCatsByProduct(int product){
        return getProdCats("select * from category_product where product_id = "+product);
    }
}
