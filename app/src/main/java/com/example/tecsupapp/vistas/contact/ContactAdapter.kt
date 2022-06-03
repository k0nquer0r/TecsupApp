package com.example.tecsupapp.vistas.contact

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tecsupapp.model.Contact


class ContactAdapter(val mItemClickListener: ItemClickListener): RecyclerView.Adapter<ContactViewHolder>() {

    private var contactList = emptyList<Contact>()

    fun setContact(contact: List<Contact>) {
        this.contactList = contact
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ContactViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact: Contact = contactList[position]
        holder.bind(contact)
        holder.bind(contact)
        holder.itemView.setOnClickListener{
            mItemClickListener.onItemClick(contact)
        }
    }

    override fun getItemCount(): Int = contactList.size

    interface ItemClickListener{
        fun onItemClick(contact: Contact)
    }

}