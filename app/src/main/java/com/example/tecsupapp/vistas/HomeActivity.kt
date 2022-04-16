package com.example.tecsupapp.vistas

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.tecsupapp.MainActivity
import com.example.tecsupapp.R
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_login.*

class HomeActivity: AppCompatActivity (), PopupMenu.OnMenuItemClickListener{

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
        GestionEstudiante.setOnClickListener{
            startActivity(Intent(this, GestionActivity::class.java))

        }

        floatingContact.setOnClickListener{ viewFlotante ->
            showPopupMenu(viewFlotante)
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

        configurationNavigationDrawer()


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

    private fun showPopupMenu (view: View){
        val popupMenu = PopupMenu(this, view)
        val inflater: MenuInflater = popupMenu.menuInflater
        inflater.inflate(R.menu.menu_emergente, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener(this)
        popupMenu.show()
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        return when(item?.itemId) {
            R.id.item1 -> {
                Toast.makeText(this, "Opción1", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.item2 -> {
                Toast.makeText(this, "Opción2", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.item3 -> {
                Toast.makeText(this, "Opción3", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.item4 -> {
                Toast.makeText(this, "Opción4", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.item5 -> {
                Toast.makeText(this, "Opción5", Toast.LENGTH_SHORT).show()
                true
            }
            else -> false
        }
    }

    private fun configurationNavigationDrawer() {
        navigationView.setNavigationItemSelectedListener {
            drawerLayout.closeDrawer(GravityCompat.START)
            when (it.itemId) {
                R.id.nav_library -> {
                    Toast.makeText(this,"Opción de libreria", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, PerfilActivity::class.java))
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
        imgMenu.setOnClickListener {
            drawerLayout.openDrawer(navigationView)
        }
    }

    //Desarrollado por @Frank-Ventura
}