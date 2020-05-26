package com.example.kotlingrammar.test

/**
 * @time 2020/5/24 18:33
 * @desc
 */
open class IBase(var name: String) {

}

class IBaseImpl(name: String) : IBase(name) {

}

//子类有主构造函数
open class P1(var name: String, var age: Int) { //基类


   open val x: Int = 12


    open fun study() {

    }
}


interface P11 {
    fun study() {};
}


class P1Impl(name: String, age: Int, var scope: Int) : P1(name, age) {//实现类

}


//子类没有主构造函数
class P2 : P1, P11 {

    override var x = 11

    constructor(name: String, age: Int, scope: Int) : super(name, age) {

    }

    override fun study() {
        super<P1>.study()
        super<P11>.study()
    }

}

