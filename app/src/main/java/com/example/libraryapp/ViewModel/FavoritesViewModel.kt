package com.example.libraryapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.libraryapp.Domain.Repository
import com.example.libraryapp.Model.compras
import com.example.libraryapp.Model.favorites

class FavoritesViewModel : ViewModel() {
    private val repository = Repository()

    fun fetchFavoritesData(): LiveData<MutableList<favorites>> {
        val mutableLiveData= MutableLiveData<MutableList<favorites>>()
        repository.getFavoriteData().observeForever {
            mutableLiveData.value = it
        }
        return mutableLiveData
    }

}