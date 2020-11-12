package com.example.mykotlin.ui.weather

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mykotlin.R
import com.example.mykotlin.data.network.CoolWeatherNetwork
import com.example.mykotlin.ext.onClick
import com.example.mykotlin.ui.area.AreaRepository
import com.example.mykotlin.ui.area.ChooseAreaViewModel
import kotlinx.android.synthetic.main.activity_weather_home.*

/**
 * @author : kingBoy
 * @time 2020/10/23 13:46
 */
class WeatherHomeActivity : AppCompatActivity() {

    companion object {
        fun newInstance(context: Context?,weatherId:String): Intent {
            val intent = Intent(context, WeatherHomeActivity::class.java)
            intent.putExtra("weatherId",weatherId)
            return intent
        }
    }

    private val viewModel by lazy {
        ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(WeatherHomeViewModel::class.java)) {
                    return WeatherHomeViewModel(WeatherRepository(CoolWeatherNetwork.getInstance())) as T
                }
                throw  IllegalArgumentException(" unKnown ViewModel class ")
            }
        })[WeatherHomeViewModel::class.java]
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)

        if (intent.hasExtra("weatherId")){
            viewModel.weatherId = intent.getStringExtra("weatherId")
            viewModel.getWeather()
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
            drawerLayout.openDrawer(Gravity.LEFT)
        }

    }
}