package com.example.pry_lab1_grupo3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.pry_lab1_grupo3.dialogs.LoadingDialog

class MainActivity : AppCompatActivity() {

    private lateinit var txtUsername :EditText
    private lateinit var txtPassword :EditText
    private lateinit var btnLogin :Button
    private var usuarios = arrayOf("Mathi", "Chris", "Shared")
    private var passwords = arrayOf("Mathi1", "Chris1", "Shared1")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cargando = LoadingDialog(this)
        cargando.cargando()
        val handler = Handler()
        handler.postDelayed({ cargando.isDismiss() }, 3000)

        txtUsername = findViewById(R.id.et_Username)
        txtPassword = findViewById(R.id.et_Password)
        btnLogin = findViewById(R.id.btn_Login)
    }
    override fun onBackPressed() {
        super.onBackPressed()
    }
    fun login(v: View){
        var username = txtUsername.text.toString()
        var pass = txtPassword.text.toString()

        if (username.isNotEmpty() && pass.isNotEmpty()){
            if (username in usuarios && pass in passwords){
                var objIntent1 = Intent(this, MainMenu::class.java)
                objIntent1.putExtra("usuario", username)

                startActivity(objIntent1)
            }else{
                Toast.makeText(this, "Usuario o contraseña incorrecta", Toast.LENGTH_LONG).show()
            }
        }else{
            Toast.makeText(this, "Por favor, ingrese todos los campos", Toast.LENGTH_LONG).show()
        }
    }
    fun salir(v: View){
        finish()
    }
}