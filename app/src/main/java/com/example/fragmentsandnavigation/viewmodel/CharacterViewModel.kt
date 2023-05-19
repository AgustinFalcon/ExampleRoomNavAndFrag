package com.example.fragmentsandnavigation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fragmentsandnavigation.repository.CharacterRepository
import com.example.fragmentsandnavigation.model.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CharacterViewModel : ViewModel() {


    private val characterRepository = CharacterRepository()

    val readCharacter: LiveData<List<Character>> = characterRepository.readCharacter

    fun insertCharacter(character: Character){
        viewModelScope.launch(Dispatchers.IO) {
            characterRepository.insertCharacter(character)
        }
    }
}