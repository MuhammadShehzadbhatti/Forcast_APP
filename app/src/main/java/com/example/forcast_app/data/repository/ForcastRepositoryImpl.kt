package com.example.forcast_app.data.repository

import androidx.lifecycle.LiveData
import com.example.forcast_app.data.db.CurrentWeatherDao
import com.example.forcast_app.data.db.unitlocalized.UnitSpecificCurrentWeather
import com.example.forcast_app.data.network.CurrentWeatherResponse
import com.example.forcast_app.data.network.WeatherNetworkDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class ForcastRepositoryImpl(
    private val weatherNetworkDataSource: WeatherNetworkDataSource,
    private val currentWeatherDao: CurrentWeatherDao
) : ForcastRepository {

    init {
        // for life cycle dependent classes we implement the observe however repositories do not have lifecycle so we can implement observeForever
        /*weatherNetworkDataSource.downloadedCurrentWeather.observeForever(newCurrentWeather ->
        //persist
        persistFetchedCurrentWeather(newCurrentWeather)
        )*/
    }

    override suspend fun getCurrentWeather(metric: Boolean): LiveData<UnitSpecificCurrentWeather> {
        TODO("Not yet implemented")
    }
    private fun persistFetchedCurrentWeather(fetchedWeather: CurrentWeatherResponse){
        GlobalScope.launch(Dispatchers.IO) {
            currentWeatherDao.upsert(fetchedWeather.currentWeatherEntry)
        }
    }
}