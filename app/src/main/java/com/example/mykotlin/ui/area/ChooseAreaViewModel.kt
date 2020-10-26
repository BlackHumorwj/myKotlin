package com.example.mykotlin.ui.area

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mykotlin.data.model.area.City
import com.example.mykotlin.data.model.area.County
import com.example.mykotlin.data.model.area.Province
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * @author : kingBoy
 * @time 2020/10/23 16:35
 */
class ChooseAreaViewModel(private val repository: AreaRepository) : ViewModel() {

    var currentLevel = MutableLiveData<Int>()

    var dataChanged = MutableLiveData<Int>()

    var isLoading = MutableLiveData<Boolean>()

    var areaSelected = MutableLiveData<Boolean>()

    var selectedProvince: Province? = null
    var selectedCity: City? = null
    var selectedCounty: County? = null


    lateinit var provices: MutableList<Province>

    lateinit var city: MutableLiveData<City>

    lateinit var counties: MutableLiveData<County>

    val dataList = ArrayList<String>()


    fun getProvinces() {

        launch {
            provices = repository.getProvices()

            dataList.addAll(provices.map { it.provinceName })
        }


    }

    /**
     * 入参是个函数
     */
    private fun launch(block: suspend () -> Unit) = GlobalScope.launch {
        try {
          //  isLoading.value = true
            dataList.clear()
            block()
          //  dataChanged.value = dataChanged.value?.plus(1)
         //   isLoading.value = false
        } catch (t: Throwable) {
            t.printStackTrace()
           // Toast.makeText(CoolWeatherApplication.context, t.message, Toast.LENGTH_SHORT).show()
          //  dataChanged.value = dataChanged.value?.plus(1)
          //  isLoading.value = false
        }
    }


}