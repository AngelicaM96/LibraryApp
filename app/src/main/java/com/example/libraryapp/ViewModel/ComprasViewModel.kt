package com.example.libraryapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.libraryapp.Domain.Repository
import com.example.libraryapp.Model.compras

class ComprasViewModel : ViewModel() {

    private val repository = Repository()

    fun fetchShopData(): LiveData<MutableList<compras>> {
        val mutableLiveData= MutableLiveData<MutableList<compras>>()
        repository.getShopData().observeForever {
            mutableLiveData.value = it
        }
        return mutableLiveData
    }


}
