package com.example.mykotlin.data.network

import com.example.mykotlin.data.model.area.City
import com.example.mykotlin.data.model.area.County
import com.example.mykotlin.data.model.area.Province
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author : kingBoy
 * @time 2020/10/23 17:35
 */
interface AreaService {

    @GET("api/china")
    fun getProvinces(): Call<MutableList<Province>>


    @GET("api/china/{provinceId}")
    fun getCities(@Path("provinceId") provinceId: String): Call<MutableList<City>>

    @GET("api/china/{provinceId}/{cityId}")
     fun getCounties(@Path("provinceId")provinceId: String,@Path("cityId") cityCode: Int):Call<MutableList<County>>

}