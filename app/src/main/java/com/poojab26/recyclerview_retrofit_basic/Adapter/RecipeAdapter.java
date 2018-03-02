package com.poojab26.recyclerview_retrofit_basic.Adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.poojab26.recyclerview_retrofit_basic.Model.Recipe;
import com.poojab26.recyclerview_retrofit_basic.R;

import java.util.List;

/**
 * Created by poojab26 on 02-Mar-18.
 */

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder>{
    public RecipeAdapter(List<Recipe> recipes, OnItemClickListener listener) {
        recipeList = recipes;
        mListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private final List<Recipe> recipeList;
    private final OnItemClickListener mListener;


    @Override
    public RecipeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_recycler_view_item, parent, false);
        return new ViewHolder(view);    }

    @Override
    public void onBindViewHolder(RecipeAdapter.ViewHolder holder, int position) {
        holder.bind(position, mListener);

    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvId, tvName;

        public ViewHolder(View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.tv_id);
            tvName = itemView.findViewById(R.id.tvName);
        }

        public void bind(final int position, final OnItemClickListener listener) {
            tvId.setText(Integer.toString(recipeList.get(position).getId()));
            tvName.setText(recipeList.get(position).getName());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onItemClick(position);
                    Log.d("TAG", "clicked" + position);
                }
            });
        }
        }
}
