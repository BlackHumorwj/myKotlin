package com.example.mykotlin.data.model.area

import com.google.gson.annotations.SerializedName

/**
 * @author : kingBoy
 * @time 2020/10/23 16:44
 */
data class City(
    @SerializedName("name") val cityName: String,
    @SerializedName("id") val cityCode: Int
) {

    var provinceId = ""
}