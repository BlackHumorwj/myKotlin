package com.example.mykotlin.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

/**
 * @author : kingBoy
 * @time 2020/10/23 17:26
 */
object ServiceCreator {

    private const val BASE_URL = "http://guolin.tech/"

    private val httpClient = OkHttpClient.Builder()


    private val builder = Retrofit.Builder()//
        .baseUrl(BASE_URL)//
        .client(httpClient.build())//
        .addConverterFactory(ScalarsConverterFactory.create())//
        .addConverterFactory(GsonConverterFactory.create())

    private val retrofit = builder.build()

    fun <T> create(serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)
    }

}