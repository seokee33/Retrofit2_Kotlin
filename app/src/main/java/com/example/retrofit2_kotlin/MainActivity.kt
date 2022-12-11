package com.example.retrofit2_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.retrofit2_kotlin.dto.GetMetaData
import com.example.retrofit2_kotlin.dto.LocationAddress
import com.example.retrofit2_kotlin.dto.MapAddressApi
import com.example.retrofit2_kotlin.retrofit.RetrofitManager
import com.google.gson.Gson
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    lateinit var etAddress: EditText
    lateinit var etAge: EditText

    lateinit var btnSend: Button
    lateinit var btnGet: Button

    lateinit var tvGetData: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etAddress = findViewById(R.id.et_Address)
        etAge = findViewById(R.id.et_age)

        btnSend = findViewById(R.id.btn_send)
        btnGet = findViewById(R.id.btn_getUser)

        tvGetData = findViewById(R.id.tv_getData)



        btnGet.setOnClickListener {
            RetrofitManager.instance.searchAddress(etAddress.text.toString(), completion = {
                responseState, responseBody ->
                    when(responseState){
                        RESPONSE_STATE.OKAY ->{
                            var gson = Gson()
                            val location : MapAddressApi? = gson.fromJson(responseBody,MapAddressApi::class.java)
                            Log.d("MainActivity", "API 호춣 성공 : $location")
                            Log.d("MainActivity", "getDAta!!!!!!!!!!!!!!!!! : ${location.toString()}")
                        }
                        RESPONSE_STATE.FAIL ->{
                            Toast.makeText(this,"API 호출 Error",Toast.LENGTH_SHORT).show()
                            Log.d("MainActivity", "API 호출 Error : $responseBody")
                        }
                    }
            })
        }
    }
}