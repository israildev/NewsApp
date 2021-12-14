package com.example.baseapplication.ui

import android.util.Log
import androidx.lifecycle.*
import com.example.baseapplication.repository.models.DogResponse
import com.example.baseapplication.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    private val _response: MutableLiveData<DogResponse> = MutableLiveData()
    val response: LiveData<DogResponse> = _response

    private val disposable: CompositeDisposable by lazy {
        return@lazy CompositeDisposable()
    }

    fun fetchDogResponse() {
        disposable.add(
            repository.fetchDogInfo()
                .subscribe({ _response.value = it },{Log.e("ISRAIL",it.localizedMessage)})
        )
    }
}