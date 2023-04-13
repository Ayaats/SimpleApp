package com.example.simpleapp.model.remote

import com.example.simpleapp.model.entity.User
import retrofit2.Response
import retrofit2.http.*

interface RemoteReposotiry {


    suspend fun getAPIUsers(): Response<User>


    suspend fun getAPIUser(id: Int): Response<User>


    suspend fun getAPIUserQuery(id: Int): Response<User>


    suspend fun addAPIUser(user: User): Response<User>


    suspend fun updateAPIUser(user: User,id: Int): Response<User>


    suspend fun deleteAPIUser(id:Int)
}