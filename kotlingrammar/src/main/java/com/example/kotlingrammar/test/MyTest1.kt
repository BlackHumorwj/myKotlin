package com.example.kotlingrammar.test

/**
 * @time 2020/5/24 11:12
 * @desc
 */
class Student(val name: String) {

    //需要使用 this 代理主构造函数
    constructor(name: String, age: Int) : this(name) {

    }
}


class Stu {
    constructor(name: String) {
    }

    fun test() {
        var stu = Stu("李四")

        //  var createMe = DontCreateMe()
    }

}


class DontCreateMe private constructor() {

}


open class Base {
    open fun f() {}
}

abstract class Derived : Base() {
    abstract override fun f()
}


//嵌套类
class Outer { //外部类

    private val bar: Int = 1

    class Nested { //嵌套类
        fun foo() = 2
    }

    fun test() {
        var num = Outer.Nested().foo() //调用格式：外部类.嵌套类.嵌套类方法/属性

    }
}


//内部类
class Outer1 {
    private val bar: Int = 1
    var v = "成员属性"

    //嵌套内部类
    inner class Inner {
        fun foo() = bar //访问外部类成员

        fun innerTest() {
            var o = this@Outer1 //获取外部类的成员变量

            println("内部类可以引用外部的成员 ${o.v} 或者 $v")

        }
    }

    fun test() {

        val demo = Outer1().Inner().foo()

        val demo2 = Outer1().Inner().innerTest()// 内部类可以引用外部类的成员，例如：成员属性

    }

}


//匿名内部类
class Test {
    var v = "成员属性"

    fun setInterface(test: TestInterface) {
        test.test()
    }
}

//定义接口
interface TestInterface {
    fun test()
}

fun testMy(){

    var test = Test()

    /**
     * 采用对象表达式来创建接口对象，即匿名内部类的实例
     */
    test.setInterface(object : TestInterface{
        override fun test() {
            println("对象表达式创建匿名内部类的实例")
        }
    })

}





