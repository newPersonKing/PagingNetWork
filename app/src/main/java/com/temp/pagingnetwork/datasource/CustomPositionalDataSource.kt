package com.temp.pagingnetwork.datasource

import android.util.Log
import androidx.paging.PositionalDataSource
import com.temp.pagingnetwork.model.ArticleModel

class CustomPositionalDataSource : PositionalDataSource<ArticleModel>(){

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<ArticleModel>) {
        callback.onResult(getData(5))
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<ArticleModel>) {
        /*第二个参数 表示的是 当前要加载的数据 开始的position*/
        /*比如 getpage 返回20个数据 position 是30 那么按理来说 getpage 返回的数据 加载是 第一个下标 就应该是30*/
        /*但是又因为loadRange 每次提交的数据 不一定是30 个 如果是超过30个 那就会 加载完loadRange 返回的所有数据 才会加载loadInitial
        * 的数据 如果不够三十个 就再次执行loadRange  知道总数大于30 才会加载loadInitial的数据*/
        callback.onResult(getData(1),30)
    }
}


private fun getData(page:Int):MutableList<ArticleModel>{
    var list = mutableListOf<ArticleModel>()
    for(page in page*10+1..(page+2)*10){
        var articleModel = ArticleModel("title==="+page,page)
        list.add(articleModel)
    }
    return list
}
