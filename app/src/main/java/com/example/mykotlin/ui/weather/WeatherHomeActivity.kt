package com.example.mykotlin.ui.weather

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mykotlin.R
import com.example.mykotlin.ext.onClick
import kotlinx.android.synthetic.main.activity_weather_home.*

/**
 * @author : kingBoy
 * @time 2020/10/23 13:46
 */
class WeatherHomeActivity : AppCompatActivity() {

    companion object {
        fun newInstance(context: Context): Intent {
            return Intent(context, WeatherHomeActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_home)
        title = "天气"

        initEvent()

    }

    private fun initEvent() {

        navButton.onClick {

        }

    }
}