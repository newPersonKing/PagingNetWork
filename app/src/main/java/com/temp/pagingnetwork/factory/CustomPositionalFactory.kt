package com.temp.pagingnetwork.factory

import androidx.paging.DataSource
import com.temp.pagingnetwork.datasource.CustomItemKeyedDataSource
import com.temp.pagingnetwork.datasource.CustomPositionalDataSource
import com.temp.pagingnetwork.model.ArticleModel

class CustomPositionalFactory : DataSource.Factory<Int,ArticleModel>(){
    override fun create(): DataSource<Int, ArticleModel> {

        return CustomPositionalDataSource()
    }
}