package com.example.mykotlin.ui.area

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mykotlin.MainActivity
import com.example.mykotlin.R
import com.example.mykotlin.data.network.CoolWeatherNetwork
import com.example.mykotlin.ui.area.ChooseAreaAdapter.CallBack
import com.example.mykotlin.ui.weather.WeatherHomeActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_weather_home.*

/**
 * @author : kingBoy
 * @time 2020/10/23 15:16
 */
class ChooseAreaFragment : Fragment() {

    private lateinit var mAdapter: ChooseAreaAdapter


    private val viewModel by lazy {
        ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(ChooseAreaViewModel::class.java)) {
                    return ChooseAreaViewModel(AreaRepository(CoolWeatherNetwork.getInstance())) as T
                }
                throw  IllegalArgumentException(" unKnown ViewModel class ")
            }

        })[ChooseAreaViewModel::class.java]
    }

    companion object {

        const val LEVEL_PROVINCE = 0
        const val LEVEL_CITY = 1
        const val LEVEL_COUNTY = 2

        fun newInstance(): ChooseAreaFragment {
            val args = Bundle()
            val fragment = ChooseAreaFragment()
            fragment.arguments = args
            return fragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(context).inflate(R.layout.fragment_choose_area, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_view.layoutManager = LinearLayoutManager(context)
        mAdapter = ChooseAreaAdapter(requireContext(), viewModel.dataList)
        recycler_view.adapter = mAdapter


        initEvent()
        initObserve()
        initData()
    }

    private fun initData() {
        viewModel.getProvinces()
    }

    private fun initObserve() {
        viewModel.dataChanged.observe(viewLifecycleOwner, Observer {
            mAdapter.notifyDataSetChanged()
        })

        viewModel.areaSelected.observe(viewLifecycleOwner, Observer {
            if (it && viewModel.selectedCounty != null) {
                var intent = WeatherHomeActivity.newInstance(activity,viewModel.selectedCounty!!.weatherId)
                startActivity(intent)

                if (activity is WeatherHomeActivity){
                    activity?.drawerLayout?.closeDrawer(Gravity.LEFT)
                }
                viewModel.areaSelected.value = false
            }
        })

    }

    private fun initEvent() {
        mAdapter.setOnItemClick(object : CallBack {
            override fun onItemClick(item: Int) {
                viewModel.onItemClick(item)
            }
        })
    }


}