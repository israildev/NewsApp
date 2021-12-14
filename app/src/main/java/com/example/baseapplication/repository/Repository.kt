package com.example.baseapplication.repository

import com.example.baseapplication.repository.models.DogResponse
import com.example.baseapplication.repository.api.ApiService
import dagger.hilt.android.scopes.ActivityRetainedScoped
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(private val dogService: ApiService) {


        fun fetchDogInfo(): Observable<DogResponse> {
            return dogService.getDog()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }
}