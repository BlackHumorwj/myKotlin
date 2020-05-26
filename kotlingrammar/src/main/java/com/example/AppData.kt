package com.example

import android.app.Application
import android.content.Context

/**
 * @time 2020/5/26 11:34
 * @desc
 */
 class AppData : Application() {


    companion object {
        var context: Application? = null
        fun getContext(): Context {
            return context!!
        }

    }


    override fun onCreate() {
        super.onCreate()
        context = this
    }

}