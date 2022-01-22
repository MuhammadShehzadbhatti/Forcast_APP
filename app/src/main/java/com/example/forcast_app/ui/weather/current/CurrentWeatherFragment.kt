package com.example.forcast_app.ui.weather.current

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.forcast_app.R
import com.example.forcast_app.data.ApixuWeatherApiService
import com.example.forcast_app.data.network.WeatherNetworkDataSource
import com.example.forcast_app.data.network.WeatherNetworkDataSourceImpl
import com.example.forcast_app.data.network.response.ConnectivityIntercept
import com.example.forcast_app.data.network.response.ConnectivityInterceptImpl
import com.example.forcast_app.databinding.ActivityMainBinding
import com.example.forcast_app.databinding.CurrentWeatherFragmentBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CurrentWeatherFragment : Fragment(R.layout.current_weather_fragment) {

    private lateinit var binding: CurrentWeatherFragmentBinding

    companion object {
        fun newInstance() = CurrentWeatherFragment()
    }

    private lateinit var viewModel: CurrentWeatherViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = CurrentWeatherFragmentBinding.bind(view)

    }

   /* override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CurrentWeatherFragmentBinding.inflate(inflater,container,false)
        //return inflater.inflate(R.layout.current_weather_fragment, container, false)
        return binding.root
    }*/

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CurrentWeatherViewModel::class.java)
        // TODO: Use the ViewModel

        val apiService = ApixuWeatherApiService(ConnectivityInterceptImpl(this.requireContext()))
        val weatherNetworkDataSource = WeatherNetworkDataSourceImpl(apiService)
        weatherNetworkDataSource.downloadedCurrentWeather.observe(viewLifecycleOwner, Observer {
            binding.currentWeatherText.text = it.toString()
        })

        GlobalScope.launch(Dispatchers.Main){
            val currentWeatherResponse = apiService.getCurrentWeather("Erlangen").await()
            println("this is response: "+ currentWeatherResponse.currentWeatherEntry.toString())
            binding.currentWeatherText.text = currentWeatherResponse.toString()
            weatherNetworkDataSource.fetchCurrentWeather("Erlangen","en")
        }
    }

}