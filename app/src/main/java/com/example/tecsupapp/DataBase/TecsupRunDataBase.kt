package com.example.tecsupapp.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.tecsupapp.model.Contact
import com.example.tecsupapp.model.Dao.ContactDao
import com.example.tecsupapp.model.Dao.NotaDao
import com.example.tecsupapp.model.Nota
import java.security.AccessControlContext

@Database(entities = [Nota::class, Contact::class], version = 1)
abstract class TecsupRoomDataBase: RoomDatabase(){

    abstract fun noteDao(): NotaDao
    abstract fun contactDao():ContactDao

    companion object {

        private const val DATABASE_NAME = "tecsup_database"
        @Volatile
        private var INSTANCE: TecsupRoomDataBase? = null

        fun getInstance(context: Context): TecsupRoomDataBase? {
            INSTANCE?: synchronized(this){
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    TecsupRoomDataBase::class.java,
                    DATABASE_NAME
                ).build()
            }
            return INSTANCE
        }
    }
}
