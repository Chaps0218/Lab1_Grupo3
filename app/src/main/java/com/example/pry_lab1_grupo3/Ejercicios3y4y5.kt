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