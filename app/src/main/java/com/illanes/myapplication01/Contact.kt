package com.illanes.myapplication01

import androidx.room.PrimaryKey

data class Contact(
    @PrimaryKey
    val id: Int,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
)
