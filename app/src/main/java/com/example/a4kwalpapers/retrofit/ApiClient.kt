package com.example.a4kwalpapers.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    const val BASE_URL="https://api.unsplash.com/search/photos/"

    fun getRetrofit(): Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }
    var apiServise = ApiClient.getRetrofit().create(ApiServise::class.java)
}