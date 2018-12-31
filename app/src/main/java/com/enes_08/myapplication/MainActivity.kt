package com.enes_08.myapplication

import android.app.AlertDialog
import android.app.Dialog
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnDialog.setOnClickListener(this)
        btnCustomDialog?.setOnClickListener(this)
    }


    override fun onClick(v: View?) {

        when (v) {

            btnDialog -> {
                Toast.makeText(this@MainActivity, "Dialog Tıklandi", Toast.LENGTH_SHORT).show();
                showDialog()

            }
            btnCustomDialog -> {
                Toast.makeText(this@MainActivity, "Custom dialog Tıklandi", Toast.LENGTH_SHORT).show();
                showCustomDialog()

            }


        }

    }

    fun showDialog() {

        var build = AlertDialog.Builder(this)
        build.setTitle("Çıkış Yap")
        build.setMessage("Tüm verileriniz kaybolacak.Çıkış yapmak istiyor musunuz?")
        build.setIcon(R.drawable.ic_logout)

        build.setNegativeButton("Hayır") { dialog, which ->
            Toast.makeText(applicationContext, "Hayır Tıklandı", Toast.LENGTH_LONG).show()

            dialog.dismiss();


        }
        build.setPositiveButton("Evet") { dialog, Which ->
            Toast.makeText(applicationContext, "Evet Tıkalndı", Toast.LENGTH_LONG).show()

            dialog.dismiss();


        }

        var dialogAllert: AlertDialog = build.create();
        dialogAllert.setCancelable(false)
        dialogAllert.show();


    }

    fun showCustomDialog() {

        var build = AlertDialog.Builder(this)

        var view: View = LayoutInflater.from(this).inflate(R.layout.dialog_custom, null, false)
        var tvMessage = view.findViewById<TextView>(R.id.tvMessage)
        var btnHayir = view.findViewById<Button>(R.id.btnHayir)
        var btnEvet = view.findViewById<Button>(R.id.btnEvet)
        var tvTitle=view.findViewById<TextView>(R.id.tvTitle)

        tvMessage.setText("Tüm verileriniz kaybolacak.Çıkış yapmak istiyor musunuz?")
        tvTitle.setText("ÇIKIŞ YAP")

        build.setView(view)


        var dialogCustom = build.create();
        dialogCustom.setCancelable(false)
        dialogCustom.show()


        btnHayir.setOnClickListener() {
            Toast.makeText(applicationContext, "Hayır Tıklandı", Toast.LENGTH_LONG).show()
            dialogCustom.dismiss()


        }
        btnEvet.setOnClickListener() {
            Toast.makeText(applicationContext, "Evet Tıkalndı", Toast.LENGTH_LONG).show()

            dialogCustom.dismiss();


        }


    }

}
