package com.example.retrofit2_kotlin.retrofit

import android.util.Log
import com.example.retrofit2_kotlin.API
import com.example.retrofit2_kotlin.Constants
import com.example.retrofit2_kotlin.RESPONSE_STATE
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Response

class RetrofitManager {

    companion object{
        val instance = RetrofitManager()
    }

    private val iRetrofit : IRetrofit? = RetrofitClient.getClient(API.BASE_URL)?.create(IRetrofit::class.java)


    fun searchAddress(searchTerm:String, completion:(RESPONSE_STATE,String)->Unit){
        val term = searchTerm.let {
            it
        }?:""
//        val term = searchTerm ?:""
        val call = iRetrofit?.searchAddress(searchTerm).let {
            it
        }?: return

        call.enqueue(object : retrofit2.Callback<JsonElement>{
            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.d("RetrofitManager","RetrofitManager - onFailure() called / t: $t")
                completion(RESPONSE_STATE.FAIL,t.toString())

            }

            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                Log.d("RetrofitManager","RetrofitManager - OnResponse() called / response : ${response.body().toString()}")
                completion(RESPONSE_STATE.OKAY, response.body().toString())
            }

        })
    }
}