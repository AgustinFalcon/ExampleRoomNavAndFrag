package com.example.fragmentsandnavigation.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UserViewModel: ViewModel() {

    private val userRepository = UserRepository()
    val readAllData: LiveData<List<User>> = userRepository.readAllData


    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.addUser(user = user)
        }
    }

    //fun getAllUsers() = userRepository.getAllUsers()

}