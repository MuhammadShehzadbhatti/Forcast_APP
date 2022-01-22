package com.example.forcast_app.data

import com.example.forcast_app.data.network.CurrentWeatherResponse
import com.example.forcast_app.data.network.response.ConnectivityIntercept
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "fc668f0a72b4ded0b3b23dbf8e300c22"

//resquest_URL = http://api.weatherstack.com/current?access_key=fc668f0a72b4ded0b3b23dbf8e300c22&query=Erlangen&language=en

const val BASE_URL = "http://api.weatherstack.com/"

interface ApixuWeatherApiService {

    @GET("current")
    fun getCurrentWeather(
        @Query("query") location:String,
        @Query("lang") languageCode:String="en"
        ): Deferred<CurrentWeatherResponse>
    // query and language are query URL parameters
    // the query can take some time to response which is why just return CurrentWeatherResponse. This response will be handled by the Coroutines that's why Deferred is used.
    // Deferred helps in making an async call to api, the wait will be triggered as long as no response is been received

    // companion objects are static objects
    companion object{
        operator fun invoke(
            connectivityIntercept: ConnectivityIntercept
        ): ApixuWeatherApiService{
            // lambda function for making a request given the API_KEY and channing the required parameters from the interface query, and URL with API_KEY
            val requestInterceptor = Interceptor{
                chain ->
                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("access_key", API_KEY)
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()
                return@Interceptor chain.proceed(request)
            }
            // creates an okHttpClient request on the chained parameters in requestInterceptor
            val okHttpClient =OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(connectivityIntercept)// we can directly add the Connectivityinterceptor class in here but its causes tight coupling.
                // to overcome this problem we can inject the ConncetivityInterceptor Interface in invoke method
                .build()
            // returns a response from the client after making retrofit call on base_url adds lightweight thread by calling coroutines
            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://api.weatherstack.com/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApixuWeatherApiService::class.java)
        }
    }

}