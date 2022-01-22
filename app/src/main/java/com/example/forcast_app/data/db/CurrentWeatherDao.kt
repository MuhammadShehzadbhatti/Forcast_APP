package com.example.forcast_app.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.forcast_app.data.db.entity.CURRENT_WEATHER_ID
import com.example.forcast_app.data.db.entity.CurrentWeatherEntry
import com.example.forcast_app.data.db.unitlocalized.UnitSpecificClass


@Dao
interface CurrentWeatherDao {
    // upsert will update or insert the current weather entry. because the current weather will be only one at given day and time

    @Insert(onConflict = OnConflictStrategy.REPLACE)// when we have a data entry already with same id then one might face conflict.
    // So that, new entry will be replaced by the existing one because the current weather should be one
    fun upsert(weatherEntry: CurrentWeatherEntry)

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getCurrentWeather():LiveData<UnitSpecificClass>
}