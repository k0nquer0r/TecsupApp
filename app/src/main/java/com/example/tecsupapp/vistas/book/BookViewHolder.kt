package com.example.tecsupapp.vistas.book

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.tecsupapp.R

class BookViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_book, parent, false)) {

        private var imgBook: ImageView? = null
        private var textbooktitle: TextView? = null
        private var textbookdescription: TextView? = null

        init {
            imgBook = itemView.findViewById(R.id.imgbook)
            textbooktitle = itemView.findViewById(R.id.textbooktitle)
            textbookdescription = itemView.findViewById(R.id.textbookdescription)
        }

    fun bind(book: Book){
        textbooktitle?.text = book.title
        textbookdescription?.text = book.description
        imgBook?.setImageResource(book.image)
    }
}