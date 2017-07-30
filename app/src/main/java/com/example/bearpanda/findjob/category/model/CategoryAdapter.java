package com.example.bearpanda.findjob.category.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bearpanda.findjob.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by BearPanda on 7/27/2017.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private Context context;
    private List<Category_> list;

    public CategoryAdapter(Context context, List<Category_> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        CategoryViewHolder holder = new CategoryViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        Category_ category = list.get(position);
        holder.tvNameCategory.setText(category.getName());;
//        holder.tvCount.setText(list.size());
        Glide.with(context)
                .load("http://hihidongoc.esy.es/public/images/categories/" + category.getImage())
                .into(holder.imThumbail);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imThumbail)
        ImageView imThumbail;
        @BindView(R.id.tvNameCategory)
        TextView tvNameCategory;
        @BindView(R.id.tvCount)
        TextView tvCount;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
