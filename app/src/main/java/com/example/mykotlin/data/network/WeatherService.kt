package com.example.mykotlin.data.network

import com.coolweather.coolweatherjetpack.data.model.weather.HeWeather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author : kingBoy
 * @time 2020/11/12 16:30
 */
interface WeatherService {

    @GET("api/weather")
    fun getWeather(@Query("cityid") weatherId: String): Call<HeWeather>


    @GET("api/bing_pic")
    fun getBigPic(): Call<String>

}