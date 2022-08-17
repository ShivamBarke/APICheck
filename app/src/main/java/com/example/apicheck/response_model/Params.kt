package com.example.apicheck.response_model

data class Params(
    val err: Any,
    val errmsg: Any,
    val msgid: String,
    val resmsgid: String,
    val status: String
)