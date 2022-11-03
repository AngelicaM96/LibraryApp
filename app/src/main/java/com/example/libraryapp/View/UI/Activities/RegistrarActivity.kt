package com.example.libraryapp.View.UI.Activities


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.libraryapp.R

class RegistrarActivity:AppCompatActivity() {
    lateinit var btnregistro: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        btnregistro=findViewById(R.id.Registrar)
        btnregistro.setOnClickListener{startActivity(Intent(this,login::class.java))}
    }
}