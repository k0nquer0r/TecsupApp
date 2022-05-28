package com.example.tecsupapp.model.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tecsupapp.model.Contact

@Dao
interface ContactDao {
    @Insert
    fun insert(contact: Contact)
    @Update
    fun update(contact: Contact)
    @Delete
    fun delete(contact: Contact)

    @Query("SELECT * FROM contact_table ORDER BY contact_id DESC")
    fun getListContact():LiveData<List<Contact>>
    @Query("UPDATE contact_table SET fullname_contact=:fullname, phonenumber_contact=:phonenumber, email_contact=:email WHERE contact_id=:id ")
    fun update(fullname: String, phonenumber: String, email: String, id: Int)
}