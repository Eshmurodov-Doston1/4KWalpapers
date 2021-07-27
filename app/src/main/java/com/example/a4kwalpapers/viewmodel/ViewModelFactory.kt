package com.example.a4kwalpapers.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.a4kwalpapers.retrofit.ApiServise
import java.lang.IllegalArgumentException

class ViewModelFactory(var category:String,var apiServise: ApiServise):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AppViewModel::class.java)){
            return AppViewModel(category,apiServise) as T
        }
        throw IllegalArgumentException("Error Factory")
    }
}