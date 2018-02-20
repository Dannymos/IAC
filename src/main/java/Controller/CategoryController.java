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

        CategoryDAO cdao = new CategoryDAO();

        return cdao.getSubCategories(id);
    }
}
