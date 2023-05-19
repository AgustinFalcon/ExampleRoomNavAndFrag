package com.example.fragmentsandnavigation.model

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "character_table")
data class Character(
    val firstName: String,
    val lastName: String,
    val profilePhoto: Bitmap?
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}