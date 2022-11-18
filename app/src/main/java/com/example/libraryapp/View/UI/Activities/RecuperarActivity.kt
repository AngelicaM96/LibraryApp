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

class RecuperarActivity: AppCompatActivity() {
    lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperar)

        firebaseAuth = Firebase.auth
        val email = findViewById<EditText>(R.id.recuperar_email)
        val btnCambiar = findViewById<Button>(R.id.Enviar)
        btnCambiar.setOnClickListener {
            recuperarContraseña(email.text.toString())
        }
    }

    fun recuperarContraseña(email: String) {
        firebaseAuth.sendPasswordResetEmail(email)
            .addOnCompleteListener(this) { Task ->
                if (Task.isSuccessful) {
                    startActivity(Intent(this, login::class.java))
                } else {
                    Toast.makeText(this, "Recuperación Fallida", Toast.LENGTH_LONG).show()
                }
            }

    }

}