package com.example.tecsupapp.vistas.courses

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class CoursesAdapter(val list: List<Courses>): RecyclerView.Adapter<CoursesViewHolder>() {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CoursesViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: CoursesViewHolder, position: Int) {
        val courses = list[position]
        holder.bind(courses)
    }




}