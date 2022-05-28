package com.example.tecsupapp.vistas.contact

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.tecsupapp.model.Contact
import kotlinx.coroutines.launch


class ContactViewModel(application: Application): AndroidViewModel(application) {

    private val repository = ContactRepository(application)

    val contacts = repository.getContact()

    fun saveContact(contact: Contact){
        viewModelScope.launch {
            repository.insertContactWithCoroutines(contact)
        }
    }
}