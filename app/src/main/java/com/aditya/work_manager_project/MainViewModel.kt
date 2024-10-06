package com.aditya.work_manager_project

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aditya.myapplication.Models.userModels
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {
    val repo=Reposity()
    var isRunning=true

    val getName= MutableLiveData<userModels>()



    init {
        getData()
    }

    fun getData():Flow<userModels> = flow {

        while (isRunning){
            emit(repo.getData()!!)
            delay(1000)
        }



    }



    fun stop(){
        isRunning=false
    }








}