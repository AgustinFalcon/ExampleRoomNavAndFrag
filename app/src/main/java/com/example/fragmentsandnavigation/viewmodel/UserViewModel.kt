package com.example.fragmentsandnavigation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fragmentsandnavigation.repository.UserRepository
import com.example.fragmentsandnavigation.model.User
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

    fun updateUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.updateUser(user)
        }
    }

}