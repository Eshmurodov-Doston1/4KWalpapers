package com.example.a4kwalpapers.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.a4kwalpapers.paging.PagerDataSource
import com.example.a4kwalpapers.retrofit.ApiServise

class AppViewModel(var category:String,var apiServise: ApiServise):ViewModel() {
    var unsplashImage = Pager(PagingConfig(30)){
        PagerDataSource(category,apiServise)
    }.flow.cachedIn(viewModelScope)
}