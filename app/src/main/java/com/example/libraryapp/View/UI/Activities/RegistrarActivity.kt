package com.example.libraryapp.View.UI.Activities


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.libraryapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegistrarActivity:AppCompatActivity() {
    lateinit var btnregistro: Button
    lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        firebaseAuth= Firebase.auth
        val Nombre= findViewById<EditText>(R.id.RegistroNombre)
        val Email= findViewById<EditText>(R.id.RegistroEmail)
        val Telefono= findViewById<EditText>(R.id.RegistroNumero)
        val Password= findViewById<EditText>(R.id.RegistroPassword)


        btnregistro=findViewById(R.id.Registrar)
        btnregistro.setOnClickListener{startActivity(Intent(this,login::class.java))
            createUser(Email.text.toString(),Password.text.toString())
        }

    }
    fun createUser(Email:String,Password:String){
        firebaseAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(this){
            Task-> if(Task.isSuccessful){
                startActivity(Intent(this,login::class.java))

        }else{
            Toast.makeText(baseContext,"Error", Toast.LENGTH_LONG).show()
        }
        }

    }
}