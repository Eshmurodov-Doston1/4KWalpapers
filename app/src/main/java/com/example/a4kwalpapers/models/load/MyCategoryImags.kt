package com.example.a4kwalpapers.models.load

import com.example.a4kwalpapers.models.Result

class MyCategoryImags {
    var category:String?=null
   var listResult:List<Result>?=null

    constructor(category: String?, listResult: List<Result>?) {
        this.category = category
        this.listResult = listResult
    }
}