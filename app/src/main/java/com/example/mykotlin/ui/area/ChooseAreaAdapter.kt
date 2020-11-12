package com.example.mykotlin.ui.area

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mykotlin.R
import com.example.mykotlin.ext.onClick
import kotlinx.android.synthetic.main.item_choose_area.view.*

/**
 * @author : kingBoy
 * @time 2020/10/23 16:08
 */
class ChooseAreaAdapter(private val context: Context, private val list: List<String>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var mCallBack: CallBack

    interface CallBack {
        fun onItemClick(item: Int)
    }

    fun setOnItemClick(callBack: CallBack) {
        this.mCallBack = callBack
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_choose_area, parent, false);

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is Holder) {
            val name = list[position]
            holder.itemView.tvName.text = name


            holder.itemView.setOnClickListener {
                mCallBack?.onItemClick(position)
            }

        }

    }


    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(name: String) {
            itemView.tvName.text = name


        }


    }


}