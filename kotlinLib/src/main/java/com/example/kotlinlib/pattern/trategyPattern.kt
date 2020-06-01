package com.example.kotlinlib.pattern

/**
 * @time 2020/6/1 10:09
 * @desc 策略模式
 */
class Printer(private val stringFormatterStrategy: (String) -> String) {
    fun printString(string: String) {
        //策略模板：入参String 返回 String
        println(stringFormatterStrategy.invoke(string))
    }
}


val lowerCaseFormatter: (String) -> String = { it.toLowerCase() }

val upperCaseFormatter = { it: String -> it.toUpperCase() }

fun main() {

    var printer1 = Printer(lowerCaseFormatter)
    printer1.printString("hello WORLD")


    var printer2 = Printer(upperCaseFormatter)
    printer2.printString("hello world")


    var printer3 = Printer() { "嘻哈中国 $it" }
    printer3.printString("睡眼朦胧")


}
