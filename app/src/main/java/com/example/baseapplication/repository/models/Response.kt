package com.example.baseapplication.repository.models

data class NewsResponse(
    val status: String? = null,
    val totalResults: Int? = null,
    val articles: List<Article>? = null
)

data class Article(
   val author: String? = null,
   val title: String? = null,
   val description: String? = null,
   val url: String? = null,
   val urlToImage: String? = null,
   val publishedAt: String? = null,
   val content: String? = null,
   val source: SourceInfo ?= null
)

data class SourceInfo(
    val id:String? = null,
    val name: String? = null,
)