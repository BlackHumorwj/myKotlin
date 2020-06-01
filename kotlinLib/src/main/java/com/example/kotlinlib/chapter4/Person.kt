package com.example.kotlinlib.chapter4

/**
 * @time 2020/5/30 14:43
 * @desc
 */
abstract class Person{//抽象类继承也不需要open

    abstract fun work() //抽象的方法继承不需要open
}

class MaNong: Person(){
    override fun work() {


    }

}


class Doctor:Person(){
    override fun work() {

    }

}