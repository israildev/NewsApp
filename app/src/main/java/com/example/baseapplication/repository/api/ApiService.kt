package com.example.baseapplication.repository.api

import com.example.baseapplication.repository.models.NewsResponse
import com.example.baseapplication.utill.Constants
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(Constants.RANDOM_URL)
    fun fetchNews(@Query("q") query: String): Observable<NewsResponse>
}