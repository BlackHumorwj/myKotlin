package com.kotlin.kotlinenhance.retrofit

import kotlin.math.log

/**
 * @time 2020/10/21 10:26
 * @desc
 */
data class User(val login: String) {
    override fun toString(): String {
        return login
    }
}