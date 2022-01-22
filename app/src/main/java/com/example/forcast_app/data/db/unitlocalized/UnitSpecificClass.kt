package com.example.forcast_app.data.db.unitlocalized

import androidx.room.ColumnInfo

data class UnitSpecificClass (
    // the names specified in CurrentWeatherEntry/table are referring to the following entries or field specified in UnitSpecificCurrentWeather interface
    // Fields of UnitSpecificCurrentWeather will be used in application
    // Fields/Columns in CurrentWeatherEntry/table will be used to access data from database

    @ColumnInfo(name="cloudcover") // cloudcover name in columninfo refers to the column in table specified in CurrentWeatherEntry
    override val cloudcover: Double,
    @ColumnInfo(name="feelslike")
    override val feelslike: Double,
    @ColumnInfo(name="humidity")
    override val humidity: Int,
    @ColumnInfo(name="isDay")
    override val isDay: String,
    @ColumnInfo(name="observationTime")
    override val observationTime: String,
    @ColumnInfo(name="precip")
    override val precip: Double,
    @ColumnInfo(name="pressure")
    override val pressure: Double,
    @ColumnInfo(name="temperature")
    override val temperature: Double,
    @ColumnInfo(name="visibility")
    override val visibility: Double,
    @ColumnInfo(name="weatherDescriptions")
    override val weatherDescriptions: List<String>,
    @ColumnInfo(name="weatherIcons")
    override val weatherIcons: List<String>,
    @ColumnInfo(name="windDegree")
    override val windDegree: Int,
    @ColumnInfo(name="windDir")
    override val windDirection: String,
    @ColumnInfo(name="windSpeed")
    override val windSpeed: Double


):UnitSpecificCurrentWeather