package com.example.tecsupapp.model.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tecsupapp.model.Nota

@Dao
interface NotaDao {
    @Insert
    fun insert(nota: Nota)
    @Update
    fun update(nota: Nota)
    @Delete
    fun delete(nota: Nota)

    @Query("SELECT * FROM note_table ORDER BY date_note DESC")
    fun getListNote(): LiveData<List<Nota>>
    @Query("UPDATE note_table SET title_note=:title, description_note=:description WHERE note_id=:id")
    fun update(title: String, description: String, id: Int)

}