package com.example.bearpanda.findjob.category.presenter;

import com.example.bearpanda.findjob.category.model.CategoryInterator;
import com.example.bearpanda.findjob.category.model.Category_;
import com.example.bearpanda.findjob.category.model.LoadCategoryListener;
import com.example.bearpanda.findjob.category.view.CategoryView;

import java.util.List;

/**
 * Created by BearPanda on 7/30/2017.
 */
//nhan du lieu tu M thong qua callback => day qua cho V
public class CategoryPresenter implements LoadCategoryListener{
    //khai bao ModelData va interfaceView
    CategoryInterator modelData;
    CategoryView categoryView;

    public CategoryPresenter(CategoryView categoryView) {
        this.categoryView = categoryView;
        modelData = new CategoryInterator(this);
    }

    //goi ben Main
    //thang nay se goi den cac xu ly ben model
    public void loadDataCategory(){
        modelData.createListCategory();
    }
//---------------------------------------------
    @Override
    public void onLoadCategorySuccess(List<Category_> listCategory) {
            //gui sang cho View
        categoryView.displayCategory(listCategory);
    }

    @Override
    public void onLoadDemoFail(String message) {

    }
}
