package com.example.pry_lab1_grupo3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

class MainMenu : AppCompatActivity() {

    private lateinit var btnEjercicios1y2 : RadioButton
    private lateinit var btnEjercicios3y4y5 : RadioButton
    private lateinit var lblBienvenida : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        btnEjercicios1y2 = findViewById(R.id.rb_Ejercicio1y2)
        btnEjercicios3y4y5 = findViewById(R.id.rb_Ejercicio3y4y5)
        lblBienvenida = findViewById(R.id.tv_Bienvenida)

        var objIntent3 = intent
        val usuario = objIntent3.getStringExtra("usuario")
        lblBienvenida.text = "¡Bienvenido de vuelta ${usuario ?: "Invitado"}!"
    }

    fun ejercicios1y2(v: View){
        var objIntent4 = Intent(this, Ejercicios1y2::class.java)
        startActivity(objIntent4)
    }
    fun ejercicios3y4y5(v: View){
        var objIntent5 = Intent(this, Ejercicios3y4y5::class.java)
        startActivity(objIntent5)
    }
    fun logout(v: View){
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finish()
    }
}