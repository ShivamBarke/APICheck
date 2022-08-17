package com.example.apicheck



import com.example.apicheck.response_model.payload_response_body
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface JsonPlaceholderApi {
    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiI5OUl0NW9XOFd3NlZKazBrbThEeUlwWDVlRGpqZ3B0VSJ9.DOVtxhcxfzU0guq86lZjd5hBJptK-xUTvH8PvJZn6bw")
    @POST("content/v1/search")
    fun haveUserData(
        @Body Payload_request_body : payload_request_body
    ):Call<payload_response_body>
}