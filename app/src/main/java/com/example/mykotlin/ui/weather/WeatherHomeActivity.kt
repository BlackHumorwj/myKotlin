package com.example.mykotlin.ui.weather

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mykotlin.R
import com.example.mykotlin.data.network.CoolWeatherNetwork
import com.example.mykotlin.ext.onClick
import com.example.mykotlin.ui.area.AreaRepository
import com.example.mykotlin.ui.area.ChooseAreaViewModel
import kotlinx.android.synthetic.main.activity_weather_home.*
import kotlinx.android.synthetic.main.forecast_item.view.*

/**
 * @author : kingBoy
 * @time 2020/10/23 13:46
 */
class WeatherHomeActivity : AppCompatActivity() {

    var context: Context? = null


    companion object {
        fun newInstance(context: Context?, weatherId: String): Intent {
            val intent = Intent(context, WeatherHomeActivity::class.java)
            intent.putExtra("weatherId", weatherId)
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
        if (intent.hasExtra("weatherId")) {
            val stringExtra = intent.getStringExtra("weatherId")
            viewModel.weatherId = stringExtra
            viewModel.setWeatherCached(stringExtra)
            viewModel.getWeather()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        setContentView(R.layout.activity_weather_home)
        title = "天气"
        initData()
        initEvent()
    }

    private fun initData() {

        if (viewModel.isWeatherCached()) {
            viewModel.weatherId = viewModel.getWeatherCached().toString()
            viewModel.getWeather()
        }else{
            drawerLayout.openDrawer(Gravity.LEFT)
        }
    }

    private fun initEvent() {
        navButton.onClick {
            drawerLayout.openDrawer(Gravity.LEFT)
        }

        viewModel.weather.observe(this, Observer {
            titleCity.text = it.basic.cityName
            titleUpdateTime.text = it.basic.update.updateTime
            degreeText.text = it.now.degree()

            aqiText.text = it.aqi.city.aqi
            pm25Text.text = it.aqi.city.pm25

            forecastLayout.removeAllViews()

            it.forecastList.forEach { it ->
                var view = LayoutInflater.from(context).inflate(R.layout.forecast_item, null)
                view.dateText.text = it.date
                view.infoText.text = it.more.info
                view.maxText.text = it.temperature.max
                view.minText.text = it.temperature.min

                forecastLayout.addView(view)
            }

            comfortText.text = it.suggestion.carWash.info
            carWashText.text = it.suggestion.carWash.info
            sportText.text = it.suggestion.sport.info

        })


    }
}