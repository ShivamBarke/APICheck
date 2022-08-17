package com.example.apicheck

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

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
        val userText:TextView = findViewById(R.id.txtUser)
        call.enqueue(object : Callback<payload_request_body> {
            override fun onResponse(call: Call<payload_request_body>, response: Response<payload_request_body>) {
                userText.text = response.body().toString()
            }

            override fun onFailure(call: Call<payload_request_body>, t: Throwable) {
                userText.text = t.message.toString()
            }
        })
    }
}