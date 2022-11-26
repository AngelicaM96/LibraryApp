package com.example.libraryapp.View.UI.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.libraryapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView


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
            findNavController().navigate(R.id.action_fragment_menu_to_fragment_mapa)
        }

        val buttona= view.findViewById<Button>(R.id.button2)

        buttona.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_menu_to_fragment_aventura)
        }

        val buttonr= view.findViewById<Button>(R.id.button3)

        buttonr.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_menu_to_fragment_romanticas)
        }


        val imgcar= view.findViewById<ImageView>(R.id.carrito)
        imgcar.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_menu_to_fragment_compras)
        }

        val bthome= view.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bthome.setOnNavigationItemReselectedListener() {
            when (it.itemId){
                R.id.nav_home -> findNavController().navigate(R.id.action_fragment_menu_to_fragment_menu)
            }
        }
        val btfavotiros= view.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        btfavotiros.setOnNavigationItemReselectedListener {
            when (it.itemId){
                R.id.nav_favoritos -> findNavController().navigate(R.id.action_fragment_menu_to_fragment_favoritos)
            }
        }
        val btmapa= view.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        btmapa.setOnNavigationItemReselectedListener() {
            when(it.itemId){
                R.id.nav_mapa-> findNavController().navigate(R.id.action_fragment_menu_to_fragment_mapa)
            }

        }

        val btp= view.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        btp.setOnNavigationItemReselectedListener() {
            when(it.itemId){
                R.id.nav_perfil-> findNavController().navigate(R.id.action_fragment_menu_to_fragment_perfil)

            }

        }



    }



}