package com.example.tecsupapp.vistas.contact

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.tecsupapp.model.Contact
import kotlinx.coroutines.launch


class ContactViewModel(application: Application): AndroidViewModel(application) {

    private val repository = ContactRepository(application)

    //Listado
    val contacts = repository.getContact()

    //Registro

    fun saveContact(contact: Contact){
        viewModelScope.launch {
            repository.insertContactWithCoroutines(contact)
        }
    }

    //Actualizar

    fun updateContac(contact: Contact){
        viewModelScope.launch {
            repository.updateContactWithCoroutines(contact)
        }
    }

    //Eliminar

    fun deleteContact(contact: Contact){
        viewModelScope.launch {
            repository.deleteContactWithCoroutines(contact)
        }
    }
}