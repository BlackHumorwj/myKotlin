package com.example.mykotlin.data.network

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

/**
 * @author : kingBoy
 * @time 2020/10/23 17:26
 */
object ServiceCreator {

    private const val BASE_URL = "http://guolin.tech/"

    /*
           **打印retrofit信息部分
            */
    private val client = OkHttpClient.Builder()//okhttp设置部分，此处还可再设置网络参数
        .addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger() {
            //打印retrofit日志
            Log.e("RetrofitLog", "retrofitBack = $it");
        }).setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    private val builder = Retrofit.Builder()//
        .baseUrl(BASE_URL)//
        .client(client)//
        .addConverterFactory(ScalarsConverterFactory.create())//
        .addConverterFactory(GsonConverterFactory.create())

    private val retrofit = builder.build()


    fun <T> create(serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)
    }

}