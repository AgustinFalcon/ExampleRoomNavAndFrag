package com.example.fragmentsandnavigation.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fragmentsandnavigation.MyApp


@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDB : RoomDatabase() {


    abstract fun userDao(): UserDao


    companion object {
        @Volatile
        private var INSTANCE: UserDB? = null

        fun getDatabase(): UserDB {
            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    MyApp.instance.applicationContext,
                    UserDB::class.java,
                    "user_database"
                )
                    .allowMainThreadQueries()
                    .build()

                INSTANCE = instance
                return instance
            }
        }
    }

}