package Controller;

import Model.Category;
import Persistency.CategoryDAO;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class CategoryController {

    CategoryDAO cdao = new CategoryDAO();

    public ArrayList<Category> getMainCategories(){





        return cdao.getMainCategories();
    }
    public ArrayList<Category> getSubCategories(int id){



        return cdao.getSubCategories(id);
    }
    public JSONObject getAllSubCategoriesList(){
        JSONObject jo = new JSONObject();
        jo.put("firstName", "John");
        jo.put("lastName", "Doe");
        ArrayList<Category> categories = cdao.getAllSubCategories();
        for(Category i:categories){

            jo.put(Integer.toString(i.getId()),i.getName());
        }
        return jo;
    }
    public boolean addMainCategory(Category category){

        return cdao.addMainCategory(category);

    }
    public boolean addSubCategory(Category category,int maincategory){

        return cdao.addSubCategory(category,maincategory);

    }
}
