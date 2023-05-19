package com.example.fragmentsandnavigation.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.fragmentsandnavigation.model.Person

@Dao
interface PersonDao {

    @Query("SELECT * FROM person_table ORDER BY id ASC")
    fun readPerson(): LiveData<List<Person>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPerson(person: Person)


}