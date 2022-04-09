package com.example.tecsupapp.vistas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tecsupapp.R

class PerfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        title = "PERFIL"
    }
}