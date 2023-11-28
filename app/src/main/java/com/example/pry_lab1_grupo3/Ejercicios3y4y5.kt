package com.example.pry_lab1_grupo3

import android.content.Intent
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
    private lateinit var vfEjercicios: ViewFlipper
    private lateinit var btnEjercicio3: Button
    private lateinit var btnEjercicio4: Button
    private lateinit var btnEjercicio5: Button

    //Ejercicio 5
    private lateinit var txtIngresoEjercicio5: EditText
    private lateinit var txtResultadoSexagesimales: EditText
    private lateinit var txtResultadoCentesimales: EditText
    private lateinit var btnConvertirEjercicio5: Button
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
        vfEjercicios = findViewById(R.id.viewFlipper_Ejercicios)
        btnEjercicio3 = findViewById(R.id.btn_Ejercicio3)
        btnEjercicio4 = findViewById(R.id.btn_Ejercicio4)
        btnEjercicio5 = findViewById(R.id.btn_Ejercicio5)

        txtIngresoEjercicio5 = findViewById(R.id.et_IngresoEjercicio5)
        txtResultadoCentesimales = findViewById(R.id.et_ResultadoEjercicio5Centesimales)
        txtResultadoSexagesimales = findViewById(R.id.et_ResultadoEjercicio5Sexagesimales)
        btnConvertirEjercicio5 = findViewById(R.id.btn_AccionEjercicio5)
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
                vfEjercicios.displayedChild = viewIndex
            }
        }
    }
    fun convertirAngulo(v: View) {
        try {
            var ingreso = txtIngresoEjercicio5.text.toString()
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


            if (ingreso.isNotEmpty()) {
                if (ingreso != ".") {
                    if (ingreso.startsWith(".")) {
                        val cantidad = java.lang.Double.parseDouble("0$ingreso")
                        val centesimalAngle = cantidad * (200/3.14159265358979323846)
                        val sexagesimalAngle = cantidad * (180/3.14159265358979323846)
                        val formattedCentesimalAngle = String.format("%.3f", centesimalAngle)
                        val formattedSexagesimalAngle = String.format("%.3f", sexagesimalAngle)
                        txtResultadoCentesimales.setText(formattedCentesimalAngle)
                        txtResultadoSexagesimales.setText(formattedSexagesimalAngle)
                    } else {
                        val cantidad = java.lang.Double.parseDouble(ingreso)
                        val centesimalAngle = cantidad * (200/3.14159265358979323846)
                        val sexagesimalAngle = cantidad * (180/3.14159265358979323846)
                        val formattedCentesimalAngle = String.format("%.3f", centesimalAngle)
                        val formattedSexagesimalAngle = String.format("%.3f", sexagesimalAngle)
                        txtResultadoCentesimales.setText(formattedCentesimalAngle)
                        txtResultadoSexagesimales.setText(formattedSexagesimalAngle)
                    }
                }
            } else {
                Toast.makeText(
                    this,
                    "Por favor, ingrese un ángulo para transformar",
                    Toast.LENGTH_SHORT
                ).show()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
        }

    }
    fun regresar(v: View) {
        val intent = Intent(this, MainMenu::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }
}