package com.example.tecsupapp.model

import androidx.room.Entity
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Nota(
    @ColumnInfo(name = "title_note")
    val title: String,
    @ColumnInfo(name = "description_note")
    val description: String,
    @ColumnInfo(name = "date_note")
    val date: String
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "note_id")
    var noteID: Int = 0
}