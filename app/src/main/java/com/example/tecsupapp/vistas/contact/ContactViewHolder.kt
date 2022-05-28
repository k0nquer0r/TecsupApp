package com.example.tecsupapp.vistas.contact

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tecsupapp.R
import com.example.tecsupapp.model.Contact

class ContactViewHolder (inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_contac, parent, false)){

    private var textfullname: TextView? = null
    private var textphonenumber: TextView? = null
    private var textemail: TextView? = null

    init {
        textfullname = itemView.findViewById(R.id.textfullname)
        textphonenumber = itemView.findViewById(R.id.textphonenumber)
        textemail = itemView.findViewById(R.id.textemail)
    }

    fun bind(contact: Contact){
        textfullname?.text = contact.fullname
        textphonenumber?.text = contact.phonenumber
        textemail?.text = contact.email
    }
}