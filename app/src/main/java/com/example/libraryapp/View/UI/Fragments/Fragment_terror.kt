package com.example.libraryapp.View.UI.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.libraryapp.Model.books
import com.example.libraryapp.R
import com.example.libraryapp.View.Adapter.BookAdapter
import com.example.libraryapp.View.Adapter.BookAdapter.OnBookItemClickListener
import com.example.libraryapp.ViewModel.BookViewModel
import com.google.firebase.firestore.FirebaseFirestore


class Fragment_terror : Fragment(), OnBookItemClickListener {

    lateinit var recyclerBook: RecyclerView
    lateinit var adapter: BookAdapter
    val viewmodel by lazy { ViewModelProvider(this).get(BookViewModel::class.java) }
    val database:FirebaseFirestore=FirebaseFirestore.getInstance()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_terror, container, false)
        recyclerBook= view.findViewById(R.id.rvBooks)
        adapter= BookAdapter(requireContext(), this)
        recyclerBook.layoutManager= LinearLayoutManager(context)
        recyclerBook.adapter=adapter
        observeData()
        return view
    }
    fun observeData(){
        viewmodel.fetchBookData().observe(viewLifecycleOwner, Observer {
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })
    }

    override fun onItemClickBook(book: books, position: Int) {
        val title:String?=book.Title
        val author:String?=book.Author
        val price:String=book.Price.toString()
        val url:String?=book.Url
        val bundle= bundleOf("title" to title,
            "author" to author,
            "price" to price,
            "url" to url,)
        findNavController().navigate(R.id.action_booksFragment2_to_book_detail_Fragment,bundle)
    }


    override fun onItemClickCarrito(book: books) {
    }

    override fun onItemClickfavority(book: books) {

    }

}