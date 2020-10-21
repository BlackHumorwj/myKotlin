package com.kotlin.kotlinenhance.map

/**
 * @time 2020/10/20 16:17
 * @desc
 */
fun main(arg: Array<out String>) {

    //map使用 数组遍历
    arg.map({
        //it 迭代器
        print(it)
    })

    arg.map(::println)

}

/**
 * flatMap 使用
 */
fun main1(vararg arg: String) {

    arg.flatMap {
        it.split("_")
    }.map {
        print("$it ")
    }

}


