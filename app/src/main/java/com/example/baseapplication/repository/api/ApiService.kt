package com.example.baseapplication.repository.api

import com.example.baseapplication.repository.models.DogResponse
import com.example.baseapplication.utill.Constants
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {
    @GET(Constants.RANDOM_URL)
    fun getDog(): Observable<DogResponse>
}