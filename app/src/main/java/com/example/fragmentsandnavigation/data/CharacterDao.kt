package com.example.fragmentsandnavigation.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.fragmentsandnavigation.model.Character

@Dao
interface CharacterDao {

    @Query("SELECT * FROM character_table ORDER BY id ASC")
    fun readCharacter(): LiveData<List<Character>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(person: Character)

}