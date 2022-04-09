package com.example.tecsupapp.vistas

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.tecsupapp.R
import kotlin.math.log

class ActivityCursos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cursos)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Gestion de cursos"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu, menu)
        setIcon(menu?.findItem(R.id.RCurso)!!)
        return super.onCreateOptionsMenu(menu)
    }

    private fun setIcon(menuItem: MenuItem) {
        val id = R.drawable.ic_baseline_add_24
        menuItem.icon = ContextCompat.getDrawable(this, id)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.RCurso -> {
                // Log.v("MENU_EVENTO", "REGISTAR CURSO")

                startActivity(Intent(this, RCursosActivity::class.java))

            }
        }
        return super.onOptionsItemSelected(item)
    }
    //Desarrollado por @Frank-Ventura
}