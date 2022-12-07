package com.example.retrofit2_kotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.retrofit2_kotlin.retrofit.RetrofitManager
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var etName: EditText
    lateinit var etAge: EditText

    lateinit var btnSend: Button
    lateinit var btnGet: Button

    lateinit var tvGetUser: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etName = findViewById(R.id.et_name)
        etAge = findViewById(R.id.et_age)

        btnSend = findViewById(R.id.btn_send)
        btnGet = findViewById(R.id.btn_getUser)

        tvGetUser = findViewById(R.id.tv_getUser)



        btnGet.setOnClickListener {
            RetrofitManager.instance.searchUsers(completion = {
                it
            })



            btnSend.setOnClickListener {

            }
        }
    }
}