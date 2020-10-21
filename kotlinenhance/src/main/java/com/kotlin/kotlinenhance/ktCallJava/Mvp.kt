package com.kotlin.kotlinenhance.ktCallJava

/**
 * @author : kingBoy
 * @time 2020/10/21 14:14
 */
abstract class View<out P : Presenter<View<P>>>


abstract class Presenter<out V : View<Presenter<V>>>


class MyView : View<MyPresenter>()

class MyPresenter: Presenter<MyView>()
