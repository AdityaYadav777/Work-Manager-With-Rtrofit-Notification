package com.aditya.work_manager_project.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object apiServices {

    val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    val getUsers by lazy {
        retrofit.create(ApiInterface::class.java)
    }



}