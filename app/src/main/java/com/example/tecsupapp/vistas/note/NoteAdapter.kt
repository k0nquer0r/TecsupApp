package com.example.tecsupapp.vistas.note

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tecsupapp.model.Nota

class NoteAdapter(val mItemClickListener: ItemClickListener): RecyclerView.Adapter<NoteViewHolder>() {

    private var noteList = emptyList<Nota>()

    fun setNotes(notas: List<Nota>) {
        this.noteList = notas
        this.notifyDataSetChanged()
    }

    override fun getItemCount(): Int = noteList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NoteViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note: Nota =  noteList[position]
        holder.bind(note)
        holder.itemView.setOnClickListener{
            mItemClickListener.onItemClick(note)
        }
    }

    interface ItemClickListener{
        fun onItemClick(nota: Nota)
    }

}