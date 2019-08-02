package com.temp.pagingnetwork.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.temp.pagingnetwork.factory.PageKeyDataSourceFactory

class PageKeyViewModel :ViewModel(){

    val livePagedListBuilder = LivePagedListBuilder(PageKeyDataSourceFactory(),PagedList.Config.Builder()
            .setPageSize(10)
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(20)
            .build()).build()
}