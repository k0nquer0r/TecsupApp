package com.example.tecsupapp.vistas.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.tecsupapp.R
import com.example.tecsupapp.vistas.cursos.ActivityCursos
import com.example.tecsupapp.vistas.news.NewsActivity
import com.example.tecsupapp.vistas.profile.PerfilActivity
import com.example.tecsupapp.vistas.students.GestionActivity
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment: Fragment (), PopupMenu.OnMenuItemClickListener{

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnNoticias.setOnClickListener {
            //activador
            startActivity(Intent(activity, NewsActivity::class.java))


        }
        RegistrarCursos.setOnClickListener {
            startActivity(Intent(activity, ActivityCursos::class.java))


        }
        profile.setOnClickListener {
            startActivity(Intent(activity, PerfilActivity::class.java))


        }
        GestionEstudiante.setOnClickListener{
            startActivity(Intent(activity, GestionActivity::class.java))

        }

        floatingContact.setOnClickListener{
            showPopupMenu(it)
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

        imgMenu.setOnClickListener {
        }
    }

    private fun showPopupMenu (view: View){
        val popupMenu = PopupMenu(context, view)
        val inflater: MenuInflater = popupMenu.menuInflater
        inflater.inflate(R.menu.menu_emergente, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener(this)
        popupMenu.show()
    }

    companion object {
        fun newInstance(): MainFragment = MainFragment()
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        return when(item?.itemId) {
            R.id.item1 -> {
                Toast.makeText(context, "Opción1", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.item2 -> {
                Toast.makeText(context, "Opción2", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.item3 -> {
                Toast.makeText(context, "Opción3", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.item4 -> {
                Toast.makeText(context, "Opción4", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.item5 -> {
                Toast.makeText(context, "Opción5", Toast.LENGTH_SHORT).show()
                true
            }
            else -> false
        }
    }
}