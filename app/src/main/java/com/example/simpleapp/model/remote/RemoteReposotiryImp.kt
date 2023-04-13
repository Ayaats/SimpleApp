package com.example.simpleapp.model.remote

import com.example.simpleapp.model.entity.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import retrofit2.Response

class RemoteReposotiryImp(private val api:ServiceAPI):RemoteReposotiry {
    override suspend fun getAPIUsers() =
        withContext(Dispatchers.IO){
            api.getAPIUsers()
    }

    override suspend fun getAPIUser(id: Int)=
        withContext(Dispatchers.IO){
            api.getAPIUser(id)
        }

    override suspend fun getAPIUserQuery(id: Int)=
        withContext(Dispatchers.IO){
            api.getAPIUserQuery(id)
        }

    override suspend fun addAPIUser(user: User)=
        withContext(Dispatchers.IO){
            api.addAPIUser(user)
        }

    override suspend fun updateAPIUser(user: User, id: Int)=
        withContext(Dispatchers.IO){
            api.updateAPIUser(user,id)
        }

    override suspend fun deleteAPIUser(id: Int) =
        withContext(Dispatchers.IO){
            api.deleteAPIUser(id)
        }
}