package com.example.bearpanda.findjob.category.model;

import com.example.bearpanda.findjob.service.APIClient;
import com.example.bearpanda.findjob.service.APIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by BearPanda on 7/30/2017.
 */
//xu ly du lieu, tra ve cho P thong qua response Lister
public class CategoryInterator {
    LoadCategoryListener callback;
    APIService apiService;

    public CategoryInterator(LoadCategoryListener callback){
        this.callback = callback;
        apiService = APIClient.getClient().create(APIService.class);
    }
    //xu ly du lieu
    public void createListCategory(){
        Call<Category> response = apiService.getCategory();
        response.enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call<Category> call, Response<Category> response) {
                if (response.isSuccessful()){
                    callback.onLoadCategorySuccess(response.body().getCategories());
                }
            }

            @Override
            public void onFailure(Call<Category> call, Throwable t) {
                    callback.onLoadDemoFail(t.getMessage());
            }
        });

    }
}
