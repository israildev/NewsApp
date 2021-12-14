package com.example.baseapplication.ui

import android.util.Log
import androidx.lifecycle.*
import com.example.baseapplication.repository.Repository
import com.example.baseapplication.repository.models.NewsResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    private val _response: MutableLiveData<NewsResponse> = MutableLiveData()
    val response: LiveData<NewsResponse> = _response

    private val disposable: CompositeDisposable by lazy {
        return@lazy CompositeDisposable()
    }

    fun fetchNewsInfo(category: String = "apple") {
        disposable.add(
            repository.fetchNewsInfo(category)
                .subscribe({ _response.value = it },{Log.e("ISRAIL",it.localizedMessage)})
        )
    }
}