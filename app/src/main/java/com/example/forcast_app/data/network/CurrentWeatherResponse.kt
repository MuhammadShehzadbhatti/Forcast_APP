package com.example.forcast_app.data.network

import com.example.forcast_app.data.db.entity.CurrentWeatherEntry
import com.example.forcast_app.data.db.entity.Location
import com.google.gson.annotations.SerializedName


data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry,
    val location: Location,
    val request: Request
)