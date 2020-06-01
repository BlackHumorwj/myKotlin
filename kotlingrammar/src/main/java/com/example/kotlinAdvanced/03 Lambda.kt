package com.example.kotlinAdvanced

import com.example.kotlingrammar.age2

/**
 * @time 2020/5/19 11:05
 * @desc
 *
 *  匿名函数
 *  写法：{(参数列表)-> [函数体，最后一行是返回值]}
 *
 *
 */
class Lambda {


    fun main(array: Array<String>) { // (Array<String>)->Unit

        /*-----------------------------------------*/

        //调用sum1
        println(sum1(1, 3))
        //等价 变量调用
        println(sum1.invoke(1, 3))

        /*---------------------------------------*/

        for (i in array) {
            println(i)
        }



        //forEach 是数组扩展函数，遍历数组
        array.forEach { println(it) }

        //完整表达式
        array.forEach({ element -> println(element) })

        //简写1 如果函数最后一个参数是lam表达式，可以移到小括号外面去，如下：
        array.forEach() { element -> println(element) }

        //简写2 如果小括号没有入参，可以省略小括号
        array.forEach { println(it) }

        //简写3 如果lam表达式入参和 实现的表达式入参一致，则将 println 做为入参给 forEach 函数
        array.forEach(::println)





        /*
        //入参为lambda表达式，表达式入参为T类型，返回值类型为Unit
        public inline fun <T> Array<out T>.forEach(action: (T) -> Unit): Unit {
            for (element in this) action(element)
        }
         */

        /*----------------------------------------------*/

        array.forEach {
            if (it == "a") return //return 会直接结束main函数，最后的println()不会被调用，lam表达式不是函数
            println(it)
        }
        println("the end")

        array.forEach ForEach@{
            if (it == "a") return@ForEach //使用 ForEach@标签
            println(it)
        }


        /*----------------------------------*/
        ///** A function that takes 2 arguments. */
        //public interface Function2<in P1, in P2, out R> : Function<R> {
        //    /** Invokes the function with the specified arguments. */
        //    public operator fun invoke(p1: P1, p2: P2): R
        //}
        println(sum1) //Function2<Integer,Integer,Integer> 类型，两个Integer类型入参，一个Integer类型返回值 ；Function2中

        println(::printUsage is () -> Unit) // Function0类型 没有入参，返回值类型Unit

    }


    fun sum(arg1: Int, arg2: Int) = arg1 + arg2

    //将 sum 改造成 lam表达式  (Int,Int)-> Int   两个Int入参 一个Int 返回值
    val sum1 = { arg1: Int, arg2: Int ->
        println("$arg1 + $arg2 = ${arg1 + age2}")
        arg1 + arg2
    } //(Int,Int)-> Int


    //没有入参的lam 表达式
    val pHello = {
        println("hello") // (Any?)->Unit
    }


    //匿名函数
    val int2Long = fun(x: Int): Long { return x.toLong() } //(Int)->Long


    fun printUsage() {
        println("usage")
    }//类型 ()->Unit

}