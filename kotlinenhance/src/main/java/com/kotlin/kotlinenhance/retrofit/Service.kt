package com.kotlin.kotlinenhance.retrofit

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


/**
 * @time 2020/10/21 10:25
 * @desc Retrofit
 */
interface GithubService {

    @GET("enbandari/Kotlin-Tutorials/stargazers")
    fun getStarGazers(): Call<List<User>>
}


object Service {

    //懒加载
    val getGithubService: GithubService by lazy {
        Retrofit.Builder().baseUrl("https://api.github.com/repos/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(GithubService::class.java)
    }
}


fun main() {
    Service.getGithubService.getStarGazers().execute().body()?.map {
        println(it.login)
    }
}