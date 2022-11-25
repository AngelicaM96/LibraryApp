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
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class RegistrarActivity:AppCompatActivity() {
    lateinit var btnregistro: Button
    lateinit var firebaseAuth: FirebaseAuth

    lateinit var database: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        firebaseAuth = Firebase.auth
        database = Firebase.database.reference.child("User")
        val Nombre = findViewById<EditText>(R.id.RegistroNombre)
        val Email = findViewById<EditText>(R.id.RegistroEmail)
        val Telefono = findViewById<EditText>(R.id.RegistroNumero)
        val Password = findViewById<EditText>(R.id.RegistroPassword)


        btnregistro = findViewById(R.id.Registrar)
        btnregistro.setOnClickListener {
            startActivity(Intent(this, login::class.java))
            createUser(Email.text.toString(), Password.text.toString(),Nombre.text.toString(),Telefono.text.toString())
        }

    }
    fun createUser(Email:String,Password:String,Nombre:String,Telefono:String) {
        firebaseAuth.createUserWithEmailAndPassword(Email, Password)
            .addOnCompleteListener(this) { Task ->
                if (Task.isSuccessful) {
                    val user = firebaseAuth.currentUser
                    val db = database.child(user?.uid.toString())
                    db.child("Nombre").setValue(Nombre)
                    db.child("Telefono").setValue(Telefono)
                    startActivity(Intent(this, login::class.java))
                }

            }
    }
}