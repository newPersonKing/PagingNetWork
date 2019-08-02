package com.temp.pagingnetwork.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.temp.pagingnetwork.factory.CustomPositionalFactory

class PositionalViewModel :ViewModel(){


    var livePagedListBuilder = LivePagedListBuilder(CustomPositionalFactory(),PagedList.Config.Builder()
            .setPageSize(10)
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(20)
            .build()).setInitialLoadKey(20).build()

}