package com.example.kotlinAdvanced

import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.AppData
import com.example.kotlingrammar.R
import org.w3c.dom.Text

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

// let 和 with 内敛函数的结合
fun mRun(textView: TextView){

    var tvName:TextView? = null


    tvName?.run {
        setText("哈哈")
    }

}





