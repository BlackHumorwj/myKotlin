package com.example.kotlingrammar.test

/**
 * @time 2020/5/22 11:10
 * @desc
 */
class MyTest {

    lateinit var sub: String

    fun setup() {
        sub = "关键字 lateinit"
    }

    fun test() {
        var text = sub.substring(0);
    }
}


class TestSubject {
    var age: Int = 10

}

class Person constructor(var lastName: String) {

    init {
        lastName = "李四"
    }

}

class Runoob constructor(name: String) {

    var url = "www.xiaoyaoji.com"
    var country = "CN"
    var siteName = name

    init {
        println("$name")
    }

    fun printTest(){
        var rb = Runoob("中国之声")
        val siteName1 = rb.siteName

        println("我是类函数")

    }
}

