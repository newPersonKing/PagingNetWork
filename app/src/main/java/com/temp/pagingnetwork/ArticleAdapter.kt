package com.temp.pagingnetwork

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.temp.pagingnetwork.model.ArticleModel

class ArticleAdapter :PagedListAdapter<ArticleModel,ArticleViewHolder>(diffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
         var itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_str,parent,false)
        return ArticleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        Log.i("cccccccccccc","total=="+itemCount)
       holder.bindData(getItem(position)!!)
    }


    /*静态 static 直接初始化 内容可以直接当参数 传递给super*/
    companion object {

        private val diffCallback = object : DiffUtil.ItemCallback<ArticleModel>() {
            override fun areContentsTheSame(oldItem: ArticleModel, newItem: ArticleModel): Boolean =   oldItem == newItem

            override fun areItemsTheSame(oldItem: ArticleModel, newItem: ArticleModel): Boolean = oldItem.title == newItem.title
        }
    }

}