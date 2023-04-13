package com.example.simpleapp.ui.userslist

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.simpleapp.model.entity.User
import com.example.simpleapp.model.local.LocalRepositoryImp
import com.example.simpleapp.model.local.UserDatabase
import com.example.simpleapp.model.remote.RemoteReposotiry
import com.example.simpleapp.model.remote.RemoteReposotiryImp
import com.example.simpleapp.model.remote.RetroBuilder
import com.example.simpleapp.model.remote.ServiceAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsersViewModel(application: Application):AndroidViewModel(application) {

    private var localRepositoryImp : LocalRepositoryImp
    private lateinit var remoteReposotiryImp:RemoteReposotiryImp



    //mutable

    private lateinit var userMutableLiveData: MutableLiveData<List<User>>

    val  userLiveData  : LiveData<List<User>> get() = userMutableLiveData

    private lateinit var userApIMutableLiveData: MutableLiveData<List<User>>

    val  userAPILiveData  : LiveData<List<User>> get() = userApIMutableLiveData

    private lateinit var addUserApIMutableLiveData: MutableLiveData<List<User>>

    val  addUserAPILiveData  : LiveData<List<User>> get() = addUserApIMutableLiveData

    init {
        var db= UserDatabase.getInstance(application)
        //add local repo

        localRepositoryImp= LocalRepositoryImp(db)

        var serviceInstance=RetroBuilder.getRetroBuilder().create(ServiceAPI::class.java)

        remoteReposotiryImp=RemoteReposotiryImp(serviceInstance)
    }
    fun getUsers() = viewModelScope.launch{
        userMutableLiveData.postValue(localRepositoryImp.getUsers())
    }

    fun getAPIUsers() = viewModelScope.launch{
       var result = remoteReposotiryImp.getAPIUsers()

        if (result.isSuccessful){
            if (result.body() != null){
                userApIMutableLiveData.postValue(result.body())
            }else{
                Log.i("Erorr msg",result.message())
            }
        }
    }
    fun addAPIUser(user: User) = viewModelScope.launch{
        var result = remoteReposotiryImp.addAPIUser(user)

        if (result.isSuccessful){
            if (result.body() != null){
                addUserApIMutableLiveData.postValue(result.body())
            }else{
                Log.i("Erorr msg",result.message())
            }
        }
    }

    fun deleteAPIUser(id:Int){
        viewModelScope.launch {
            remoteReposotiryImp.deleteAPIUser(id)
        }
    }

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO){
            localRepositoryImp.insertOrUpdateUser(user)
        }
    }
    fun deleteUser(user: User){
        viewModelScope.launch(Dispatchers.IO){
            localRepositoryImp.deleteUser(user)
        }
    }


}