package com.example.pry_lab1_grupo3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.view.View

class Ejercicios1y2 : AppCompatActivity() {
    private lateinit var btn_cal_fac   : Button
    private lateinit var btn_cal_prime :Button
    private lateinit var btn_regresar :Button
    private  lateinit var  btn_avanzar:Button
    private lateinit var et_ingreso: EditText
    private lateinit var et_salida: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicios1y2)
            //mapeo
        btn_cal_fac = findViewById(R.id.btn_factorial)
        btn_cal_prime = findViewById(R.id.btn_primo)
        btn_regresar = findViewById(R.id.btn_atras)
        btn_avanzar = findViewById(R.id.btn_next)
        et_ingreso = findViewById(R.id.et_ingreso)
        et_salida = findViewById(R.id.et_resultado)

        btn_cal_fac.setOnClickListener {
            val inputText = et_ingreso.text.toString()
            if (inputText.isNotEmpty()) {
                val number = inputText.toInt()
                val factorialResult = calculateFactorial(number)
                et_salida.setText(factorialResult.toString())
            }
        }
        btn_cal_prime.setOnClickListener {
            val inputText = et_ingreso.text.toString()
            if (inputText.isNotEmpty()) {
                val number = inputText.toInt()
                var isPrime = isPrimeNumber(number)

                if(isPrime){
                    et_salida.setText("Es Primo")
                }else{
                    et_salida.setText("No es Primo")
                }
            }
        }
        btn_regresar.setOnClickListener{
            val intent = Intent(this, MainMenu::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
        btn_avanzar.setOnClickListener{
            val intent = Intent(this, Ejercicios3y4y5::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }
     fun calculateFactorial(n: Int): Long {
        return if (n == 0 || n == 1) {
            1
        } else {
            n * calculateFactorial(n - 1)
        }
    }
     fun isPrimeNumber(n: Int): Boolean {
        if (n <= 1) {
            return false
        }
        for (i in 2 until n) {
            if (n % i == 0) {
                return false
            }
        }
        return true
    }
}