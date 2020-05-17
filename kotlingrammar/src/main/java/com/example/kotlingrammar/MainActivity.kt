package com.example.kotlingrammar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
/*
https://blog.csdn.net/github_33304260/article/details/80343514
https://www.runoob.com/kotlin/kotlin-basic-types.html
 */
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

        print(sumLambda)

    }


    private fun sayHelloWorld() {
        println("hello world")
    }

}
