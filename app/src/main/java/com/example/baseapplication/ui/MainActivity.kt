package com.example.baseapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.baseapplication.R
import com.example.baseapplication.repository.models.Article
import com.example.baseapplication.ui.adapter.NewsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel by viewModels<MainViewModel>()
    private lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = NewsAdapter(mutableListOf(),this)
        rvNews.adapter = adapter
        rvNews.layoutManager = LinearLayoutManager(this)
        fetchData()
    }

    private fun fetchData() {
        mainViewModel.fetchNewsInfo()
        mainViewModel.response.observe(this) { response ->
            setupData(response.articles?.toMutableList())
        }
    }

    private fun setupData(news: MutableList<Article>?) {
        news?.let { adapter.addNews(it) }
    }
}