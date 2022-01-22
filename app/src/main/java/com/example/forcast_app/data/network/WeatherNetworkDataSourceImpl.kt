package com.example.forcast_app.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.forcast_app.data.ApixuWeatherApiService
import com.example.forcast_app.internal.NoConnectivityException
import java.lang.Exception

class WeatherNetworkDataSourceImpl(
    private val apixuWeatherApiService: ApixuWeatherApiService
) : WeatherNetworkDataSource {

    private val _downloadedCurrentWeather = MutableLiveData<CurrentWeatherResponse>()
    override val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>
        get() = _downloadedCurrentWeather

    override suspend fun fetchCurrentWeather(location: String, languageCode: String) {
        try {
            val fetchCurrentWeather = apixuWeatherApiService.getCurrentWeather(location,languageCode).await()
            _downloadedCurrentWeather.postValue(fetchCurrentWeather)
        }
        catch (e: NoConnectivityException){
            Log.e("Connectivity","Check your connection",e)
        }
    }
}