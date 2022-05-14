package com.example.tecsupapp.vistas.news

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.tecsupapp.R
import kotlinx.android.synthetic.main.activity_noticias.*

class NewsActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noticias)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Noticias Tecsup"

        WebViewNoticias.webViewClient = WebViewClient()
        WebViewNoticias.loadUrl("https://www.tecsup.edu.pe/blog")
        WebViewNoticias.settings.javaScriptEnabled = true
    }

    //Desarrollado por @Frank-Ventura
}