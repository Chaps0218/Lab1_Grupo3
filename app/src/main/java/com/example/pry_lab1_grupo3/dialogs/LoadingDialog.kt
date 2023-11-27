package com.example.pry_lab1_grupo3.dialogs

import android.app.Activity
import android.app.AlertDialog
import com.example.pry_lab1_grupo3.R

class LoadingDialog(val mActiviy: Activity) {
    private lateinit var isdialog : AlertDialog
    fun cargando(){
        val inflater = mActiviy.layoutInflater
        val dialogView = inflater.inflate(R.layout.carga_inicio, null)
        val builder = AlertDialog.Builder(mActiviy)
        builder.setView(dialogView)
        builder.setCancelable(false)
        isdialog = builder.create()
        isdialog.show()
    }
    fun isDismiss(){
        isdialog.dismiss()
    }
}