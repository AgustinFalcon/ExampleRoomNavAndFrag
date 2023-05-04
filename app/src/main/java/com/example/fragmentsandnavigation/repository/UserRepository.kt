package com.example.fragmentsandnavigation.repository

import androidx.lifecycle.LiveData
import com.example.fragmentsandnavigation.data.UserDB
import com.example.fragmentsandnavigation.model.User


class UserRepository {

    private val userDao = UserDB.getDatabase().userDao()

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User) {
        userDao.addUser(user = user)
    }

    suspend fun updateUser(user: User) {
        userDao.updateUser(user)
    }


    suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }


    suspend fun deleteAllUsers() {
        userDao.deleteAllUsers()
    }
}