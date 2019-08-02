package com.temp.pagingnetwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.temp.pagingnetwork.viewmodel.ItemKeyViewModel
import com.temp.pagingnetwork.viewmodel.PageKeyViewModel
import com.temp.pagingnetwork.viewmodel.PositionalViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val pageKeyViewModel by lazy {
        ViewModelProviders.of(this).get(PageKeyViewModel::class.java)
    }

    private val positionalViewModel by lazy {
        ViewModelProviders.of(this).get(PositionalViewModel::class.java)
    }

    private val itemKeyViewModel by lazy {
        ViewModelProviders.of(this).get(ItemKeyViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler.layoutManager = LinearLayoutManager(this)
        var adapter = ArticleAdapter()
        recycler.adapter = adapter

//        positionalViewModel.livePagedListBuilder.observe(this, Observer {
//            adapter.submitList(it)
//        })



//        itemKeyViewModel.livePagedListBuilder.observe(this, Observer {
//            adapter.submitList(it)
//        })
//        itemKeyViewModel.livePagedListBuilder.value?.dataSource?.invalidate()

        /*加载数据*/
        pageKeyViewModel.livePagedListBuilder.observe(this, Observer {
            adapter.submitList(it)
        })
        /*刷新*/
        pageKeyViewModel.livePagedListBuilder.value?.dataSource?.invalidate()
    }
}
