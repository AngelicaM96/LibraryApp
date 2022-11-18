package com.example.libraryapp.View.UI.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.example.libraryapp.R


class Fragment_menu : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonm= view.findViewById<Button>(R.id.button)
        buttonm.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_menu_to_fragment_terror)
        }

        val buttona= view.findViewById<Button>(R.id.button2)

        buttona.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_menu_to_fragment_aventura)
        }

        val buttonr= view.findViewById<Button>(R.id.button3)

        buttonr.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_menu_to_fragment_romanticas)
        }

        val buttonf= view.findViewById<Button>(R.id.button4)
        buttonf.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_menu_to_fragment_fantasia)
        }
        val imgcar= view.findViewById<ImageView>(R.id.carrito)
        imgcar.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_menu_to_fragment_compras)
        }

        val imghome= view.findViewById<ImageView>(R.id.casita)
        imghome.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_menu_to_fragment_menu)
        }
        val imgf= view.findViewById<ImageView>(R.id.favoritos)
        imgf.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_menu_to_fragment_favoritos)
        }
        val imgm= view.findViewById<ImageView>(R.id.mapa)
        imgm.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_menu_to_fragment_mapa)
        }



    }


}