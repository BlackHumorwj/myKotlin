package com.example.mykotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_todo_add.*

/**
 * @time 2020/5/26 10:22
 * @desc
 */
class TodoAddActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_add)

        val dataString = intent.dataString

        Log.e("xxx", "$dataString ");

        btnSave.setOnClickListener(View.OnClickListener {

            var intent = Intent()
            intent.putExtra("name", etName.text.toString())
            intent.putExtra("mobile", etMobile.text.toString())
            intent.putExtra("address", etAddress.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        })

    }

}