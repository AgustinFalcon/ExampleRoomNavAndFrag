package com.example.fragmentsandnavigation.data

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.fragmentsandnavigation.MyApp


class UserRepository {

    private val userDao = UserDB.getDatabase().userDao()

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User) {
        userDao.addUser(user = user)
    }


}