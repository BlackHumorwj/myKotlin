package com.kotlin.kotlinenhance.javaCallKt

import android.text.TextUtils

/**
 * @author : kingBoy
 * @time 2020/10/21 11:54
 */
fun  String.noEmpty():Boolean{
    return TextUtils.isEmpty(this)
}