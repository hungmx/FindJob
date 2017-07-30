package com.example.bearpanda.findjob.category.view;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bearpanda.findjob.R;
import com.example.bearpanda.findjob.category.model.CategoryAdapter;
import com.example.bearpanda.findjob.category.model.Category_;
import com.example.bearpanda.findjob.category.presenter.CategoryPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by BearPanda on 7/18/2017.
 */

public class CategoryFragment extends Fragment implements CategoryView{
    @BindView(R.id.rvCategory) RecyclerView rvCategory;
    CategoryAdapter adapter;
    CategoryPresenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_category, container, false);

        ButterKnife.bind(this, view);
        presenter = new CategoryPresenter(this);
        presenter.loadDataCategory();

        return view;
    }

    @Override
    public void displayCategory(List<Category_> list) {
        adapter = new CategoryAdapter(getActivity(), list);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        rvCategory.setLayoutManager(layoutManager);
        rvCategory.setHasFixedSize(true);
        rvCategory.setItemAnimator(new DefaultItemAnimator());
        rvCategory.setAdapter(adapter);

    }
}
