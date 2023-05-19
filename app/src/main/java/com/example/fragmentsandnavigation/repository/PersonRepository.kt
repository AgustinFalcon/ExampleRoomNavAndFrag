package com.example.fragmentsandnavigation.repository

import androidx.lifecycle.LiveData
import com.example.fragmentsandnavigation.data.PersonDao
import com.example.fragmentsandnavigation.data.UserDB
import com.example.fragmentsandnavigation.model.Person


class PersonRepository {

    private val personDao = UserDB.getDatabase().personDao()
    val readPerson: LiveData<List<Person>> = personDao.readPerson()

    suspend fun insertPerson(person: Person){
        personDao.insertPerson(person)
    }
}