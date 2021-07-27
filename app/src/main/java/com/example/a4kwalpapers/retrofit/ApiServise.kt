package com.example.a4kwalpapers.retrofit

import com.example.a4kwalpapers.models.UnsplashData
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServise {
   @GET("?client_id=IqIHr46UT9upGwwFvo0QvOdXP784rc_FC0GKaBFM_oQ")
   suspend fun getImage(
      @Query("query")query:String,
      @Query("page")page:Int=20,
      @Query("per_page")per_page:Int,
      ):UnsplashData
}