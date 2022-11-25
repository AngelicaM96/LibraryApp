package com.example.libraryapp.View.Adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.ResourceManagerInternal.get
import androidx.recyclerview.widget.RecyclerView
import com.example.libraryapp.Model.books
import com.example.libraryapp.R
import com.example.libraryapp.View.UI.Fragments.Fragment_terror
import com.squareup.picasso.Picasso


class BookAdapter(val context: Context, var clickListener: Fragment_terror):RecyclerView.Adapter<BookAdapter.ViewHolder>() {
    var bookList= mutableListOf<books>()

    fun setListData(data:MutableList<books>){
        bookList=data
    }

    override fun onCreateViewHolder(ViewGroup: ViewGroup, i: Int): ViewHolder {
        val v= LayoutInflater.from(ViewGroup.context).inflate(R.layout.card_view_books_t,
            ViewGroup,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val book= bookList[i]
        viewHolder.bin(book, clickListener)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }


    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun bin(book:books, action: Fragment_terror){
            Picasso.get().load(book.Url).into(itemView.findViewById<ImageView>(R.id.imgBookT))
            itemView.findViewById<TextView>(R.id.TitleBookT).text=book.Title
            itemView.setOnClickListener {
                action.onItemClickBook(book,adapterPosition)
            }


        }
    }
    interface OnBookItemClickListener{
        fun onItemClickBook(book:books,position:Int)
        fun onItemClickCarrito(book: books)
        fun onItemClickfavority(book: books)
    }


}


