package com.example.kotlingrammar

/**
 * @time 2020/5/18 19:12
 * @desc
 */

fun m301(check: Boolean) {

    //if 表达式
    var value = if (check) "选中" else "未选中"

}


//使用区间 x..y
fun m302() {
    var x = 5
    var y = 8

    if (x in 1..8) {
        print("$x 在区间内")
    }
}


//when 表达式
fun m303(x: String) {

    when (x) {
        "1" -> println("x==1")
        "2" -> println("x==2")
        "3" -> println("x==3")
        else -> println("打印其他日志")
    }


    when (x) {
        "1", "2" -> println("x is 1 or 2")
        else -> println("输出点日志")
    }

    when (x.toInt()) {
        in 0..10 -> print(x)
        !in 10..80 -> println("哈哈 = $x")
        else -> println("else")
    }


    var v1: Any = 100

    when (v1) {
        is String -> v1.startsWith("haha")
    }

    var items = setOf("apple", "banana", "kiwi")
    when {
        "aa" in items -> println(true)
        "bb" in items -> println("什么鬼")
    }


}
