package com.example.mykotlin.ui.area

import androidx.lifecycle.MutableLiveData
import com.example.mykotlin.data.model.area.County
import com.example.mykotlin.data.network.CoolWeatherNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @author : kingBoy
 * @time 2020/10/23 17:14
 */
class AreaRepository(private val netWork: CoolWeatherNetwork) {


    suspend fun getProvinces() = withContext(Dispatchers.IO) {

        var list = netWork.getProvinceList()

        list
    }

    suspend fun getCities(provinceId: String) = withContext(Dispatchers.IO) {
        var list = netWork.getCities(provinceId)

        list.forEach {
            it.provinceId = provinceId
        }

        list
    }

   suspend fun getCounties(provinceId: String, cityCode: Int) = withContext(Dispatchers.IO) {
        var list = netWork.getCounties(provinceId,cityCode)

        list

    }


}