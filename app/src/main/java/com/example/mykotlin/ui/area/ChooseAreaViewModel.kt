package com.example.mykotlin.ui.area

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mykotlin.data.model.area.City
import com.example.mykotlin.data.model.area.County
import com.example.mykotlin.data.model.area.Province
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

    lateinit var cities: MutableList<City>

    lateinit var counties: MutableList<County>

    val dataList = ArrayList<String>()

    init {


    }


    /**
     * 获取 省份
     */
    fun getProvinces() {
        currentLevel.value = ChooseAreaFragment.LEVEL_PROVINCE
        launch {
            provices = repository.getProvinces()

            dataList.addAll(provices.map { it.name })
        }
    }

    /**
     * 获取 城市
     */
    private fun getCities() {
        selectedProvince?.let {
            currentLevel.value = ChooseAreaFragment.LEVEL_CITY
            launch {
                cities = repository.getCities(it.id)

                dataList.addAll(cities.map { it.cityName })

            }
        }
    }

    /**
     * 获取 区/县
     */
    private fun getCounties() {
        selectedCity?.let {
            currentLevel.value = ChooseAreaFragment.LEVEL_COUNTY
            launch {
                counties = repository.getCounties(it.provinceId, it.cityCode)

                dataList.addAll(counties.map { it.countyName })
            }
        }
    }


    fun onItemClick(position: Int) {
        when (currentLevel.value) {
            ChooseAreaFragment.LEVEL_PROVINCE -> {
                selectedProvince = provices[position]
                //获取城市
                getCities()
            }
            ChooseAreaFragment.LEVEL_CITY -> {
                //获取 区/县天气信息
                selectedCity = cities[position]
                getCounties()
            }
            ChooseAreaFragment.LEVEL_COUNTY -> {
                selectedCounty = counties[position]
                areaSelected.value = true

            }
        }
    }


    fun onBack() {

        when (currentLevel.value) {
            ChooseAreaFragment.LEVEL_COUNTY -> {
                getCities()
            }
            ChooseAreaFragment.LEVEL_CITY -> {
                getProvinces()
            }
        }

    }



    /**
     * 入参是个函数
     */
    private fun launch(block: suspend () -> Unit) = viewModelScope.launch {
        try {
            isLoading.value = true
            dataList.clear()
            block()
            dataChanged.value = dataChanged.value?.plus(1)
            isLoading.value = false
        } catch (t: Throwable) {
            t.printStackTrace()
            dataChanged.value = dataChanged.value?.plus(1)
            isLoading.value = false
        }
    }




}