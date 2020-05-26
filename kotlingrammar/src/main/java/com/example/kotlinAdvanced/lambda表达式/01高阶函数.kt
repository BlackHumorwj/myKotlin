package com.example.kotlinAdvanced.lambda表达式

/**
 * @time 2020/5/19 10:23
 * @desc
 */
/*
高阶函数-Higher-Order-Function

    java里是不允许把方法作为参数传递的，但是我们可以通过接口来实现。我们可以通过接口的方法来把方法
    包装起来

 */

interface Wrapper {
    fun method(param: Int): Int
}

fun a(wrapper: Wrapper): Int {
    return wrapper.method(10)
}


/*
 在kotlin中，函数参数也可以是 函数类型的

 fun a(funParam:Fun):String{
   return funParam(1)
 }


 函数类型不是一个类型，而是一 类类型，

 对于 函数类型的参数，要指明 它有几个参数，参数的类型以及返回值类型

 */

/*
  函数参数类型：入参1个int类型 返回值String
 */
fun a1(funParams: (Int) -> String): String {
    return funParams(10)
}

/*
 * 函数返回值为 函数类型
 */
fun a1Test(): (String) -> Int {

    return { it.toInt() }

}


/*
  函数的类型不只可以作为函数的参数类型，还可以作为函数的返回值类型，
  这种[参数或者返回值为函数类型的函数]，在Kotlin中称为【高阶函数】- Higher-Order-Function
 */



