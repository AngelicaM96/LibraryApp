package com.example.libraryapp.Domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.libraryapp.Model.books
import com.example.libraryapp.Model.compras
import com.example.libraryapp.Model.favorites
import com.google.firebase.firestore.FirebaseFirestore

class Repository {
    fun getBookData(): LiveData<MutableList<books>>{
        val mutableLiveData= MutableLiveData<MutableList<books>>()
        FirebaseFirestore.getInstance().collection("books").get().addOnSuccessListener {
                result->
            val bookList= mutableListOf<books>()
            for (document in result){
                val title= document.getString("Title")
                val author= document.getString("Author")
                val price= document.getLong("Price")?.toInt()
                val url= document.getString("Url")
                val book= books(title,author,price,url)
                bookList.add(book)
            }
            mutableLiveData.value= bookList
        }
        return mutableLiveData
    }

    fun getFavoriteData(): LiveData<MutableList<favorites>>{
        val mutableLiveData= MutableLiveData<MutableList<favorites>>()
        FirebaseFirestore.getInstance().collection("favorites").get().addOnSuccessListener {
                result->
            val bookList= mutableListOf<favorites>()
            for (document in result){
                val title= document.getString("title")
                val author= document.getString("author")
                val price= document.getLong("price")?.toInt()
                val url= document.getString("url")
                val book= favorites(title!!,author!!,price!!,url!!)
                bookList.add(book)
            }
            mutableLiveData.value= bookList
        }
        return mutableLiveData
    }
    fun getShopData(): LiveData<MutableList<compras>>{
        val mutableLiveData= MutableLiveData<MutableList<compras>>()
        FirebaseFirestore.getInstance().collection("shop").get().addOnSuccessListener {
                result->
            val bookList= mutableListOf<compras>()
            for (document in result){
                val title= document.getString("title")
                val author= document.getString("author")
                val price= document.getLong("price")?.toInt()
                val url= document.getString("url")
                val book= compras(title!!,author!!,price!!,url!!)
                bookList.add(book)
            }
            mutableLiveData.value= bookList
        }
        return mutableLiveData
    }
}