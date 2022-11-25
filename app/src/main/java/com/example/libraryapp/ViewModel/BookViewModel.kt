package com.example.libraryapp.ViewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.libraryapp.Domain.Repository
import com.example.libraryapp.Model.books

class BookViewModel: ViewModel(){

    private val repository = Repository()

    fun fetchBookData(): LiveData<MutableList<books>>{
        val mutableLiveData= MutableLiveData<MutableList<books>>()
        repository.getBookData().observeForever {
            mutableLiveData.value = it
        }
        return mutableLiveData
    }
}