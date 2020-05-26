package com.example.kotlingrammar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinAdvanced.Coroutine

/*
https://blog.csdn.net/github_33304260/article/details/80343514
https://www.runoob.com/kotlin/kotlin-basic-types.html
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sayHelloWorld()

        Coroutine().m1()

    }


    private fun sayHelloWorld() {
        println("hello world")
    }

}
