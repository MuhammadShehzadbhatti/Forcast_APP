package com.example.forcast_app.data.network


data class Request(
    val language: String,
    val query: String,
    val type: String,
    val unit: String
)