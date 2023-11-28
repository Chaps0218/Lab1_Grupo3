package com.example.pry_lab1_grupo3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.ViewFlipper

class Ejercicios3y4y5 : AppCompatActivity() {
    private lateinit var vf_Ejercicios : ViewFlipper
    private lateinit var btn_Ejercicio3 : Button
    private lateinit var btn_Ejercicio4 : Button
    private lateinit var btn_Ejercicio5 : Button
    private lateinit var txt_Numero : EditText
    private lateinit var txt_Palabra : EditText
    private lateinit var btn_Palindromo : Button
    private lateinit var btn_Copicuo  : Button
    private lateinit var txt_Resultado3 : EditText
    private lateinit var txt_Resultado4 : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicios3y4y5)

        vf_Ejercicios = findViewById(R.id.viewFlipper_Ejercicios)
        btn_Ejercicio3 = findViewById(R.id.btn_Ejercicio3)
        btn_Ejercicio4 = findViewById(R.id.btn_Ejercicio4)
        btn_Ejercicio5 = findViewById(R.id.btn_Ejercicio5)
        txt_Numero = findViewById(R.id.et_IngresoEjercicio4)
        txt_Palabra = findViewById(R.id.et_IngresoEjercicio3)
        btn_Palindromo = findViewById(R.id.btn_AccionEjercicio3)
        btn_Copicuo = findViewById(R.id.btn_AccionEjercicio4)
        txt_Resultado3 = findViewById(R.id.et_ResultadoEjercicio3)
        txt_Resultado4 = findViewById(R.id.et_ResultadoEjercicio4)
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
    fun palindromo(v: View){
        var palabra = txt_Palabra.text.toString()
        var inverso = ""

        for (indice in palabra.length - 1 downTo 0) {
            inverso += palabra[indice]
        }
        if (inverso==palabra){
            txt_Resultado3.setText("La palabra sí es palíndroma")
        } else {
            txt_Resultado3.setText("La palabra no es palíndroma")
        }
    }
    fun copicuo(v: View){
        var numero = txt_Numero.text.toString()
        var inverso = ""

        for (indice in numero.length - 1 downTo 0) {
            inverso += numero[indice]
        }
        if (inverso==numero){
            txt_Resultado4.setText("El número sí es copicuo")
        } else {
            txt_Resultado4.setText("El número no es copicuo")
        }
    }


}