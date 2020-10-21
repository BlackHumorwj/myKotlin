package com.kotlin.kotlinenhance.javaCallKt;

import android.util.Log;

/**
 * @author : created by
 * @time 2020/10/21 11:23
 */
class UserDemo {

    public static void main(String[] args) {
        final Person person = new Person("小米");
        Log.e("xxx",person.getName());
        person.setName("三星");


    }

}
