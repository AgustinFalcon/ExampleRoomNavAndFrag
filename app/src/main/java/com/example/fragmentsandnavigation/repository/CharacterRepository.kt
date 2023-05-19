package com.example.fragmentsandnavigation.repository

import androidx.lifecycle.LiveData
import com.example.fragmentsandnavigation.data.UserDB
import com.example.fragmentsandnavigation.model.Person
import com.example.fragmentsandnavigation.model.Character


class CharacterRepository {

    private val characterDao = UserDB.getDatabase().characterDao()
    val readCharacter: LiveData<List<Character>> = characterDao.readCharacter()

    suspend fun insertCharacter(character: Character){
        characterDao.insertCharacter(character)
    }


}