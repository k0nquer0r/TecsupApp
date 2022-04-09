package com.example.tecsupapp.vistas

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.tecsupapp.R
import kotlinx.android.synthetic.main.activity_r_cursos.*
import kotlinx.android.synthetic.main.activity_usuarios.*

class RCursosActivity: AppCompatActivity (), AdapterView.OnItemSelectedListener{

    val listaOpciones2 = arrayOf("2022-0", "2022-1","2022-2")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_r_cursos)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Registro de cursos"

        spinnerfecha.onItemSelectedListener = this

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaOpciones2)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerfecha.adapter = adapter
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    //Desarrollado por @Frank-Ventura
}