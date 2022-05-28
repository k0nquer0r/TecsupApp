package com.example.tecsupapp.vistas.note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.tecsupapp.model.Nota
import kotlinx.coroutines.launch

class NoteViewModel(application: Application): AndroidViewModel(application) {

    private val repository = NoteRepository(application)

    //Listado
    val notes = repository.getNotes()

    //Registro

    fun saveNote(nota : Nota){
        viewModelScope.launch {
            repository.insertNoteWithCoroutines(nota)
        }
    }

    // Actualizar
    fun updateNote(nota: Nota) {
        viewModelScope.launch {
            repository.updateNoteWithCoroutines(nota)
        }
    }

    // Eliminar
    fun deleteNote(nota: Nota) {
        viewModelScope.launch {
            repository.deleteNoteWithCoroutines(nota)
        }
    }

}