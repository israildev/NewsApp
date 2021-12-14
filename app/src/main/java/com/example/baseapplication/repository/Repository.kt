package com.example.baseapplication.repository

import com.example.baseapplication.repository.api.ApiService
import com.example.baseapplication.repository.models.NewsResponse
import dagger.hilt.android.scopes.ActivityRetainedScoped
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(private val newsService: ApiService) {

        fun fetchNewsInfo(category: String): Observable<NewsResponse> {
            return newsService.fetchNews(category)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }
}