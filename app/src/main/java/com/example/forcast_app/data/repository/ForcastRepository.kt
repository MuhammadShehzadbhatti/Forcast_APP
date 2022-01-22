package com.example.forcast_app.data.repository

import androidx.lifecycle.LiveData
import com.example.forcast_app.data.db.unitlocalized.UnitSpecificCurrentWeather

interface ForcastRepository {
    suspend fun getCurrentWeather(metric: Boolean):LiveData<UnitSpecificCurrentWeather>
}