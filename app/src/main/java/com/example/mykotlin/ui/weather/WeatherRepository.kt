package com.example.mykotlin.ui.weather

import android.content.Context
import androidx.core.content.edit
import com.example.mykotlin.AppData
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

    suspend fun getBigPic() = withContext(Dispatchers.IO) {
        var url = netWork.getBigPic()
        url
    }

    fun setWeatherCached(weatherId: String?) {
        val sharedPreferences = AppData.context?.getSharedPreferences("cache", Context.MODE_PRIVATE)
        sharedPreferences?.edit()?.putString("weatherId", weatherId)?.apply()
    }

    fun getWeatherCached(): String? {
        val sharedPreferences = AppData.context?.getSharedPreferences("cache", Context.MODE_PRIVATE)
        return sharedPreferences?.getString("weatherId", "")
    }


    fun isWeatherCached() = getWeatherCached() != null

}