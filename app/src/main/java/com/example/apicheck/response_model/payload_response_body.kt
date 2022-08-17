package com.example.apicheck.response_model

data class payload_response_body(
    val id: String,
    val params: Params,
    val responseCode: String,
    val result: Result,
    val ts: String,
    val ver: String
)