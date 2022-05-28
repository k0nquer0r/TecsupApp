package com.example.tecsupapp.vistas.note

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.tecsupapp.DataBase.TecsupRoomDataBase
import com.example.tecsupapp.model.Dao.NotaDao
import com.example.tecsupapp.model.Nota
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NoteRepository(application: Application){

    private val noteDao: NotaDao?= TecsupRoomDataBase.getInstance(application)?.noteDao()

    fun getNotes(): LiveData<List<Nota>>{
        return noteDao?.getListNote()!!
    }

    suspend fun insertNoteWithCoroutines(note: Nota){
        processInsertNote(note)
    }

    private suspend fun processInsertNote(note: Nota){
        withContext(Dispatchers.Default){
            noteDao?.insert(note)
        }
    }

    //Actualizar

    suspend fun updateNoteWithCoroutines(nota: Nota) {
        processUpdateNote(nota)
    }

    private suspend fun processUpdateNote(nota: Nota) {
        withContext(Dispatchers.Default) {
            noteDao?.update(nota)
        }
    }


    //Eliminar

    suspend fun deleteNoteWithCoroutines(nota: Nota){
        processDeleteNote(nota)
    }

    private suspend fun processDeleteNote(nota: Nota){
        withContext(Dispatchers.Default){
            noteDao?.delete(nota)
        }
    }
}