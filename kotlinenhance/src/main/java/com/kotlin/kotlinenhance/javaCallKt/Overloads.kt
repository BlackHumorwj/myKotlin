package com.kotlin.kotlinenhance.javaCallKt

/**
 * @author : kingBoy
 * @time 2020/10/21 11:38
 */
class Overloads {


    @JvmOverloads
    fun overloads(a: Int, b: Int = 0, c: Int = 1) {
        println("$a----$b----$c")
    }
}