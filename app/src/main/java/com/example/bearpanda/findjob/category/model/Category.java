package com.example.bearpanda.findjob.category.model;

/**
 * Created by BearPanda on 7/27/2017.
 */
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("categories")
    @Expose
    private List<Category_> categories = null;

    public List<Category_> getCategories() {
        return categories;
    }

    public void setCategories(List<Category_> categories) {
        this.categories = categories;
    }

}