package com.example.simpleapp.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.simpleapp.model.entity.User

private const val DATABASE_NAME="user_database"
        @Database(entities = [User::class], version = 1, exportSchema = false)


abstract class UserDatabase:RoomDatabase() {


    abstract fun userDao():UserDAO

    companion object{

        @Volatile
        private var instance:UserDatabase?=null

        fun getInstance(context: Context):UserDatabase{
            return instance ?:synchronized(Any())
            {
                instance ?: buildDatabase(context).also{ instance=it}
            }
        }

        private fun buildDatabase(context: Context): UserDatabase {
         return Room.databaseBuilder(context.applicationContext,UserDatabase::class.java,
             DATABASE_NAME).build()
        }
    }
}