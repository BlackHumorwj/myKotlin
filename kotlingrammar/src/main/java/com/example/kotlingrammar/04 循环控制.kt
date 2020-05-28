package com.example.kotlingrammar

/**
 * @time 2020/5/18 19:50
 * @desc
 */
/*
for循环可以对任何提供迭代器（iterator）的对象进行遍历，语法如下
for(item in collection) println(item)


 */

fun m401() {

    var arr = Array(4) {
        it * 3
    }
    for (i in arr.indices) {
        println(arr[i])
    }


}

fun main(any: Array<String>){
    print("hhhh")
}
