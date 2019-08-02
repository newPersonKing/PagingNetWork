package com.temp.pagingnetwork.factory

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.temp.pagingnetwork.datasource.CustomItemKeyedDataSource
import com.temp.pagingnetwork.model.ArticleModel

class ItemKeyFactory : DataSource.Factory<Int,ArticleModel>(){


    override fun create(): DataSource<Int, ArticleModel> {
        var customItemKeyedDataSource = CustomItemKeyedDataSource();
        return   customItemKeyedDataSource;
    }
}