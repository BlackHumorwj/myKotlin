package com.example.kotlingrammar.test

/**
 * @time 2020/5/25 20:34
 * @desc
 */
interface MyInterface {

    //接口中的属性只能是抽象的，不允许初始化值
    var name:String

    fun bar()
    //kotlin接口中允许方法默认实现
    fun foo() {
     println("实现的方法")
    }
}

class Child : MyInterface{
    override var name: String
        get() = "哈哈"
        set(value) {}

    override fun bar() {
    }

}
