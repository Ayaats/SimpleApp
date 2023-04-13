package com.example.simpleapp.model.local

import androidx.room.Query
import com.example.simpleapp.model.entity.User

interface LocalRepository {

    suspend fun getUsers():List<User>

    suspend fun deleteUser(user: User)

    suspend fun insertOrUpdateUser(user: User)
}