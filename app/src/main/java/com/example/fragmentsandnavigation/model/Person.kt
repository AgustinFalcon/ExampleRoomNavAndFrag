package com.example.fragmentsandnavigation.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "person_table")
data class Person(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val firstName: String,
    val lastName: String,
    val age: Int,

    @Embedded
    val address: Address

): Serializable


data class Address(
    val streetName: String,
    val streetNumber: Int
)