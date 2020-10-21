package com.kotlin.kotlinenhance.rx

import io.reactivex.Observable
import io.reactivex.functions.Consumer
import io.reactivex.parallel.ParallelFlowable.from
import java.io.File

/**
 * @time 2020/10/20 16:48
 * @desc
 */
fun f1() {

    //val text = File(ClassLoader.getSystemResource("input").path).readText()

    val text = "xxxsdddssdd dsssdd dsdsds dsdsd dssss";

    Observable.fromIterable(text.toCharArray().asIterable())//
        .filter { !it.isWhitespace() }//过滤空格
        .groupBy { it }//
        .map { o ->
            //分组后的对象
            o.count().subscribe(Consumer { print("${o.key}->$it") })

        }.subscribe()


}