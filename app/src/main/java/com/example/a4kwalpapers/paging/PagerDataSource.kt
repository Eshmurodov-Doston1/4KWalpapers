package com.example.a4kwalpapers.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.a4kwalpapers.models.Result
import com.example.a4kwalpapers.models.load.MyCategoryImags
import com.example.a4kwalpapers.retrofit.ApiServise
import com.example.a4kwalpapers.utils.MyList
import java.lang.Exception

class PagerDataSource(var category: String,var apiServise: ApiServise):PagingSource<Int,Result>() {
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
      try {
          val number = params.key?:1
          val image = apiServise.getImage(category,number)
          if (number>1){
              MyList.listResult.add(MyCategoryImags(category,image.results))
              return LoadResult.Page(image.results,number-1,number+1)
          }else{
              return LoadResult.Page(image.results,null,number+1)
          }
      }catch (e:Exception){
          return LoadResult.Error(e)
      }
    }

}