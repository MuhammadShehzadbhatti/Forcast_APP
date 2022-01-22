package com.example.forcast_app.data.network.response

import okhttp3.Interceptor

// This interface handles the network connection like Internet. if there is no internet connection then this interface notify the user to turn on the data or internet.
interface ConnectivityIntercept : Interceptor {
}