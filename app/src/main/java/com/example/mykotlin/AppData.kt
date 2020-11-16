package com.example.mykotlin

import android.app.Application
import android.content.Context

/**
 * @author : kingBoy
 * @time 2020/11/16 10:59
 */
class AppData : Application() {

    companion object {

        var instance: AppData? = null
        var context:Context? = null
    }


    override fun onCreate() {
        super.onCreate()
        instance = this
        context = this
    }


    /**
     * 1、缓存
     */

}