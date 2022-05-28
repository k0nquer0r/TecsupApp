package com.example.tecsupapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "contact_table")
data class Contact (
    @ColumnInfo(name = "fullname_contact")
    val fullname: String,
    @ColumnInfo(name = "phonenumber_contact")
    val phonenumber: String,
    @ColumnInfo(name = "email_contact")
    val email: String
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "contact_id")
    var contactID: Int = 0
}