package com.temp.pagingnetwork

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.temp.pagingnetwork.model.ArticleModel
import kotlinx.android.synthetic.main.item_str.view.*

class ArticleViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView){

      fun bindData(articleModel: ArticleModel){
          itemView.tv_str.text = articleModel.title
      }

}