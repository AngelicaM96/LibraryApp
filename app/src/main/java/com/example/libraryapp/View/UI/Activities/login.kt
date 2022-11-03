package com.example.libraryapp.View.UI.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.libraryapp.R

class login: AppCompatActivity() {
    //lateinit var binding: ActivityMainBinding
    lateinit var Registrarbutton : Button
    lateinit var  loginbutton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding= ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        setContentView(R.layout.activity_login)

        Registrarbutton=findViewById(R.id.Registrar)
        loginbutton=findViewById(R.id.Login)

        Registrarbutton.setOnClickListener{
            startActivity(Intent(this,RegistrarActivity::class.java))

        }

        loginbutton.setOnClickListener{
            startActivity(Intent(this,HomeActivity::class.java))
        }
    }
}