package com.example.kotlinAdvanced.test

import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.Executor
import java.util.concurrent.Executors


/**
 * @time 2020/5/22 12:06
 * @desc
 */
class Coroutine {

    fun m1() {

        repeat(10) {

            //开启线程处理
            GlobalScope.launch {
                delay(1000)
                Log.e("xx", ",")
            }

        }
    }

    fun  m2(){

        repeat(10){

            //线程池开启线程处理
            val v = Executors.newSingleThreadExecutor()

            var task = Runnable {

            }

            v.execute(task)
        }


    }

}