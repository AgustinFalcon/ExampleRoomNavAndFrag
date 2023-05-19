package com.example.fragmentsandnavigation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fragmentsandnavigation.model.Person
import com.example.fragmentsandnavigation.repository.PersonRepository
import com.example.fragmentsandnavigation.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonViewModel : ViewModel() {

    private val personRepository = PersonRepository()

    val readPerson: LiveData<List<Person>> = personRepository.readPerson

    fun insertPerson(person: Person){
        viewModelScope.launch(Dispatchers.IO) {
            personRepository.insertPerson(person)
        }
    }
}