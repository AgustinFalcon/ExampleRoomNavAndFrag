package com.example.fragmentsandnavigation.data


import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.fragmentsandnavigation.MyApp
import com.example.fragmentsandnavigation.model.Person
import com.example.fragmentsandnavigation.model.User
import com.example.fragmentsandnavigation.model.Character
import com.example.fragmentsandnavigation.ui.list.character.Converter


@Database(entities = [User::class, Person::class, Character::class], version = 3, exportSchema = false)
@TypeConverters(Converter::class)
abstract class UserDB : RoomDatabase() {


    abstract fun userDao(): UserDao
    abstract fun personDao(): PersonDao
    abstract fun characterDao(): CharacterDao


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
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                return instance
            }
        }
    }

}