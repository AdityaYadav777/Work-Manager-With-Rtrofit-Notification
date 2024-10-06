package com.aditya.work_manager_project

import com.aditya.myapplication.Models.userModels
import com.aditya.work_manager_project.Api.apiServices

class Reposity {

    suspend fun getData(): userModels? {
        val response=apiServices.getUsers.getUsers()

        return response.body()
    }

}