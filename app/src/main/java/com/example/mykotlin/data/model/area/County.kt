package com.example.mykotlin.data.model.area

import com.google.gson.annotations.SerializedName

/**
 * @author : kingBoy
 * @time 2020/10/23 16:44
 */
data class County (@SerializedName("name") val countyName: String,@SerializedName("id") val countyId: String, @SerializedName("weather_id")val weatherId: String)