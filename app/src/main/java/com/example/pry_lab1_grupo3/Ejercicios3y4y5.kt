package com.example.pry_lab1_grupo3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.widget.ViewFlipper

class Ejercicios3y4y5 : AppCompatActivity() {
    private lateinit var vf_Ejercicios : ViewFlipper
    private lateinit var btn_Ejercicio3 : Button
    private lateinit var btn_Ejercicio4 : Button
    private lateinit var btn_Ejercicio5 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicios3y4y5)

        vf_Ejercicios = findViewById(R.id.viewFlipper_Ejercicios)
        btn_Ejercicio3 = findViewById(R.id.btn_Ejercicio3)
        btn_Ejercicio4 = findViewById(R.id.btn_Ejercicio4)
        btn_Ejercicio5 = findViewById(R.id.btn_Ejercicio5)
    }
    fun cambiar(v: View) {
        if (v is Button) {
            val hint = v.hint.toString()
            val viewIndex = when (hint) {
                "1" -> 0
                "2" -> 1
                "3" -> 2
                else -> -1
            }

            if (viewIndex != -1) {
                vf_Ejercicios.displayedChild = viewIndex
            }
        }
    }

}