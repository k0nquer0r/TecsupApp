package com.example.tecsupapp.vistas.courses

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tecsupapp.R
import com.example.tecsupapp.vistas.book.Book

class CoursesViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_courses, parent, false)) {

    private var imgCourses: ImageView? = null
    private var textcoursetitle: TextView? = null
    private var textcoursedescription: TextView? = null

    init {
        imgCourses = itemView.findViewById(R.id.imgCourses)
        textcoursetitle = itemView.findViewById(R.id.textcoursetitle)
        textcoursedescription = itemView.findViewById(R.id.textcoursedescription)

    }

    fun bind(courses: Courses){
        textcoursetitle?.text = courses.title
        textcoursedescription?.text = courses.description
        imgCourses?.setImageResource(courses.image)
    }
}