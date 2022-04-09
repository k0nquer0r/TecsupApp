package com.example.tecsupapp.vistas

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.tecsupapp.MainActivity
import com.example.tecsupapp.R
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_login.*

class HomeActivity: AppCompatActivity (){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        Log.v("CICLO_VIDA", "onCreate")


        val correoUsuario = intent.getStringExtra("email")
        textCorreoUsuario.text = correoUsuario

        val actionBar = supportActionBar
        actionBar?.hide()

        btnNoticias.setOnClickListener {
            //activador
            startActivity(Intent(this, NewsActivity::class.java))


        }
         RegistrarCursos.setOnClickListener {
             startActivity(Intent(this, ActivityCursos::class.java))


         }
        profile.setOnClickListener {
            startActivity(Intent(this, PerfilActivity::class.java))


        }
        RegistrarDocente.setOnClickListener{
            startActivity(Intent(this, GestionActivity::class.java))


        }



        floatingShare.setOnClickListener {

            /*val sendIntent = Intent().apply {

                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Compartiendo msg")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, "Tecsup")
            startActivity(shareIntent)*/

            val openUrl = Intent().apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse("https://www.youtube.com/watch?v=Qp3b-RXtz4w")

            }

            startActivity(openUrl)
        }


    }

    override fun onStart() {
        super.onStart()
        Log.v("CICLO_VIDA", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.v("CICLO_VIDA", "onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.v("CICLO_VIDA", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.v("CICLO_VIDA", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("CICLO_VIDA", "onDestroy")
    }

    //Desarrollado por @Frank-Ventura
}