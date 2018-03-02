package com.poojab26.recyclerview_retrofit_basic.Interfaces;

import com.poojab26.recyclerview_retrofit_basic.Model.Recipe;
import com.poojab26.recyclerview_retrofit_basic.Model.RecipeList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by poojab26 on 02-Mar-18.
 */

public interface RetrofitInterface {
//https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json
    @GET("baking.json")
    Call<List<Recipe>> getRecipeList();

}
