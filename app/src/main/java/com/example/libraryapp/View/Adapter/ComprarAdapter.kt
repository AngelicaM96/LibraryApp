package com.example.libraryapp.View.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.libraryapp.Model.compras
import com.example.libraryapp.R
import com.squareup.picasso.Picasso

class ComprarAdapter (val context: Context, var clickListener: OnShopItemClickListener):RecyclerView.Adapter<ComprarAdapter.ViewHolder>(){

    var bookList= mutableListOf<compras>()

    fun setListData(data:MutableList<compras>){
        bookList=data
    }

    override fun onCreateViewHolder(ViewGroup: ViewGroup, i: Int): ViewHolder {
        val v= LayoutInflater.from(ViewGroup.context).inflate(
            R.layout.card_view_compras,
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


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bin(book: compras, action:OnShopItemClickListener){
            //Acá agregar ImageView con picasso o gliger

            Picasso.get().load(book.Url).into(itemView.findViewById<ImageView>(R.id.imgBook))
            itemView.findViewById<TextView>(R.id.tvTitleBook).text=book.Title
            itemView.findViewById<TextView>(R.id.tvAuthorBook).text = book.Author
            itemView.findViewById<TextView>(R.id.tvPriceBook).text= book.Price.toString()
            val btndelete=itemView.findViewById<Button>(R.id.delete)
            btndelete.setOnClickListener {
                action.onItemClickDelete(book,adapterPosition)
            }

        }
    }

}
interface OnShopItemClickListener{
    fun onItemClickDelete(book: compras, position:Int)


}
