package com.example.bearpanda.findjob.category.model;

import java.util.List;

/**
 * Created by BearPanda on 7/27/2017.
 */
//lang nghe du lieu tu model va gui lai cho presenter
public interface LoadCategoryListener {
    void onLoadCategorySuccess(List<Category_> listCategory);
    void onLoadDemoFail(String message);
}
