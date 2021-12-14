package com.example.baseapplication.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.baseapplication.R
import com.example.baseapplication.repository.models.Article

class NewsAdapter(private var dataSet: MutableList<Article>,private val context: Context) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvTitle: TextView = view.findViewById(R.id.tv_title)
        var tvSubtitle: TextView = view.findViewById(R.id.tv_subtitle)
        var imageView : ImageView = view.findViewById(R.id.img)
        var tvDate : TextView = view.findViewById(R.id.tv_date)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.news_row_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.tvTitle.text = dataSet[position].title
        viewHolder.tvSubtitle.text = dataSet[position].description
        viewHolder.tvDate.text = dataSet[position].publishedAt
        Glide.with(context)
            .load(dataSet[position].urlToImage)
            .into(viewHolder.imageView)
    }

    override fun getItemCount() = dataSet.size

    fun addNews(news: MutableList<Article>){
        this.dataSet.clear()
        this.dataSet = news
        notifyDataSetChanged()
    }

}