package com.example.libraryapp.View.UI.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.libraryapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class login: AppCompatActivity() {
    //lateinit var binding: ActivityMainBinding
    lateinit var Registrarbutton : Button
    lateinit var  loginbutton : Button
    lateinit var firebaseAuth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding= ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        setContentView(R.layout.activity_login)

        firebaseAuth= Firebase.auth
        val email= findViewById<EditText>(R.id.loginEmail)
        val password= findViewById<EditText>(R.id.loginPassword)

        Registrarbutton=findViewById(R.id.Registrar)
        loginbutton=findViewById(R.id.Login)

        Registrarbutton.setOnClickListener{
            startActivity(Intent(this,RegistrarActivity::class.java))
        }

        loginbutton.setOnClickListener{
            startActivity(Intent(this,HomeActivity::class.java))
        }
        loginbutton.setOnClickListener {
            user_login(email.text.toString(),password.text.toString())
        }

        val txtrecuperarcontraseña= findViewById<TextView>(R.id.OlvidasteTuContraseña)
        txtrecuperarcontraseña.setOnClickListener {
            startActivity(Intent(this,RecuperarActivity::class.java))
        }

    }
    fun user_login(email:String,password:String){
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                    Task-> if(Task.isSuccessful){
                startActivity(Intent(this,HomeActivity::class.java))
            }else{
                Toast.makeText(baseContext,"ERROR",Toast.LENGTH_LONG).show()
            }
            }
    }

}