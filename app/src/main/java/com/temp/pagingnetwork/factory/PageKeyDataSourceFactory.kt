package com.temp.pagingnetwork.factory

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.temp.pagingnetwork.datasource.CustomPageKeyDataSource
import com.temp.pagingnetwork.model.ArticleModel

class PageKeyDataSourceFactory() :DataSource.Factory<Int,ArticleModel>(){

    override fun create(): DataSource<Int, ArticleModel> {
        val dataSource = CustomPageKeyDataSource()
        return dataSource
    }
}