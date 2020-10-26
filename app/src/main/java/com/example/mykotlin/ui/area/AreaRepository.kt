package com.example.mykotlin.ui.area

import com.example.mykotlin.data.network.CoolWeatherNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @author : kingBoy
 * @time 2020/10/23 17:14
 */
class AreaRepository(val netWork: CoolWeatherNetwork) {


    suspend fun getProvices() = withContext(Dispatchers.IO) {

        var list = netWork.getProvinceList()

        list
    }


}