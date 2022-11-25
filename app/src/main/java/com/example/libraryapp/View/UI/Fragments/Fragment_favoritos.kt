package com.example.libraryapp.View.UI.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.libraryapp.Model.favorites
import com.example.libraryapp.R
import com.example.libraryapp.View.Adapter.FavoritesAdapter
import com.example.libraryapp.View.Adapter.OnFavoritesItemClickListener
import com.example.libraryapp.View.Adapter.ComprarAdapter
import com.example.libraryapp.ViewModel.FavoritesViewModel
import com.example.libraryapp.ViewModel.ComprasViewModel
import com.google.firebase.firestore.FirebaseFirestore

class Fragment_favoritos : Fragment(), OnFavoritesItemClickListener{

    lateinit var recyclerFavorites: RecyclerView
    lateinit var adapter: FavoritesAdapter
    val viewmodel by lazy { ViewModelProvider(this).get(FavoritesViewModel::class.java) }
    val database: FirebaseFirestore = FirebaseFirestore.getInstance()

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_favoritos, container, false)
        recyclerFavorites=view.findViewById(R.id.rvFavorites)
        adapter= FavoritesAdapter(requireContext(),this)
        recyclerFavorites.layoutManager= LinearLayoutManager(context)
        recyclerFavorites.adapter=adapter
        observeData()
        return view
    }

    private fun observeData() {
        viewmodel.fetchFavoritesData().observe(viewLifecycleOwner, Observer {
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })
    }

    override fun onItemClickBook(book: favorites, position: Int) {
        val title:String?=book.Title
        val author:String?=book.Author
        val price:String=book.Price.toString()
        val url:String?=book.Url
        val bundle= bundleOf("title" to title,
            "author" to author,
            "price" to price,
            "url" to url,)
        findNavController().navigate(R.id.action_fragment_favoritos_to_bookt_detail_Fragment,bundle)
    }

    override fun onItemClickDelete(book: favorites, position: Int) {
        database.collection("favoritos")
            .document(book.Title)
            .delete()
    }


}