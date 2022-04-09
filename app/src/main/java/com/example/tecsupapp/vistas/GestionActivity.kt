package com.example.tecsupapp.vistas

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.tecsupapp.R
import kotlinx.android.synthetic.main.activity_gestion.*


class GestionActivity: AppCompatActivity(), AdapterView.OnItemSelectedListener {

    val listaUbicacion= arrayOf("Trujillo", "Lima","Arequipa")
    val listaCarrera = arrayOf("Diseño y desarrollo de software", "Diseño Grafico",  "Mecatronica")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestion)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Gestion de estudiantes"

        ubiSede.onItemSelectedListener = this

        val adapterubicacion = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaUbicacion)
        adapterubicacion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        ubiSede.adapter = adapterubicacion

        TipoCarrera.onItemSelectedListener = this

        val adaptercarrera = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaCarrera)
        adaptercarrera.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        ubiSede.adapter = adaptercarrera

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }




    //Desarrollado por @Frank-Ventura
}