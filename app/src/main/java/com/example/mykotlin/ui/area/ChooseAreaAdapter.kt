package com.example.mykotlin.ui.area

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mykotlin.R
import kotlinx.android.synthetic.main.item_choose_area.view.*

/**
 * @author : kingBoy
 * @time 2020/10/23 16:08
 */
class ChooseAreaAdapter(private val context: Context, private val list: List<String>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_choose_area, parent, false);

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is Holder) {
            holder.bind(list[position])
        }

    }


    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(name: String) {
            itemView.tvName.text = name
        }


    }


}