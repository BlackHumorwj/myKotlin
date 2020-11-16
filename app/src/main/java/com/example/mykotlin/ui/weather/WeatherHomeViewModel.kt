package com.example.mykotlin.ui.weather

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coolweather.coolweatherjetpack.data.model.weather.Weather
import com.example.mykotlin.AppData
import kotlinx.coroutines.launch

/**
 * @author : kingBoy
 * @time 2020/11/12 16:27
 */
class WeatherHomeViewModel(private val weatherRepository: WeatherRepository) : ViewModel() {


    var weather = MutableLiveData<Weather>()

    var bingPic = MutableLiveData<String>()

    var refreshing = MutableLiveData<Boolean>()

    var weatherInit = MutableLiveData<Boolean>()

    var weatherId = ""


    fun getWeather() {
        launch({
            weather.value = weatherRepository.getWeather(weatherId)
            weatherInit.value = true
        }, {

        })
    }


    fun getBingPic(refresh: Boolean) {

        launch({
            bingPic.value = weatherRepository.getBigPic()

        }, {

        })


    }


    private fun launch(block: suspend () -> Unit, error: suspend (Throwable) -> Unit) =
        viewModelScope.launch {
            try {
                block()
            } catch (e: Throwable) {
                error(e)
            }
        }

    fun setWeatherCached(weatherId: String?) {
        weatherRepository.setWeatherCached(weatherId)
    }

    fun getWeatherCached() = weatherRepository.getWeatherCached()


    fun isWeatherCached() = weatherRepository.isWeatherCached()

}