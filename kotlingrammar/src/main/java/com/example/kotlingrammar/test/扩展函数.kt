package com.example.kotlingrammar.test

import com.example.kotlingrammar.name

/**
 * @time 2020/5/28 12:26
 * @desc
 */
class User(name: String)


fun User.print() {
    println("用户名$name")
}


/**
 * 对 MutableList 进行扩展，定义方法 swap 交换索引位置的值
 */
fun MutableList<Int>.swap(index1: Int, index2: Int) {

    val temp = this[index1]

    this[index1] = this[index2]
    this[index2] = temp

}