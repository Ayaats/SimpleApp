package com.example.simpleapp.model.remote

import androidx.room.Update
import com.example.simpleapp.model.entity.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ServiceAPI {

    @GET("/Ayaats/repo/users")
    suspend fun getAPIUsers():Response<User>

    @GET("/Ayaats/repo/users/{id}")
    suspend fun getAPIUser(@Path("id") id:Int):Response<User>

    @GET("/Ayaats/repo/users/")
    suspend fun getAPIUserQuery(@Query("id") id:Int):Response<User>

    @POST("/Ayaats/repo/users")
    suspend fun addAPIUser(@Body user: User):Response<User>

    @PUT("/Ayaats/repo/users/{id}")
    suspend fun updateAPIUser(@Body user: User,@Path("id") id:Int):Response<User>

    @DELETE("/Ayaats/repo/users/{id}")
    suspend fun deleteAPIUser(@Path("id") id:Int)

}