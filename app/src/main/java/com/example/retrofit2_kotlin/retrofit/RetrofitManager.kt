package com.example.retrofit2_kotlin.retrofit

import android.util.Log
import com.example.retrofit2_kotlin.API
import com.example.retrofit2_kotlin.Constants
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Response

class RetrofitManager {

    companion object{
        val instance = RetrofitManager()
    }

    private val iRetrofit : IRetrofit? = RetrofitClient.getClient(API.BASE_URL)?.create(IRetrofit::class.java)


    fun searchUsers(completion:(String)->Unit){
        val call = iRetrofit?.searchUsers().let {
            it
        }?: return

        call.enqueue(object : retrofit2.Callback<JsonElement>{
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                Log.d("RetrofitManager","RetrofitManager - OnResponse() called / response : ${response.raw()}")
                completion(response.raw().toString())
            }

            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.d("RetrofitManager","RetrofitManager - onFailure() called / t: $t")


            }

        })
    }
}