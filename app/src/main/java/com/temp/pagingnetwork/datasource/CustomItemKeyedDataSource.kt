package com.temp.pagingnetwork.datasource

import androidx.paging.ItemKeyedDataSource
import com.temp.pagingnetwork.model.ArticleModel

class CustomItemKeyedDataSource : ItemKeyedDataSource<Int,ArticleModel>(){

    /*初始加载的数据 也就是 你直接能看见的数据*/
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<ArticleModel>) {
        callback.onResult(getData(2),0,10)
    }

    /*往下滑动加载的数据 根据最底部的数据的key 加载数据*/
    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<ArticleModel>) {
        callback.onResult(getData(params.key))
    }

    /*往上滑的时候加载的数据 根据最顶部的数据的key加载数据*/
    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<ArticleModel>) {
        callback.onResult(getData(params.key))
    }

    override fun getKey(item: ArticleModel): Int {
        return item.index
    }


    private fun getData(page:Int):MutableList<ArticleModel>{
        var list = mutableListOf<ArticleModel>()
        for(page in page*10+1..(page+1)*10){
            var articleModel = ArticleModel("title==="+page,page)
            list.add(articleModel)
        }
        return list
    }

}