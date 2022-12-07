package com.example.retrofit2_kotlin.retrofit

import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface IRetrofit {

    @GET("/")
    fun searchUsers() : Call<JsonElement>

    @POST("/")
    fun addUser(@Body() addData: String ) : Call<JsonElement>


}