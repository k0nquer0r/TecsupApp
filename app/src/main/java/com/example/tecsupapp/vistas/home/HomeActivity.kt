package com.example.tecsupapp.vistas.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.tecsupapp.R
import com.example.tecsupapp.vistas.book.BookFragment
import com.example.tecsupapp.vistas.courses.CoursesFragment
import com.example.tecsupapp.vistas.main.MainFragment
import com.example.tecsupapp.vistas.profile.PerfilActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity: AppCompatActivity (){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        Log.v("CICLO_VIDA", "onCreate")

        val actionBar = supportActionBar
        actionBar?.hide()

        openFragment(MainFragment.newInstance())



        configurationNavigationDrawer()
        configurationNavigationDrawertwo()


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


    private fun configurationNavigationDrawer() {
        navigationView.setNavigationItemSelectedListener {
            drawerLayout.closeDrawer(GravityCompat.START)
            when (it.itemId) {
                R.id.nav_library -> {
                    openFragment(BookFragment.newInstance())
                    true
                }
                R.id.nav_schedule -> {
                    Toast.makeText(this,"Opción de horarios", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_calculator -> {
                    Toast.makeText(this,"Opción de calculadora", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_contact_us -> {
                    Toast.makeText(this,"Opción de contactanos", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_claims_book -> {
                    Toast.makeText(this,"Opción del libro de reclamos", Toast.LENGTH_SHORT).show()
                    true
                } else -> false
            }

        }

    }

    private fun configurationNavigationDrawertwo() {
        navigationViewend.setNavigationItemSelectedListener {
            drawerLayout.closeDrawer(GravityCompat.END)
            when (it.itemId) {
                R.id.nav_News -> {
                    Toast.makeText(this,"Opción de Noticias", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_Cursos -> {
                    openFragment(CoursesFragment.newInstance())
                    true
                }
                R.id.nav_Teacher -> {
                    Toast.makeText(this,"Opción de Profesores", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_Students -> {
                    Toast.makeText(this,"Opción de Estudiantes", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_Notes -> {
                    Toast.makeText(this,"Opción de Notas", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_contact_us -> {
                    Toast.makeText(this,"Opción de Contacto", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_claims_book -> {
                    Toast.makeText(this,"Opción del libro de reclamos", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }

        }

    }

    private fun openFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.framelayoutContent, fragment)
        transaction.commit()
    }

    //Desarrollado por @Frank-Ventura
}