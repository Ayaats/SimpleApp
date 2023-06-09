package com.example.simpleapp.model.local

import com.example.simpleapp.model.entity.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalRepositoryImp(private val db:UserDatabase) :LocalRepository{
    override suspend fun getUsers()= withContext(Dispatchers.IO){
     db.userDao().getUsers()
    }


    override suspend fun deleteUser(user: User) {
        withContext(Dispatchers.IO)
        {
        db.userDao().deleteUser(user)
        }
    }

    override suspend fun insertOrUpdateUser(user: User) {
        withContext(Dispatchers.IO)
        {
        db.userDao().insertOrUpdateUser(user)
        }
    }


}