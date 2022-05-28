package com.example.tecsupapp.vistas.contact

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.tecsupapp.DataBase.TecsupRoomDataBase
import com.example.tecsupapp.model.Contact
import com.example.tecsupapp.model.Dao.ContactDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactRepository(application: Application) {

    private val contactDao: ContactDao?= TecsupRoomDataBase.getInstance(application)?.contactDao()

    fun getContact(): LiveData<List<Contact>>{
        return contactDao?.getListContact()!!
    }

    suspend fun insertContactWithCoroutines(contact: Contact){
        processInsertContact(contact)
    }

    private suspend fun processInsertContact(contact: Contact){
        withContext(Dispatchers.Default){
            contactDao?.insert(contact)
        }
    }
}