package com.poojab26.recyclerview_retrofit_basic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.poojab26.recyclerview_retrofit_basic.Adapter.RecipeAdapter;
import com.poojab26.recyclerview_retrofit_basic.Interfaces.RetrofitInterface;
import com.poojab26.recyclerview_retrofit_basic.Model.Recipe;
import com.poojab26.recyclerview_retrofit_basic.Utils.APIClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecipeAdapter recipeAdapter;
    RetrofitInterface retrofitInterface;
    RecyclerView recipeRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recipeRecyclerView = (RecyclerView) findViewById(R.id.rvRecipes);
        layoutManager = new LinearLayoutManager(this);
        recipeRecyclerView.setLayoutManager(layoutManager);
        loadRecipes();

    }

    private void loadRecipes() {

        retrofitInterface = APIClient.getClient().create(RetrofitInterface.class);

        Call<List<Recipe>> call = retrofitInterface.getRecipeList();
        call.enqueue(new Callback<List<Recipe>>() {
            @Override
            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {

                List<Recipe> recipes = response.body();
               // Recipe[] placelist = gson.fromJson(response, Recipe[].class);

                Log.d("TAG", recipes.get(0).getName());

                recipeRecyclerView.setAdapter(new RecipeAdapter(recipes, new RecipeAdapter.OnItemClickListener() {
                    @Override public void onItemClick(int position) {
                        Log.d("TAG", "inside main");
                    }
                }));
            }

            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {
                Log.d("Error", t.getMessage());


            }
        });


    }
}
