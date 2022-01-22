package com.example.forcast_app.data.network

import androidx.lifecycle.LiveData

interface WeatherNetworkDataSource {
    val downloadedCurrentWeather : LiveData<CurrentWeatherResponse>
    suspend fun fetchCurrentWeather(
        location : String,
        languageCode : String
    )
}