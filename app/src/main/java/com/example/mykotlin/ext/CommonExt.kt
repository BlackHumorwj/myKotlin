package com.example.mykotlin.ext

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import java.util.*

/**
 * @time 2020/6/11 20:36
 * @desc
 */

/*
扩展点击
 */
fun View.onClick(listeners: View.OnClickListener): View {
    setOnClickListener(listeners)
    return this
}

/*
 扩展点击事件，参数为方法
 */
fun View.onClick(method: () -> Unit): View {
    setOnClickListener { method() }
    return this
}


fun Button.enable(et: EditText, method: () -> Boolean) {
    val btn = this

    et.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            btn.isEnabled = method()
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

    })

}
