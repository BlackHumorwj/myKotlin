package com.example.mykotlin.data.network

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * @author : kingBoy
 * @time 2020/10/23 17:21
 */
class CoolWeatherNetwork {
    private val placeService = ServiceCreator.create(AreaService::class.java)


    suspend fun getProvinceList() = placeService.getProvinces().await()


    private suspend fun <T> Call<T>.await(): T {

        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }

                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val value = response.body()
                    if (response.isSuccessful && value != null) {
                        continuation.resume(value)
                    } else {
                        continuation.resumeWithException(RuntimeException(""))
                    }
                }

            })
        }
    }


    companion object {

        private var network: CoolWeatherNetwork? = null

        fun getInstance(): CoolWeatherNetwork {
            if (network == null) {
                synchronized(CoolWeatherNetwork::class.java) {
                    if (network == null) {
                        network = CoolWeatherNetwork()
                    }
                }
            }
            return network!!
        }


    }


}

