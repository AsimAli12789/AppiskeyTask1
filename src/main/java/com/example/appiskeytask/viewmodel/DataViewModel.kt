package com.example.appiskeytask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appiskeytask.model.ImageData
import com.example.appiskeytask.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(private val repository: DataRepository) : ViewModel() {
    private val _images = MutableLiveData<ArrayList<ImageData>>()
    val images: LiveData<ArrayList<ImageData>> get() = _images

    fun fetchImages(query: String) {
        viewModelScope.launch {
            val response = repository.getImages(query)
            if (response.isSuccessful) {
                _images.value = response.body()?.hits as ArrayList<ImageData>?
            }
        }
    }
}