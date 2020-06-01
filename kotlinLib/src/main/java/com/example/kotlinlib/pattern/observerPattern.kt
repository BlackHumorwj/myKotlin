package com.example.kotlinlib.pattern

import kotlin.properties.Delegates

/**
 * @time 2020/6/1 10:00
 * @desc 观察者模式
 */
interface TextChangedListener {
    fun onTextChanged(newText: String)
}

class PrintingTextChangeListener : TextChangedListener {
    override fun onTextChanged(newText: String) {
        println("text changed $newText")
    }
}


class TextView {

    var listener: TextChangedListener? = null


    var text: String by Delegates.observable("") { property, oldValue, newValue ->
        listener?.onTextChanged(newValue)
    }
}

fun main() {

    val textView = TextView()
    textView.listener = PrintingTextChangeListener()
    textView.text = "嘻哈中国"
    textView.text = "what is this"


}


