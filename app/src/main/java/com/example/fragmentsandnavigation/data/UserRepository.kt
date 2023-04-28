package com.example.fragmentsandnavigation.data

import android.content.Context
import com.example.fragmentsandnavigation.MyApp


class UserRepository() {

    private val userDao: UserDao = UserDB.getDatabase().userDao()


    fun addUser(user: User) = userDao.addUser(user)
    fun getAllUsers(): List<User> = userDao.readAllData()
}