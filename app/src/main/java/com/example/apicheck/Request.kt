package com.example.apicheck

data class Request(
    val filters: Filters,
    val limit: Int,
    val query: String
)