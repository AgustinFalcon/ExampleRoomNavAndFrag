package com.example.fragmentsandnavigation.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UserViewModel: ViewModel() {

    private val repository = UserRepository()

    fun addUser(user: User) {
        repository.addUser(user)
    }

    fun getAllUsers() = repository.getAllUsers()

}