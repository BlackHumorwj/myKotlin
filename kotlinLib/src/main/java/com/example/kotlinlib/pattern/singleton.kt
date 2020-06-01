package com.example.kotlinlib.pattern

/**
 * @time 2020/6/1 10:24
 * @desc
 */
class Singletone private constructor() {

    init {
        println("init with obj $this")
    }

    companion object {
        //对外暴露静态方法
        val getInstance = SingletonHolder.holder
    }

    //object  对象声明 单例对象
    private object SingletonHolder {

        val holder = Singletone()
    }

    fun print() = println("printing with object: $this")

}


fun main(){

    Singletone.getInstance.print()
    Singletone.getInstance.print()


}