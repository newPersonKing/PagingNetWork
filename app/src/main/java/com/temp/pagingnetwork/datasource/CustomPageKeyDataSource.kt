package com.temp.pagingnetwork.datasource

import androidx.paging.PageKeyedDataSource
import com.temp.pagingnetwork.model.ArticleModel

class CustomPageKeyDataSource : PageKeyedDataSource<Int,ArticleModel>(){

    /*初始加载的数据 也就是我们直接能看见的数据*/
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, ArticleModel>) {
        var list = getData(0)
        callback.onResult(list,0,1)
    }

    /*往下滑加载的数据 每次传递的第二个参数 就是 你加载数据依赖的key*/
    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, ArticleModel>) {
        callback.onResult(getData(params.key),params.key+1)
    }

    /*往上滑加载的数据 每次传递的第二个参数 就是 你加载数据依赖的key*/
    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, ArticleModel>) {
        callback.onResult(getData(params.key),params.key-1)
    }
}

private fun getData(page:Int):MutableList<ArticleModel>{
    var list = mutableListOf<ArticleModel>()
    for(page in page*10+1..(page+1)*10){
        var articleModel = ArticleModel("title==="+page,page)
        list.add(articleModel)
    }
    return list
}