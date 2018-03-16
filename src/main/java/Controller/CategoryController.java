package Controller;

import Model.Category;
import Persistency.CategoryDAO;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static Model.Category.CategoryBuilder.aCategory;
public class CategoryController {

    CategoryDAO cdao = new CategoryDAO();

    public ArrayList<Category> getMainCategories(){





        return cdao.getMainCategories();
    }
    public ArrayList<Category> getSubCategories(int id){



        return cdao.getSubCategories(id);
    }
    public ArrayList<Category> getAllSubCategoriesList(){
        ArrayList<Category> results = new ArrayList<Category>();

        ArrayList<Category> categories = cdao.getAllSubCategories();
        for(Category i:categories){

           results.add(aCategory()
           .setId(i.getId())
           .setName(i.getName())
           .build());
        }
        return results;
    }
    public boolean addMainCategory(Category category){

        return cdao.addMainCategory(category);

    }
    public boolean addSubCategory(Category category,int maincategory){

        return cdao.addSubCategory(category,maincategory);

    }
}
