package com.example.kotlingrammar

import kotlin.IllegalArgumentException


//region 1、字面常量

//基本数据类型
var double: Double = 122.0 //64位字符宽度
var float: Float = 11.25f //32 使用 f或者 F 后缀
var long: Long = 64 //64
var int: Int = 1000 //32
var short: Short = 15 //16
var byte: Byte = 41 //8

//字面量

//十进制：123
//长整型以大写的L结尾
var l = 123L

//16进制以0x开头
var x16 = 0x0f

//2进制以0b开头
var var1 = 0b001001

//8进制不支持

//下划线使数字常量更易读
val oneMillion = 1_000_000
val creditCardNUm = 1234_567_6667L
val hexBytes = 0xff_ec_de

//endregion

//region 2、比较两个数字
/*
kotlin中没有基础的数据类型，只有封装的数字类型
你每定义一个变量，其实kotlin帮你封装了一个对象

 三个等号比较 对象地址
 两个等号比较 两个值大小
 */
fun m2(v1: Int, v2: Int): Boolean {
    return v1 == v2 //数值是否相等

//    return v1===v2 //对象地址是否相等
}


//endregion

//region 3、类型转换
/*
 由于不同的表示方式，较小类型并不是较大类型的子类型，较小类型不能隐式转换为较大的类型。
 这意味着不进行显示转换的情况下我们不能把byte类型赋值给int变量
 */

val b: Byte = 1

//val i :Int = b 不能直接赋值
val i1: Int = b.toInt() // OK

fun toM() {
    var toOrg: Int = 10;

    toOrg.toChar()
    toOrg.toFloat()
    toOrg.toDouble()
    toOrg.toLong()
    toOrg.toByte()
}


//endregion

//region 4、位操作符

/*
 对于 Int 和 Long 类型，还有一系列的为操作符可以使用，分别是：
 */

fun shiftM() {
    var shiftVar = 100;

    var shiftVall = shiftVar.shl(1)//左移位
    var shiftValr = shiftVar.shr(1)//右移位

    shiftValr.ushr(1)//无符号右移

    shiftVar.and(12)//与
    shiftValr.or(10)//或
    shiftValr.xor(12)//异或
    shiftValr.inv()//反向

}


//endregion

//region 5、字符

fun check(c: Char): Int {
    if (c in '0'..'9') {
        return c.toInt() - '0'.toInt()//显示转换为数字
    }
    throw IllegalArgumentException(" out of range")
}


//endregion

//region 6、布尔
/*
|| - 短路逻辑或
&& - 短路逻辑与
！ 逻辑非
 */

//endregion

//region 7、数组

/*
1、数字创建的两种方式：
   使用函数arrayOf()
   使用工厂函数
 */

var arrays = arrayOf(1, 2, 3)

var arrays1 = Array(3) { i -> (i * 2) } //0,2,4

// 与 java 不同的是，Kotlin中的数组是不型变的（invariant）
// 除了类 Array ，还有 ByteArray ShortArray IntArray ,用来表示各个类型的数组，省去了装箱操作，因此
//效率更高
var arr1 = ShortArray(1) { i -> ((i * 2).toShort()) }
var arr2 = intArrayOf(1, 2, 3)

//endregion

//region 8、字符串

var str: String = "haha"

fun stringM(string: String) {
    for (c in string) {
        println(c)
    }

    var str = """多行字符串
        |多行字符串
        |多行字符串
        |多行字符串
    """.trimMargin() //前置空格删除

    //默认 | 用作边界前缀，但你可以选择其他字符并作为参数传入，比如 trimMargin(">")。

}


//endregion

//region 9、字符串模板

fun StringTemplate() {
    val i = "100000"

    val s = "i = $i"

    //任意表达式
    var s1 = "$i .length is ${i.length}"


    var price = "${'$'} 9.99"


}


//endregion