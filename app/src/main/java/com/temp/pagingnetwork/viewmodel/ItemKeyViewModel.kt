package com.temp.pagingnetwork.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.temp.pagingnetwork.factory.ItemKeyFactory

class ItemKeyViewModel :ViewModel(){


    var livePagedListBuilder = LivePagedListBuilder(ItemKeyFactory(),PagedList.Config.Builder()
            .setPageSize(10)
            .setEnablePlaceholders(false)
            .build()).build()

}