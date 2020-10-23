package com.example.mykotlin.ui.area

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mykotlin.R
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author : kingBoy
 * @time 2020/10/23 15:16
 */
class ChooseAreaFragment : Fragment() {

    private val mList: List<String> by lazy { ArrayList<String>() }

    private val viewModel by lazy {
        ViewModelProvider(this)[ChooseAreaViewModel::class.java]
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
        recycler_view.adapter = ChooseAreaAdapter(requireContext(), mList)

        initEvent()
    }

    private fun initEvent() {

        viewModel.getProvines()





    }


}