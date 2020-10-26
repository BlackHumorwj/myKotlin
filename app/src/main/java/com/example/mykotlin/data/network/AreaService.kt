package com.example.mykotlin.data.network

import androidx.lifecycle.MutableLiveData
import com.example.mykotlin.data.model.area.Province
import retrofit2.Call
import retrofit2.http.GET

/**
 * @author : kingBoy
 * @time 2020/10/23 17:35
 */
interface AreaService {

    @GET("api/china")
    fun getProvinces(): Call<MutableList<Province>>

}