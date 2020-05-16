package com.example.kotlingrammar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sayHelloWorld()

        test()
        var result = sum1(1, 3)
        print(result)

        vars(1, 2, 1, 22, 25)

        var v2: Int = 10

        print(v2);

    }


    private fun sayHelloWorld() {
        println("hello world")
    }

}
