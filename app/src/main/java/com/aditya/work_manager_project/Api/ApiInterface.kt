package com.aditya.work_manager_project.Api

import com.aditya.myapplication.Models.userModels
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/users")
suspend fun getUsers():Response<userModels>


}