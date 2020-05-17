package com.example.kotlingrammar

/**
 * @time 2020/5/16 21:04
 * @desc
 */
fun test() {

}


class Demo {

}


//region 1、函数定义

//有返回值的函数
fun sum(a: Int, b: Int): Int {//Int 参数，返回值Int
    return a + b;
}

//表达式作为函数体，返回类型自动推断
fun sum1(a: Int, b: Int) = a + b;

fun sum2(a: Int, b: Int): Int = a + b;

//无返回值函数
fun printSum(a: Int, b: Int): Unit {
    println(a + b)
}

//如果返回值是unit类型，则可以省略（对于public方法也是这样）
fun printSum1(a: Int, b: Int) {
    println(a + b)
}
//endregion

//region 2、可变参数函数
// 函数的变长参数可以用 vararg 关键字进行标识
fun vars(vararg v: Int) {
    for (vt in v) {
        println(vt)
    }
}

//  入参中只有一个可变
//fun vars1(vararg v1:Int,vararg v2:Int){
//
//}


//endregion

//region 3、lambda(匿名函数)

val sumLambda: (Int, Int) -> Int = { x, y -> x + y }

//endregion

//region 4、定义常量与变量

//变量定义 var 关键字
// var <标识符> : <类型> = <初始化值>

var v1: Int = 0 //成员变量必须设置初始化值

fun m1() {
    var v2: Int //局部变量可以不设置初始化值，引用的之前必须赋值
}


//不可变量定义：val 关键字，只能赋值一次的变量（类似Java中final修饰符的变量）
//val <标识符> : <类型> =<初始化值>

val haha = "类型推断"


//endregion

//region 5、字符串模板

var name = "小米"

//模板中的简单名称
var value = "name is  $name"


//模板中任意表达式 ${ 表达式 }
var a = "小幺鸡"

var av = "${value.replace("is", "was")},but now is $a"


//endregion

//region 6、NULL检查机制

/*
  Kotlin的空安全设计对于声明可为空的参数，在使用的时候要进行空判断处理，有两种方式，字段后加 ！！
  像Java一样抛出空异常，另一种字段后加?可不做处理返回值为 null或 配合 ?: 做空判断处理
 */

//类型后面加? 表示可为空
var age: String? = "23"

// a age 为 null 直接抛出空指针异常
var ages = age!!.toInt();

// b 不做处理返回 null
var ages1 = age?.toInt()

// c age 为空返回-1
var age2 = age?.toInt() ?: -1;


//定义个方法，当String 不是一个整数时，返回null
fun parseInt(str: String?): Int? = str?.toInt() /*?: -1*/


//endregion

//region 7、类型检测及自动类型转换
/*
 我们可以使用 is 运算符检测 一个表达式是否是某类型的一个实例（类似Java中的 instanceof 关键字）
 */

fun getStringLength(obj: Any): Int? {
    if (obj is String && obj.length > 0) {
        return obj.length;
    }
    return null
}

fun getStringLength2(obj: Any): Int? {
    if (obj !is String) {
        return null
    }
    return obj.length
}


//endregion

//region 8、区间
/*
区间表达式由具有操作符形式 .. 的 rangeTo 函数辅以in 和 !in 形成
 */

fun rangeM() {

    for (i in 1..4) print(i)  //输出 "1234"

    for (i in 4..1) print(i) //什么也不输出

    var j = 8
    if (j in 1..10) { // 等同于 j 在 [1,10]区间内
        print(j)
    }

    //使用step 指定步长
    for (i in 1..4 step 2) print(i)//输出 13

    //使用downTo
    for (i in 4 downTo 1 step 2) print(i)//输出 42

    //使用 until 函数排除结束元素
    for (i in 1 until 10) print(i) //输出 1到9 [1,10)

}

//endregion