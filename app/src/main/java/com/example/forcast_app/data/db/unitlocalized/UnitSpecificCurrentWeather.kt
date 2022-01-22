package com.example.forcast_app.data.db.unitlocalized

import com.google.gson.annotations.SerializedName

interface UnitSpecificCurrentWeather {

    val cloudcover: Double
    val feelslike: Double
    val humidity: Int
    val isDay: String
    val observationTime: String
    val precip: Double
    val pressure: Double
    val temperature: Double
    val visibility: Double
    val weatherDescriptions: List<String>
    val weatherIcons: List<String>
    val windDegree: Int
    val windDirection: String
    val windSpeed: Double
}
