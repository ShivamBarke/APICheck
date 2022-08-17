package com.example.apicheck

data class Filters(
    val contentType: String,
    val mediaType: String,
    val mimeType: String,
    val primaryCategory: List<String>,
    val se_boards: List<String>,
    val se_gradeLevels: List<String>,
    val se_mediums: List<String>
)