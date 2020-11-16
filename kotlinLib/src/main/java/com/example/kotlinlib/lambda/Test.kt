package com.example.kotlinlib.lambda

/**
 * @author : kingBoy
 * @time 2020/11/12 21:00
 */
fun main(args: Array<String>) {

    args.forEach forEach@{

        if (it == "q") return forEach@

        println(it)
    }

    println("the end ")

    sum.invoke(1, 3)


}

//Lambda表达式
// 写法：
// {[参数列表]-> [函数体，最后一行是返回值]}
//匿名函数 function2
// 类型：
// (Int,Int) ->Int
val sum = { a: Int, b: Int -> a + b }


/*
高阶函数：
    f(g(x))

 */

fun main2(args: Array<String>) {

    //::println 双冒号 拿到包级方法引用
    args.forEach(::println)

    //拿到 world 方法的引用
    val hello = Hello::world

    //isNotEmpty 是个扩展方法，默认有个入参
    args.filter(String::isNotEmpty)


    val pdfPrinter = PdfPrinter()


    //forEach方法接收这种类型的入参 (T) -> Unit
    args.forEach(pdfPrinter::println)

}


class PdfPrinter {
    fun println(any: Any?) {

    }
}


class Hello {
    fun world() {
        println("hello world")

    }

}

