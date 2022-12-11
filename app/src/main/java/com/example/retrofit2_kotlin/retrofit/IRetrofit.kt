package com.example.retrofit2_kotlin.retrofit

import com.example.retrofit2_kotlin.API
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.*

interface IRetrofit {
    @Headers("Authorization:"+API.CLIENT_ID)
    @GET(API.SEARCH_ADDRESS)
    fun searchAddress(@Query("query") query:String) : Call<JsonElement>

    @Headers("Authorization:"+API.CLIENT_ID)
    @GET(API.SEARCH_COORD2ADDRESS)
    fun searchCoord2Address(@Query("query") query:String) : Call<JsonElement>

    @Headers("Authorization:"+API.CLIENT_ID)
    @GET(API.SEARCH_TRANSCOORD)
    fun searchTranscoord(@Query("query") query:String) : Call<JsonElement>

    @Headers("Authorization:"+API.CLIENT_ID)
    @GET(API.SEARCH_COORD2REGIONCODE)
    fun searchCoord2Regioncode(@Query("query") query:String) : Call<JsonElement>
}