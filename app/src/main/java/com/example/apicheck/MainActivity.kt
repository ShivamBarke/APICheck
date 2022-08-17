package com.example.apicheck

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.apicheck.response_model.payload_response_body


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //RETRO FIT BUILDER

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.dev.diksha.gov.in/api/")
            .build()
        val jsonPlaceholderApi = retrofitBuilder.create(JsonPlaceholderApi::class.java)

        val userPost = payload_request_body(Request(Filters(contentType = "Resource", mediaType = "content", mimeType = "video/mp4", primaryCategory = listOf("Explanation Content"), se_boards = listOf("State (Gujarat)"), se_gradeLevels = listOf("Class 7"), se_mediums = listOf("English") ), limit = 1000, query = "Fabric"))
        val call = jsonPlaceholderApi.haveUserData(userPost)
        //val jsonResponseApi = retrofitBuilder.create(JsonResponseApi::class.java)

        val userText:TextView = findViewById(R.id.txtUser)

//        call.enqueue(object : Callback<payload_request_body> {
//            override fun onResponse(call: Call<payload_request_body>, response: Response<payload_request_body>) {
//                Log.d("dvdv", response.body().toString())
//                userText.text = response.body().toString()
//            }
//
//            override fun onFailure(call: Call<payload_request_body>, t: Throwable) {
//                userText.text = t.message.toString()
//            }
//        })
        call.enqueue(object : Callback<payload_response_body> {
            override fun onResponse(
                call: Call<payload_response_body>,
                response: Response<payload_response_body>
            ) {
                response.body()?.result?.content?.get(0)?.let { Log.d("dsvd", it.previewUrl) }
            }

            override fun onFailure(call: Call<payload_response_body>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}