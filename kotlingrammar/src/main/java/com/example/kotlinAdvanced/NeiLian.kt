package com.example.kotlinAdvanced

import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.AppData
import com.example.kotlingrammar.R

/**
 * @time 2020/5/26 11:28
 * @desc
 */

fun mLet(textView: TextView) {

    textView.let {
        it.text = "let测试"
    }

    //统一做非空判断
    textView?.let {

    }

}

fun mWith(textView: TextView) {

    with(textView) {
        //直接访问 TextView 对象内的公共方法
        text = "哈哈库"
        setTextColor(ContextCompat.getColor(AppData.getContext(), R.color.colorAccent))
    }


}





