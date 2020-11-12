package com.example.mykotlin.ui.weather

import androidx.lifecycle.MutableLiveData
import com.example.mykotlin.data.model.area.County
import com.example.mykotlin.data.network.CoolWeatherNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @author : kingBoy
 * @time 2020/10/23 17:14
 */
class WeatherRepository(private val netWork: CoolWeatherNetwork) {


    suspend fun getWeather(weatherId: String) = withContext(Dispatchers.IO) {

        var heWeather = netWork.getWeather(weatherId)

        heWeather.weather!![0]

    }

    suspend fun getBigPic( ) = withContext(Dispatchers.IO) {
        var url = netWork.getBigPic( )
        url
    }

}